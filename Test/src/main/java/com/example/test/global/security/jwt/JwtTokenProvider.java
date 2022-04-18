package com.example.test.global.security.jwt;

import com.example.test.domain.auth.domain.RefreshToken;
import com.example.test.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.test.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtproperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String id) {
        return generateToken(id, "access", jwtproperties.getAccessExp());
    }

    public String generateRefreshToken(String id) {
        String refreshToken = generateToken(id,"refresh", jwtproperties.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(id)
                .token(refreshToken)
                .timeToLive(jwtproperties.getRefreshExp())
                .build());

        return refreshToken;
    }

    //jwt 토큰 생성
    private String generateToken(String id, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtproperties.getSecretKey())
                .setSubject(id)
                .claim("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    //jwt 토큰으로 인증 정보를 조회
    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰을 복호화 후 token정보들을 리턴
    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(jwtproperties.getSecretKey())
                .parseClaimsJws(token).getBody();
    }

    // getTokenBody를 이용해서 token의 subject(제목)을 받아옴
    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    //request의 header에서 token 파싱
    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtproperties.getHeader());
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtproperties.getPrefix()))
            return bearerToken.replace(jwtproperties.getPrefix(), "");
        return null;
    }
}
