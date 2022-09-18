package com.example.filmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/create-movie")
    public String createMovie() {
        return "create-movie";
    }

    @GetMapping("/create-actor")
    public String createActor() {
        return "create-actor";
    }

}
