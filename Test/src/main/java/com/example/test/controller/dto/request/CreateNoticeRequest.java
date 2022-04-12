package com.example.test.controller.dto.request;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateNoticeRequest {

    private String title;

    private String content;
}