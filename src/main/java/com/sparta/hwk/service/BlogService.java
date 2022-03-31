package com.sparta.hwk.service;

import com.sparta.hwk.model.Blog;
import com.sparta.hwk.repository.BlogRepository;
import com.sparta.hwk.Dto.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();

    }
}