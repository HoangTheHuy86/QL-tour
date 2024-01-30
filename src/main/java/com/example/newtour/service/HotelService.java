package com.example.newtour.service;

import com.example.newtour.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    void saveHotel(Hotel hotel);

    void deleteHotel(Integer id);

    Hotel getByIdHotel(Integer id);

    void updateHotel(Integer id ,String name,String address,String img);

}
