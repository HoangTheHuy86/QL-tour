package com.example.newtour.service;


import com.example.newtour.model.Tour;

import java.util.List;

public interface TourService {

    List<Tour> getAllTour();

    void saveTour(Tour tour);

    Tour getTourById(Integer id);

    void updateTour(Integer id,String name,String timeStart,String timeEnd,Float cost,Float costChildren,String moTaTour,String photo);


}
