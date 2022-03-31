package com.sparta.hwk.controller;


import com.sparta.hwk.model.Blog;
import com.sparta.hwk.repository.BlogRepository;
import com.sparta.hwk.repository.CommentRepository;
import com.sparta.hwk.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparta.hwk.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController{

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        } else {
            model.addAttribute("username","");
        }
        return "index";
    }

    @GetMapping("/api/blogs/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null")
        );
        model.addAttribute("blog",blog);
        return "detail";
    }
}