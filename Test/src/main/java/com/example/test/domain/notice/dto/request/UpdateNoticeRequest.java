package com.example.test.domain.notice.dto.request;

import lombok.*;

@Getter
@NoArgsConstructor
public class UpdateNoticeRequest {
    private String title;
    private String content;
}
