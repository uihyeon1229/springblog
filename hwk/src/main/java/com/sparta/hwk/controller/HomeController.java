package com.sparta.hwk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController{
        @GetMapping("/api/blogs/detail")
        public String detail(@RequestParam("id") Long id) {
            return "/detail.html";
        }


}