package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.H2Service;

@Controller
@RequestMapping("base")
public class ViewController {

    private final H2Service h2Service;
    @Autowired
    public ViewController(H2Service h2Service) {
        this.h2Service = h2Service;
    }

    @GetMapping("view")
    public String showView() {
        // h2Service.operation();
        h2Service.select();
        return "main";
    }

}
