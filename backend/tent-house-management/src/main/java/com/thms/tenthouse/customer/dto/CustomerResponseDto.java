package com.thms.tenthouse.customer.dto;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {

    private Long customerId;

    private String name;

    private String mobileNumber;

    private String place;

    private Instant createdAt;

    private Instant updatedAt;

}
