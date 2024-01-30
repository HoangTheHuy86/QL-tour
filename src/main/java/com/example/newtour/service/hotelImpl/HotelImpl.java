package com.example.newtour.service.hotelImpl;

import com.example.newtour.model.Hotel;
import com.example.newtour.repository.HotelRepository;
import com.example.newtour.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelRepository.deleteByIdHotel(id);
    }

    @Override
    public Hotel getByIdHotel(Integer id) {
        return hotelRepository.findByIdHotel(id);
    }

    @Override
    public void updateHotel(Integer id, String name, String address, String img) {

        Hotel hotel = hotelRepository.findByIdHotel(id);
        hotel.setName_hotel(name);
        hotel.setAddress_hotel(address);
        hotel.setHotel_img(img);
        hotelRepository.save(hotel);

    }

}
