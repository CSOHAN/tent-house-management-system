package com.thms.tenthouse.booking.entity;

import com.thms.tenthouse.inventory.entity.InventoryItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"booking", "inventoryItem"})
@Entity
@Table(
    name = "booking_items",
    indexes = {
        @Index(
            name = "idx_booking_item_booking",
            columnList = "booking_id"
        ),
        @Index(
            name = "idx_booking_item_inventory",
            columnList = "item_id"
        )
    }
)
public class BookingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_item_id", nullable = false)
    private Long bookingItemId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "booking_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_booking_item_booking")
    )
    private Booking booking;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "item_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_booking_item_inventory")
    )
    private InventoryItem inventoryItem;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "price_at_booking", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceAtBooking;

    @NotNull
    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;


}
