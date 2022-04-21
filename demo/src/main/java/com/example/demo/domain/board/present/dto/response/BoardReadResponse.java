package com.example.demo.domain.board.present.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardReadResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final String subTitle;
}
