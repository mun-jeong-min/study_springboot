package com.example.test.domain.notice.domain;

import com.example.test.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Cacheable
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public Notice (String title,String content, User user) {
        this.title=title;
        this.content=content;
    }

    public void updateNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
