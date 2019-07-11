package com.project.loveandpeace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoveandpeaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveandpeaceApplication.class, args);
    }

}
