package com.example.demo.domain.board.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {
    @NotBlank(message = "title은 공백값을 허용하지 않음")
    @Size(min = 1, max = 20, message = "title은 20글자 이상을 허용하지 않음")
    private String title;

    @NotBlank(message = "description은 공백을 허용하지 않음")
    @Size(min = 1, max = 3000, message = "description은 3000글자 이상을 허용하지 않음")
    private String description;

    @Size(min = 0, max = 15, message = "subtitle은 15글자 이상을 허용하지 않음")
    private String subTitle;
}
