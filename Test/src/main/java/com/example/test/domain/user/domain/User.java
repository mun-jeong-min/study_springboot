package com.example.test.domain.user.domain;

import lombok.*;

import javax.persistence.*;

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

    @Builder
    public User(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
