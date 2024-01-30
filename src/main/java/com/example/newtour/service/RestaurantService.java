package com.example.newtour.service;

import com.example.newtour.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    void saveAllRestaurant(Restaurant restaurant);

    void deleteRestaurant(Integer id);

    Restaurant getByIdRestaurant(Integer id);

    void updateRestaurant(Integer id,String name,String address,String img);
}
