package com.sgboy.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by T450 on 5/18/2017.
 */
@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;

    @RequestMapping("/")
    public String welcomg(Map<String, Object> model){
        model.put("message", message);
        return "welcome";
    }
}
