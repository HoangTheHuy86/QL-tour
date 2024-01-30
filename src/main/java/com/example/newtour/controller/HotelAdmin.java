package com.example.newtour.controller;

import com.example.newtour.model.Hotel;
import com.example.newtour.model.Location;
import com.example.newtour.service.HotelService;
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
@RequestMapping("/hotelAdmin")
public class HotelAdmin {

    @Autowired
    private HotelService hotelService;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @GetMapping("/admin-hotel")
    public String adminhotel(Model model) {
        model.addAttribute("listhotel", hotelService.getAllHotels());
        return "admin/hotel/admin-hotel";
    }

    @GetMapping("/add-hotel")
    public String gethotel(Model model) {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "admin/hotel/add-hotel";
    }

    @PostMapping("/addhotel")
    public String addhotel(@ModelAttribute("hotel") Hotel hotel , @RequestParam MultipartFile imgHotel) throws IOException {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imgHotel.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(imgHotel.getBytes());

        }

        String photo = "\\assets2\\image"+"\\"+imgHotel.getOriginalFilename().toString();
        hotel.setHotel_img(photo);
        hotelService.saveHotel(hotel);
        return "redirect:/hotelAdmin/admin-hotel";
    }


    @GetMapping("/delete")
    public String deleteHotel(@RequestParam("id") Integer id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotelAdmin/admin-hotel";
    }

    @GetMapping("/update-hotel")
    public String getHotelUpdate(Model model , @RequestParam("id") Integer id) {
        model.addAttribute("hotelUpdate", hotelService.getByIdHotel(id));
        return "admin/hotel/update-hotel";
    }

    @PostMapping("/updateHotel")
    public String updateHotel(@RequestParam("id_hotel") Integer id,@RequestParam("name_hotel") String name,@RequestParam("address_hotel") String address,@RequestParam("img") MultipartFile img ) throws IOException {

        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(img.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(img.getBytes());

        }

        String photo = "../assets2/image"+"/"+img.getOriginalFilename().toString();
        hotelService.updateHotel(id,name,address,photo);

        return "redirect:/hotelAdmin/admin-hotel";
    }

}
