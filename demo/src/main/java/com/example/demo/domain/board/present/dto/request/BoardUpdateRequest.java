package com.example.demo.domain.board.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String description;
    private String subTitle;
}
