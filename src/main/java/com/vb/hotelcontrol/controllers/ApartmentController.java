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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/control")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;


    @PostMapping
    public ResponseEntity<Object> saveApartment(@RequestBody @Valid ApartmentDto apartmentDto) {

        var apartmentModel = new ApartmentModel();
        BeanUtils.copyProperties(apartmentDto, apartmentModel);
        apartmentModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(apartmentService.save(apartmentModel));

    }

    @GetMapping
    public ResponseEntity<List<ApartmentModel>> getAllApartments() {
        return ResponseEntity.status(HttpStatus.OK).body(apartmentService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        Optional<ApartmentModel> apartmentModelOptional = apartmentService.findById(id);
        if (!apartmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartment not found. Check the ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(apartmentModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteApartment(@PathVariable(value = "id") Long id) {
        Optional<ApartmentModel> apartmentModelOptional = apartmentService.findById(id);
        if (!apartmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartment not found. Check the ID.");
        }
        apartmentService.delete(apartmentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateApartment(@PathVariable(value = "id") Long id,
                                                  @RequestBody @Valid ApartmentDto apartmentDto) {
        Optional<ApartmentModel> apartmentModelOptional = apartmentService.findById(id);
        if (!apartmentModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartment not found. Check the ID.");
        }
        var apartmentModel = apartmentModelOptional.get();
        apartmentModel.setApartmentNumber(apartmentDto.getApartmentNumber());
        apartmentModel.setBlock(apartmentDto.getBlock());
        apartmentModel.setApartmentType(apartmentDto.getApartmentType());

        apartmentModel.setGuestName(apartmentDto.getGuestName());
        apartmentModel.setNumberOfAdults(apartmentDto.getNumberOfAdults());
        apartmentModel.setNumberOfChildren(apartmentDto.getNumberOfChildren());

        apartmentModel.setCheckIn(apartmentDto.getCheckIn());
        apartmentModel.setCheckOut(apartmentDto.getCheckOut());
        return ResponseEntity.status(HttpStatus.OK).body(apartmentService.save(apartmentModel));
    }
}

