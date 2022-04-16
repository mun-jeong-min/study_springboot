package com.example.test.global.security.jwt;

import com.example.test.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final Jwtproperties jwtproperties;
    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String id) {
        return generateToken(id, "access", jwtproperties.getAccessExp());
    }

    //jwt 토큰 생성
    public String generateToken(String id, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtproperties.getSecretKey())
                .setSubject(id)
                .claim("type", type)
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
}
