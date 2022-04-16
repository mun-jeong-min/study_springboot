package com.example.test.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")

public class Jwtproperties {

    private final String secretKey;
    private final Long accessExp;
    private final Long refreshExp;
    private final String header;
    private final String prefix;

    public Jwtproperties(String secretKey, Long accessExp, Long refreshExp,
                         String header, String prefix) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
        this.header = header;
        this.prefix = prefix;
    }
}