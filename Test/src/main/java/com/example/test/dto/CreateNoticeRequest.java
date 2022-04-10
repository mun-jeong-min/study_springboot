package com.example.test.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class CreateNoticeRequest {

    private String title;

    private String content;
}