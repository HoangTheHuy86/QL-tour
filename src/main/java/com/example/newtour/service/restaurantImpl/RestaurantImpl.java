package com.example.newtour.service.restaurantImpl;

import com.example.newtour.model.Restaurant;
import com.example.newtour.repository.RestaurantRepository;
import com.example.newtour.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public void saveAllRestaurant(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteByIdRestaurant(id);
    }

    @Override
    public Restaurant getByIdRestaurant(Integer id) {
        return restaurantRepository.findByIdRestaurant(id);
    }

    @Override
    public void updateRestaurant(Integer id, String name, String address, String img) {

        Restaurant restaurant = restaurantRepository.findByIdRestaurant(id);
        restaurant.setName_restaurant(name);
        restaurant.setAddress_restaurant(address);
        restaurant.setRestaurant_img(img);
        restaurantRepository.save(restaurant);

    }
}
