package com.yug.livelog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiveLogController {

    @GetMapping("/livelog")
    public String getLiveLog() {
        return "forward:/livelog.html";
    }
}
