package com.kid.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArrayController {

    @GetMapping("/array/detail")
    public String arrayDetail(Model model) {
        return "array/detail";
    }

}
