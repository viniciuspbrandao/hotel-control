package com.vb.hotelcontrol.Repositories;

import com.vb.hotelcontrol.models.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentModel, UUID> {
}
