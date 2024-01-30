package com.example.newtour.service;

import com.example.newtour.model.Transportation;

import java.util.List;

public interface TransportationService {
    List<Transportation> getAllTransportations();
    void saveAllTransportation(Transportation transportation);

    void deleteTransportation(Integer id);
}
