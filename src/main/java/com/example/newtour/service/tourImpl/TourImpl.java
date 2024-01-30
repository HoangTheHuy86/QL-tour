package com.example.newtour.service.tourImpl;

import com.example.newtour.model.Tour;
import com.example.newtour.repository.TourRepository;
import com.example.newtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Tour> getAllTour() {
        return tourRepository.findAll();
    }

    @Override
    public void saveTour(Tour tour) {
        this.tourRepository.save(tour);
    }

    @Override
    public Tour getTourById(Integer id) {
        return tourRepository.getTourById(id);
    }

    @Override
    public void updateTour(Integer id, String name, String timeStart, String timeEnd, Float cost, Float costChildren, String moTaTour, String photo) {
        Tour tour = tourRepository.getTourById(id);
        tour.setName_tour(name);
        tour.setTime_start_tour(timeStart);
        tour.setTime_end_tour(timeEnd);
        tour.setCost_adult(cost);
        tour.setCost_children(costChildren);
        tour.setMo_ta_tour(moTaTour);
        tour.setTour_img(photo);
        tourRepository.save(tour);

    }
}
