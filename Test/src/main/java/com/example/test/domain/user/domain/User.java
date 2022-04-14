package com.example.test.domain.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String accountId;

    @Column()
    private String password;

    @Builder
    public User(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
