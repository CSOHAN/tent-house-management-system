package com.thms.tenthouse.inventory.entity;

import com.thms.tenthouse.booking.entity.BookingItem;
import com.thms.tenthouse.returns.entity.ReturnItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"bookingItems", "returnItems"})
@Table(name = "inventory_items", uniqueConstraints = {@UniqueConstraint(name = "uk_inventory_item_name",
        columnNames = {"item_name"})})
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Size(max = 150)
    @NotNull
    @Column(name = "item_name", nullable = false, length = 150)
    private String itemName;

    @NotNull
    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @NotNull
    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @NotNull
    @Column(name = "rental_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal rentalPrice;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(
        mappedBy = "inventoryItem",
        fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<BookingItem> bookingItems = new ArrayList<>();

    @OneToMany(
        mappedBy = "inventoryItem",
        fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<ReturnItem> returnItems = new ArrayList<>();

}
