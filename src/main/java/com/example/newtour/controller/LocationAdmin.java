package com.example.newtour.controller;

import com.example.newtour.model.Location;
import com.example.newtour.service.LocationService;
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
@RequestMapping("/locationAdmin")
public class LocationAdmin {

    @Autowired
    private LocationService locationService;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @GetMapping("/admin-location")
    public String adminlocation(Model model) {
        model.addAttribute("listlocation", locationService.getAllLocations());
        return "admin/location/admin-location";
    }

    @GetMapping("/add-location")
    public String getlocation(Model model) {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");
        Location location = new Location();
        model.addAttribute("location", location);
        return "admin/location/add-location";
    }

    @PostMapping("/addlocation")
    public String addlocation(@ModelAttribute("location")Location location,@RequestParam MultipartFile image) throws IOException {
        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(image.getBytes());

        }

        String photo = "../assets2/image"+"/"+image.getOriginalFilename().toString();
        location.setLocation_img(photo);
        locationService.saveLocation(location);


        return "redirect:/locationAdmin/admin-location";
    }


    @GetMapping("/delete")
    public String deleteLocation(@RequestParam("id") Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/locationAdmin/admin-location";
    }


    @GetMapping("/update-location")
    public String getLocationUpdate(Model model , @RequestParam("id") Integer id) {
        model.addAttribute("locationUpdate", locationService.getByIdLocation(id));
        return "admin/location/update-location";
    }

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestParam("id_location") Integer id,@RequestParam("name_location") String name,@RequestParam("address_location") String address,@RequestParam("img") MultipartFile img ) throws IOException {

        Path staticPath = Paths.get("src/main/resources/static/assets2/image");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(img.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)){
            os.write(img.getBytes());

        }

        String photo = "../assets2/image"+"/"+img.getOriginalFilename().toString();
        locationService.updateLocation(id,name,address,photo);

        return "redirect:/locationAdmin/admin-location";
    }

}


//    @PostMapping("/addlocation")
//    public String addlocation(@ModelAttribute("location") Location location,@RequestParam MultipartFile image) throws IOException {
//        Path pathImageStore = Paths.get("src/main/resources/static/assets2/image");
//
//        //kiem tra folder da ton tai chua ? - neu chua ton tai thi tao moi
//        if (!Files.exists(CURRENT_FOLDER.resolve(pathImageStore))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(pathImageStore));
//        }
//
//        //copy file anh vua upload vao folder luu anh
//        Path file = CURRENT_FOLDER.resolve(pathImageStore).resolve(image.getOriginalFilename());
//        try (OutputStream os = Files.newOutputStream(file)) {
//            os.write(image.getBytes());
//        }
//
//        String photo = "\\assets2\\image"+"\\"+image.getOriginalFilename().toString();
//        location.setLocation_img(photo);
//        locationService.saveLocation(location);
////        Location location = new Location();
//        return "redirect:/locationAdmin/admin-location";
//    }