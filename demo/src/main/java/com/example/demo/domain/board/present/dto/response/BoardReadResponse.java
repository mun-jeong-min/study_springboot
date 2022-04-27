package com.example.demo.domain.board.present.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardReadResponse {

    private List<BoardResponse> boardList;

    @Getter
    @Builder
    public static class BoardResponse {

        private final String title;
        private final String description;
        private final String subTitle;
    }
}
