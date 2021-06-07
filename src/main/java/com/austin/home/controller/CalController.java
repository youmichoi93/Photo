package com.austin.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guide")
public class CalController {

    @GetMapping("/cal")
    public String quide() {
        return "guide/cal";
    }



}


