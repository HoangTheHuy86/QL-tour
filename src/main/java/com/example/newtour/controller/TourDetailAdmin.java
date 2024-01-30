package com.example.newtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tourDetailAdmin")
public class TourDetailAdmin {
    @Autowired
    private TourDetailService


    @GetMapping("/admin-tourDetail")
    public String tourDetailAddmin(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listTourDetail",);
        return "admin/hotel/add-hotel";
    }

}
