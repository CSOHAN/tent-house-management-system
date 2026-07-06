package com.thms.tenthouse.returns.entity;

import com.thms.tenthouse.inventory.entity.InventoryItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"returnEntity", "inventoryItem"})
@Table(name = "return_items", indexes = {
        @Index(name = "idx_return_item_return",
                columnList = "return_id"),
        @Index(name = "idx_return_item_inventory",
                columnList = "item_id")})
public class ReturnItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_item_id", nullable = false)
    private Long returnItemId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "return_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_return_item_return")
    )
    private Return returnEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "item_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_return_item_inventory")
    )
    private InventoryItem inventoryItem;

    @NotNull
    @Column(name = "returned_quantity", nullable = false)
    private Integer returnedQuantity;

    @Column(name = "missing_quantity")
    private Integer missingQuantity;

    @Column(name = "damaged_quantity")
    private Integer damagedQuantity;

    @Column(name = "damage_charge", precision = 10, scale = 2)
    private BigDecimal damageCharge;

    @Column(name = "missing_charge", precision = 10, scale = 2)
    private BigDecimal missingCharge;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;


}
