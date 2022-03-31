package com.sparta.hwk.model;

import com.sparta.hwk.Dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Getter
@Entity
public class Comment extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long blog;

    public Comment(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
        this.blog = requestDto.getBlogId();
        this.username = requestDto.getUsername();
    }
}