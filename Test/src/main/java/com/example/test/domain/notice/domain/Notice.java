package com.example.test.domain.notice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter

public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public Notice (Long id, String title,String content){
        this.id = id;
        this.title=title;
        this.content=content;
    }
}
