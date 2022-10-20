package com.vb.hotelcontrol.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


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

    private int numberOfAdults;

    private int numberOfChildren;

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOut;
}
