package com.example.demo.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String title;

    @NotNull
    @Column(length = 3000)
    private String description;

    @Column(length = 15)
    private String subTitle;

    @Builder
    public Board(String title, String description, String subTitle) {
        this.title = title;
        this.description = description;
        this.subTitle = subTitle;
    }
}