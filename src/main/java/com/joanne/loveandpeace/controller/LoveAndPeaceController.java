package com.joanne.loveandpeace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoveAndPeaceController {

    @GetMapping
    public String ping() {
        return "love and peace";
    }
}
