package com.thms.tenthouse.booking.entity;

import com.thms.tenthouse.customer.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "customer")
@Entity
@Table(
    name = "bookings",
    indexes = {
        @Index(
            name = "idx_booking_customer",
            columnList = "customer_id"
        )
    }
)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "customer_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_booking_customer")
    )
    private Customer customer;

    @NotNull
    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Size(max = 200)
    @NotNull
    @Column(name = "event_place", nullable = false, length = 200)
    private String eventPlace;

    @Size(max = 50)
    @Column(name = "booking_status", length = 50)
    private String bookingStatus;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "advance_paid", precision = 10, scale = 2)
    private BigDecimal advancePaid;

    @Column(name = "balance_amount", precision = 10, scale = 2)
    private BigDecimal balanceAmount;

    @Column(name = "transport_charge_delivery", precision = 10, scale = 2)
    private BigDecimal transportChargeDelivery;

    @Column(name = "transport_charge_return", precision = 10, scale = 2)
    private BigDecimal transportChargeReturn;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "damage_charge", precision = 10, scale = 2)
    private BigDecimal damageCharge;

    @Column(name = "missing_charge", precision = 10, scale = 2)
    private BigDecimal missingCharge;

    @Column(name = "final_amount", precision = 10, scale = 2)
    private BigDecimal finalAmount;

    @Size(max = 20)
    @Column(name = "payment_status", length = 20)
    private String paymentStatus;


}
