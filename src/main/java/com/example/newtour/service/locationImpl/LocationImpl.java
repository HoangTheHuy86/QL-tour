package com.example.newtour.service.locationImpl;

import com.example.newtour.model.Location;
import com.example.newtour.repository.LocationRepository;
import com.example.newtour.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAllEntity();
    }

    public void saveLocation(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Integer id) {
        locationRepository.deleteByIdLocation(id);
    }

    @Override
    public Location getByIdLocation(Integer id) {
        return locationRepository.findByIdLocation(id);
    }

    @Override
    public void updateLocation(Integer id,String name, String address,String photo) {

        Location location = locationRepository.findByIdLocation(id);
        location.setName_location(name);
        location.setAddress_location(address);
        location.setLocation_img(photo);
        locationRepository.save(location);
    }


}
