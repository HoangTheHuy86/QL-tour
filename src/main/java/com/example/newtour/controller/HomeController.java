package com.example.newtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomeController {
    // trang index
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("messeger","hello");
        return "index";
    }
    //trang list tour
    @GetMapping("/list-tour")
    public String listtour(Model model) {
        model.addAttribute("messeger","hello");
        return "list-tour";
    }
    //trang search tour
    @GetMapping("/search-tour")
    public String searchtour(Model model) {
        model.addAttribute("messeger","hello");
        return "search-tour";
    }

    //trang search tour
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("messeger","hello");
        return "contact";
    }





}
