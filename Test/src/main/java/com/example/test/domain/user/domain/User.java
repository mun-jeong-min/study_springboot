package com.example.test.domain.user.domain;

import com.example.test.global.enums.Authority;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 14, nullable = false)
    private String accountId;

    @Column(length = 20, nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String accountId, String password,Authority authority) {
        this.accountId = accountId;
        this.password = password;
        this.authority=authority;
    }
}
