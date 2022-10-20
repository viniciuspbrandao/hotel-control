package com.vb.hotelcontrol.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_Apartment")
public class ApartmentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String apartmentNumber;

    @Column(nullable = false, length = 70)
    private String apartmentType;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String guestName;

    @Column(nullable = false, length = 30)
    private String block;


}
