package com.sparta.hwk.controller;

import com.sparta.hwk.domain.Blog;
import com.sparta.hwk.domain.BlogRepository;
import com.sparta.hwk.domain.BlogRequestDto;
import com.sparta.hwk.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;


    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByCreatedAtDesc();
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }

    @GetMapping("/api/blogs/{id}")
    public Blog Detail(@PathVariable Long id){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException()
                );
        return blog;
    }

//    @PutMapping("/api/blogs/{id}")
//    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
//        return blogService.update(id, requestDto);
//    }





}