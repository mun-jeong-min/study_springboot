package com.example.test.controller.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UpdateNoticeRequest {
    private String title;
    private String content;
}
