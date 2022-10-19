package com.vb.hotelcontrol.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentDto {

    @NotBlank
    private String apartmentNumber;

    @NotBlank
    private String block;

    @NotBlank
    private String apartmentType;

    @NotBlank
    private String guestName;
}
