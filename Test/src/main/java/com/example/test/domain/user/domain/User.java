package com.example.test.domain.user.domain;

import com.example.test.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 14, nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column
    private String username;

    @Column
    private String File;

    @Builder
    public User(String accountId, String password, Authority authority, String username) {
        this.accountId = accountId;
        this.password = password;
        this.authority = authority;
        this.username = username;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
