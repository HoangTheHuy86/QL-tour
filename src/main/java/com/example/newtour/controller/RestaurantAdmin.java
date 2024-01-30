package com.example.newtour.controller;



import com.example.newtour.model.Restaurant;
import com.example.newtour.service.RestaurantService;
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
@RequestMapping("/restaurantAdmin")
public class RestaurantAdmin {

    @Autowired
    private RestaurantService restaurantService;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @GetMapping("/admin-restaurant")
    public String adminrestaurant(Model model) {
        model.addAttribute("listrestaurant",restaurantService.getAllRestaurants());
        return "admin/restaurant/admin-restaurant";
    }

    @GetMapping("/add-restaurant")
    public String getrestaurant(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant",restaurant);
        return "admin/restaurant/add-restaurant";
    }

    @PostMapping("/addrestaurant")
    public String addrestaurant(@ModelAttribute("restaurant") Restaurant restaurant,@RequestParam MultipartFile imgRestaurant) throws IOException {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imgRestaurant.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(imgRestaurant.getBytes());

        }

        String photo = "\\assets2\\image"+"\\"+imgRestaurant.getOriginalFilename().toString();
        restaurant.setRestaurant_img(photo);
        restaurantService.saveAllRestaurant(restaurant);
        return "redirect:/restaurantAdmin/admin-restaurant";
    }


    @GetMapping("/delete")
    public String deleteRestaurant(@RequestParam("id") Integer id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurantAdmin/admin-restaurant";
    }

    @GetMapping("/update-restaurant")
    public String getRestaurantUpdate(Model model , @RequestParam("id") Integer id) {
        model.addAttribute("restaurantUpdate", restaurantService.getByIdRestaurant(id));
        return "admin/restaurant/update-restaurant";
    }

    @PostMapping("/updateRestaurant")
    public String updateRestaurant(@RequestParam("id_restaurant") Integer id,@RequestParam("name_restaurant") String name,@RequestParam("address_restaurant") String address,@RequestParam("img") MultipartFile img ) throws IOException {

        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(img.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(img.getBytes());

        }

        String photo = "../assets2/image"+"/"+img.getOriginalFilename().toString();
        restaurantService.updateRestaurant(id,name,address,photo);

        return "redirect:/restaurantAdmin/admin-restaurant";
    }



}
