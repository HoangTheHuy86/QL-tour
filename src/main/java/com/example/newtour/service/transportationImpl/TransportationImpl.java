package com.example.newtour.service.transportationImpl;

import com.example.newtour.model.Transportation;
import com.example.newtour.repository.TransportationRepository2;
import com.example.newtour.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportationImpl implements TransportationService {

    @Autowired
    private TransportationRepository2 transportationRepository2;


    @Override
    public List<Transportation> getAllTransportations() {
        return transportationRepository2.findAll();
    }

    @Override
    public void saveAllTransportation(Transportation transportation) {
        this.transportationRepository2.save(transportation);
    }

    @Override
    public void deleteTransportation(Integer id) {
        transportationRepository2.deleteByIdTransportation(id);
    }


}
