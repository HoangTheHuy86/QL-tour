package com.example.newtour.service;

import com.example.newtour.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    void saveLocation(Location location);


    void deleteLocation(Integer id);

    Location getByIdLocation(Integer id);

    void updateLocation(Integer id, String name, String address,String photo);
}
