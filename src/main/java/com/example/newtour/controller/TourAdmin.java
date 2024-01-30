package com.example.newtour.controller;

import com.example.newtour.model.Tour;
import com.example.newtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/tourAdmin")
public class TourAdmin {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private TourService tourService;

    @GetMapping("/admin-tour")
    public String adminTour(Model model) {
        model.addAttribute("listTour",tourService.getAllTour());
        return "admin/tour/admin-tour";
    }

    @GetMapping("/add-tour")
    public String getTour(Model model) {
        Tour tour = new Tour();
        model.addAttribute("tour",tour);
        return "admin/tour/add-tour";
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour, @RequestParam("img") MultipartFile img ) throws IOException {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(img.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(img.getBytes());

        }

        String photo = "\\assets2\\image"+"\\"+img.getOriginalFilename().toString();
        tour.setTour_img(photo);
        tourService.saveTour(tour);
        return "redirect:/tourAdmin/admin-tour";

    }

    @GetMapping("/update-tour")
    public String getTourById(Model model,@RequestParam("id") Integer id) {
        model.addAttribute("UpdateTour", tourService.getTourById(id));
        return "admin/tour/update-tour";
    }

    @PostMapping("/updateTour")
    public String updateTour(@RequestParam("id_tour") Integer id,@RequestParam("name_tour") String name,@RequestParam("time_start_tour") String timeStart,@RequestParam("time_end_tour") String timeEnd,@RequestParam("cost_adult") Float cost,@RequestParam("cost_children") Float costChildren,@RequestParam("mo_ta_tour") String moTaTour,@RequestParam("img") MultipartFile img) throws IOException {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(img.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(img.getBytes());

        }

        String photo = "\\assets2\\image"+"\\"+img.getOriginalFilename().toString();

        tourService.updateTour(id,name,timeStart,timeEnd,cost,costChildren,moTaTour,photo);
        return "redirect:/tourAdmin/admin-tour";
    }


}
