package com.vb.hotelcontrol.controllers;

import com.vb.hotelcontrol.dto.ApartmentDto;
import com.vb.hotelcontrol.models.ApartmentModel;
import com.vb.hotelcontrol.services.ApartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/control")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;


    @PostMapping
    public ResponseEntity<Object> saveApartment(@RequestBody @Valid ApartmentDto apartmentDto){
            var apartmentModel = new ApartmentModel();
            BeanUtils.copyProperties(apartmentDto, apartmentModel);
            apartmentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
            return ResponseEntity.status(HttpStatus.CREATED).body(apartmentService.save(apartmentModel));

//        if(apartmentService.existsByLicensePlateCar(apartmentDto.getLicensePlateCar())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
//        }
//        if(apartmentService.existsByParkingSpotNumber(apartmentDto.getParkingSpotNumber())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
//        }
//        if(apartmentService.existsByApartmentAndBlock(apartmentDto.getApartment(), apartmentDto.getBlock())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
//        }
//        var parkingSpotModel = new ApartmentModel();
//        BeanUtils.copyProperties(apartmentDto, apartmentModel);
//        apartmentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
//        return ResponseEntity.status(HttpStatus.CREATED).body(apartmentService.save(apartmentModel));
    }



//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> saveApartment(@RequestBody ApartmentModel apartmentModel){
//        return ResponseEntity.status(HttpStatus.CREATED).body(ApartmentService.save(apartmentModel));

//    public ApartmentModel save(@RequestBody ApartmentModel apartmentModel) {
//        return ApartmentService.save(apartmentModel);
    }

