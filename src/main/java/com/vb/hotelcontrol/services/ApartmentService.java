package com.vb.hotelcontrol.services;

import com.vb.hotelcontrol.repositories.ApartmentRepository;
import com.vb.hotelcontrol.models.ApartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Transactional
    public ApartmentModel save(ApartmentModel apartmentModel) {
        return apartmentRepository.save(apartmentModel);
    }


    public List<ApartmentModel> findAll() {
        return apartmentRepository.findAll();
    }

    public Optional<ApartmentModel> findById(Long id) {
        return apartmentRepository.findById(id);
    }

    @Transactional
    public void delete(ApartmentModel apartmentModel) {
        apartmentRepository.delete(apartmentModel);
    }
}
