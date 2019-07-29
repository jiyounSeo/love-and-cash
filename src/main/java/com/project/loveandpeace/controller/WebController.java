package com.project.loveandpeace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    //https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html
    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/accountBook")
    public String accountBook() {
        return "accountBook";
    }

}
