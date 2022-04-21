package com.example.demo.domain.board.domain;

import com.example.demo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseTimeEntity {
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

    public void updateBoard(String title, String description, String subTitle) {
        this.title = title;
        this.description = description;
        this.subTitle = subTitle;
    }
}