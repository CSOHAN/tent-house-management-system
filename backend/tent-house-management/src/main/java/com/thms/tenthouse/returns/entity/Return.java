package com.thms.tenthouse.returns.entity;

import com.thms.tenthouse.booking.entity.Booking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "booking")
@Table(name = "returns", indexes = {@Index(name = "idx_return_booking",
        columnList = "booking_id")})
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id", nullable = false)
    private Long returnId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @NotNull
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "total_missing_amount", precision = 10, scale = 2)
    private BigDecimal totalMissingAmount;

    @Column(name = "total_damage_amount", precision = 10, scale = 2)
    private BigDecimal totalDamageAmount;

    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;


}
