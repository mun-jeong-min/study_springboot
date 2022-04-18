package com.example.test.domain.notice.present.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeResponse {

    private final Long id;
    private final String title;
    private final String content;
}
