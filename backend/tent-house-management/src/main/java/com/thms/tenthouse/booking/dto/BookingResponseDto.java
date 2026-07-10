package com.thms.tenthouse.booking.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDto {

    private Long bookingId;

    // Customer Details
    private Long customerId;
    private String customerName;
    private String mobileNumber;
    private String place;

    // Booking Details
    private LocalDate eventDate;
    private String eventPlace;
    private String bookingStatus;

    private BigDecimal totalAmount;
    private BigDecimal advancePaid;
    private BigDecimal balanceAmount;

    private BigDecimal transportChargeDelivery;
    private BigDecimal transportChargeReturn;

    private BigDecimal discount;
    private BigDecimal damageCharge;
    private BigDecimal missingCharge;
    private BigDecimal finalAmount;

    private String paymentStatus;

    private Instant createdAt;
    private Instant updatedAt;
}
