package com.vb.hotelcontrol.repositories;

import com.vb.hotelcontrol.models.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentModel, Long> {

}
