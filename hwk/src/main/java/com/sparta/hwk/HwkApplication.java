package com.sparta.hwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwkApplication.class, args);
    }

}