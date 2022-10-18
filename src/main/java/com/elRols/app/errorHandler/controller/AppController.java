package com.elRols.app.errorHandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index() {
        //double res = 13/0;
        Integer res = Integer.parseInt("10x");
        return "index";
    }
}
