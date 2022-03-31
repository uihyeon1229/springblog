package com.sparta.hwk.controller;

import com.sparta.hwk.Dto.CommentRequestDto;
import com.sparta.hwk.model.Comment;
import com.sparta.hwk.repository.BlogRepository;
import com.sparta.hwk.repository.CommentRepository;
import com.sparta.hwk.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    //댓글 등록
    // 신규 게시글 등록

    @PostMapping("/api/blog/{id}/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {

        blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null"));

        requestDto.setUsername(userDetails.getUsername());
        requestDto.setBlogId(id);

        Comment comment = new Comment(requestDto);
        System.out.println(comment);
        commentRepository.save(comment);
        return comment;
    }

    @DeleteMapping("/api/comment/{id}")
    public void deleteComment(@PathVariable("id") long commentId){
        commentRepository.deleteById(commentId);
    }
}