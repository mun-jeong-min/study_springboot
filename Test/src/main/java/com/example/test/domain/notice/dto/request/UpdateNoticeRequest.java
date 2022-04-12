package com.example.test.domain.notice.dto.request;

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
