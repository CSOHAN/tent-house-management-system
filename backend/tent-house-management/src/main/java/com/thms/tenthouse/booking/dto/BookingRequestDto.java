package com.thms.tenthouse.booking.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDto {

    // Customer Details
    @NotBlank(message = "Customer name is required")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
        regexp = "\\d{10}",
        message = "Mobile number must be exactly 10 digits"
    )
    private String mobileNumber;

    @NotBlank(message = "Place is required")
    private String place;

    // Booking Details
    @NotNull(message = "Event date is required")
    private LocalDate eventDate;

    @NotBlank(message = "Event place is required")
    private String eventPlace;

    private BigDecimal advancePaid;

    private BigDecimal transportChargeDelivery;

    private BigDecimal transportChargeReturn;

    private BigDecimal discount;
}
