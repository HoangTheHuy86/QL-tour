package com.example.newtour.controller;

import com.example.newtour.model.Transportation;
import com.example.newtour.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transportationAdmin")
public class TransportationAdmin {

    @Autowired
    private TransportationService transportationService;

    @GetMapping("/admin-transportation")
    public String admintransportation(Model model) {
        model.addAttribute("listtransportation",transportationService.getAllTransportations());
        return "admin/transportation/admin-transportation";
    }

    @GetMapping("/add-transportation")
    public  String gettransportation(Model model) {
        Transportation transportation = new Transportation();
        model.addAttribute("transportation",transportation);
        return "admin/transportation/add-transportation";

    }

    @PostMapping("/addtransportation")
    public String addtransportation(@ModelAttribute("transportation") Transportation transportation) {
        transportationService.saveAllTransportation(transportation);
        return "redirect:/transportationAdmin/admin-transportation";
    }

    @GetMapping("/delete")
    public String deleteTransportation(@RequestParam("id") Integer id) {
        transportationService.deleteTransportation(id);
        return "redirect:/transportationAdmin/admin-transportation";
    }
}
