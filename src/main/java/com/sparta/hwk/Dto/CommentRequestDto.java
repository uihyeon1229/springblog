package com.sparta.hwk.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto{

    private String username;
    private Long blogId;
    private String content;

}