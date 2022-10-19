package com.vb.hotelcontrol.services;

import com.vb.hotelcontrol.repositories.ApartmentRepository;
import com.vb.hotelcontrol.models.ApartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;



    @Transactional
    public ApartmentModel save(ApartmentModel apartmentModel) {
        return apartmentRepository.save(apartmentModel);
    }



}
