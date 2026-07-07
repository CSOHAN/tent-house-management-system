# Tent House Management System - ER Diagram

## Entity Classification

**Master Tables:**
- CUSTOMER
- INVENTORY_ITEM

**Transaction Tables:**
- BOOKING
- RETURN

**Transaction Detail Tables:**
- BOOKING_ITEM
- RETURN_ITEM

---

## Entity Relationship Diagram (Visual)

```
                                    ┌──────────────────┐
                                    │    CUSTOMER      │
                                    ├──────────────────┤
                                    │ PK: customer_id  │
                                    │ - name           │
                                    │ - mobile_number  │
                                    │ - place          │
                                    │ - created_at     │
                                    │ - updated_at     │
                                    └─────────┬────────┘
                                              │
                                          1:N │ (OneToMany)
                                              │
                                    ┌─────────▼──────────────────────┐
                                    │      BOOKING                   │
                                    ├────────────────────────────────┤
                                    │ PK: booking_id                 │
                                    │ FK: customer_id (ManyToOne)    │
                                    │ - event_date                   │
                                    │ - event_place                  │
                                    │ - booking_status               │
                                    │ - total_amount                 │
                                    │ - advance_paid                 │
                                    │ - balance_amount               │
                                    │ - transport charges            │
                                    │ - discount, damage_charge      │
                                    │ - missing_charge, final_amount │
                                    │ - payment_status               │
                                    │ - created_at, updated_at       │
                                    └─────────┬──────────────────────┘
                                              │
                        ┌─────────────────────┴──────────────────────┐
                        │                                            │
                    1:N │ (OneToMany)                            1:1 │ (OneToOne)
                        │                                     Optional│
                        │                                            │
        ┌───────────────▼──────────────────┐       ┌──────────────────▼──────────────┐
        │   BOOKING ITEM                   │       │       RETURN                    │
        ├──────────────────────────────────┤       ├─────────────────────────────────┤
        │ PK: booking_item_id              │       │ PK: return_id                   │
        │ FK: booking_id (ManyToOne)       │       │ FK: booking_id (OneToOne)       │
        │ FK: item_id (ManyToOne)          │       │ - return_date                   │
        │ - quantity                       │       │ - total_missing_amt             │
        │ - price_at_booking               │       │ - total_damage_amt              │
        │ - total_price                    │       │ - remarks                       │
        │ - created_at                     │       │ - created_at                    │
        └────────────┬──────────────────────┘      └──────────────────┬─────────────┘
                     │                                               │
                 N:1 │ (ManyToOne)                               1:N │ (OneToMany)
                     │                                               │
         ┌───────────▼──────────────────────────────────┐            │
         │       INVENTORY ITEM                        │            │
         ├───────────────────────────────────────────┤            │
         │ PK: item_id                               │            │
         │ - item_name                               │            │
         │ - total_quantity                          │            │
         │ - available_quantity                      │            │
         │ - rental_price                            │            │
         │ - created_at, updated_at                  │            │
         │                                           │            │
         │ Relations:                                │            │
         │ - 1:N → BookingItem                      │            │
         │ - 1:N → ReturnItem                       │            │
         └───────────┬────────────────────┬──────────┼────────────┘
                     │                    │          │
                 N:1 │ (ManyToOne)        │          │ N:1
                     │                    └──────────┼─────────────┐
                     │                               │             │
                     │                    ┌──────────▼─────────────▼─┐
                     │                    │    RETURN ITEM          │
                     │                    ├─────────────────────────┤
                     └───────────────────►│ PK: return_item_id      │
                          (ManyToOne)     │ FK: return_id (ManyToOne
                                          │ FK: item_id (ManyToOne) │
                                          │ - returned_quantity     │
                                          │ - missing_quantity      │
                                          │ - damaged_quantity      │
                                          │ - damage_charge         │
                                          │ - missing_charge        │
                                          │ - created_at            │
                                          └─────────────────────────┘
```

---

## Entity Details & Relationships

### 1. **CUSTOMER** (Master)
- **Purpose**: Stores customer master information
- **Primary Key**: `customer_id` (auto-increment)
- **Unique Constraint**: `mobile_number`
- **Relationships**:
  - `1:N` with BOOKING (OneToMany)
    - One customer can create multiple bookings

**Example:**
```
Customer: Ramesh
Bookings:
  - Marriage Event
  - Birthday Event
  - Religious Function
```

---

### 2. **BOOKING** (Transaction Master)
- **Purpose**: Stores event booking information
- **Primary Key**: `booking_id` (auto-increment)
- **Foreign Keys**:
  - `customer_id` → CUSTOMER (ManyToOne)
- **Relationships**:
  - `N:1` with CUSTOMER (ManyToOne)
  - `1:N` with BOOKING_ITEM (OneToMany)
  - `1:1` with RETURN (OneToOne)
    - Booking side is optional (booking can exist without return)
    - Return side is mandatory (return must belong to a booking)

**Example Flow:**
```
Booking created
        ↓
    Event occurs
        ↓
    Return created (optional)
```

---

### 3. **BOOKING_ITEM** (Transaction Detail)
- **Purpose**: Stores items selected for a booking
- **Primary Key**: `booking_item_id` (auto-increment)
- **Foreign Keys**:
  - `booking_id` → BOOKING (ManyToOne)
  - `item_id` → INVENTORY_ITEM (ManyToOne)
- **Relationships**:
  - `N:1` with BOOKING (ManyToOne)
  - `N:1` with INVENTORY_ITEM (ManyToOne)

**Business Rule:**
- A confirmed booking should contain at least one booking item
- A booking without items is not valid for event processing
- Note: Database currently does not enforce this; application layer must validate

**Example:**
```
Booking: Marriage Function

Items Selected:
  - Chair × 200
  - Table × 20
  - Tent × 1
```

---

### 4. **INVENTORY_ITEM** (Master)
- **Purpose**: Stores available tent house items for rental
- **Primary Key**: `item_id` (auto-increment)
- **Unique Constraint**: `item_name`
- **Relationships**:
  - `1:N` with BOOKING_ITEM (OneToMany)
  - `1:N` with RETURN_ITEM (OneToMany)

**Examples of Items:**
- Chair
- Table
- Tent
- Decoration Items

**Meaning:**
One inventory item can appear in many bookings and returns

**Business Rules:**
- Booking confirmation decreases available_quantity.
- Return processing increases available_quantity.
- Missing or damaged items reduce available stock until replacement/adjustment.

**Example:**
```
Item: Chair

Booking 101: 200 chairs
Booking 102: 100 chairs
Booking 103: 50 chairs
```

---

### 5. **RETURN** (Transaction Master)
- **Purpose**: Stores item return transaction when items are returned after event
- **Primary Key**: `return_id` (auto-increment)
- **Foreign Keys**:
  - `booking_id` → BOOKING (OneToOne, unique)
    - Each booking has at most one return
- **Relationships**:
  - `1:1` with BOOKING (OneToOne)
    - Booking side is optional (booking can exist without return)
    - Return side is mandatory (return must belong to a booking)
  - `1:N` with RETURN_ITEM (OneToMany)

---

### 6. **RETURN_ITEM** (Transaction Detail)
- **Purpose**: Stores returned item details with charges
- **Primary Key**: `return_item_id` (auto-increment)
- **Foreign Keys**:
  - `return_id` → RETURN (ManyToOne)
  - `item_id` → INVENTORY_ITEM (ManyToOne)
- **Relationships**:
  - `N:1` with RETURN (ManyToOne)
  - `N:1` with INVENTORY_ITEM (ManyToOne)

**Tracks:**
- Returned quantity
- Missing quantity
- Damaged quantity
- Associated charges

**Business Rules:**
- Each return item belongs to one return transaction
- Missing quantity cannot exceed booked quantity
- Damaged quantity should not exceed physically returned quantity.

---

## Data Flow & Workflows

### Booking Workflow:
```
Customer
    ↓
Creates Booking
    ↓
Select Items (BookingItem)
    ↓
Inventory Availability Check
    ↓
Booking Confirmed
```

### Return Workflow:
```
Booking Completed
    ↓
Return Created
    ↓
Return Items Added
    ↓
Inventory Updated
```

---

## Cardinality Summary

| Relationship | Type | Meaning |
|---|---|---|
| Customer → Booking | 1:N | One customer has many bookings |
| Booking → BookingItem | 1:N | One booking contains many items |
| InventoryItem → BookingItem | 1:N | One item appears in many bookings |
| Booking → Return | 1:1 | One booking has maximum one return |
| Return → ReturnItem | 1:N | One return contains many items |
| InventoryItem → ReturnItem | 1:N | One item appears in many returns |

---

## Database Indexes

For performance optimization:

### BOOKING
- **idx_booking_customer** (customer_id)
  - Purpose: Fast customer booking lookup

### BOOKING_ITEM
- **idx_booking_item_booking** (booking_id)
- **idx_booking_item_inventory** (item_id)

### RETURN
- **idx_return_booking** (booking_id)
  - Reason: Fast lookup of return details using booking_id

### RETURN_ITEM
- **idx_return_item_return** (return_id)
- **idx_return_item_inventory** (item_id)

---

## Foreign Key Constraints

### Recommended Delete Behaviour: RESTRICT / NO ACTION

**Note:** The current JPA code only names the constraints using `@ForeignKey(name = "...")`. The actual database delete behavior depends on:
- Database default settings (if not explicitly defined in DDL)
- When SQL schema is created, constraints should explicitly include: `ON DELETE RESTRICT`

**Reason for RESTRICT/NO ACTION:**
Business transaction history should not be deleted accidentally. For a business system, historical data is critical.

**Example of what NOT to allow:**
```
Delete Customer #10
         |
         |-- CASCADE would delete 50+ old bookings
         |-- CASCADE would delete all transactions
         |-- LOSES business audit trail ❌
```

**What RESTRICT/NO ACTION ensures:**
```
Delete Customer #10
         |
         |-- RESTRICT blocks deletion if bookings exist
         |-- Preserves complete business history ✓
         |-- Manual cleanup required (safe approach)
```

**This protects:**
- Customer history
- Booking history
- Payment records
- Return records

### Named Foreign Keys:

- `fk_booking_customer` - Booking.customer → Customer.customerId
- `fk_booking_item_booking` - BookingItem.booking → Booking.bookingId
- `fk_booking_item_inventory` - BookingItem.inventoryItem → InventoryItem.itemId
- `fk_return_booking` - Return.booking → Booking.bookingId
- `fk_return_item_return` - ReturnItem.returnEntity → Return.returnId
- `fk_return_item_inventory` - ReturnItem.inventoryItem → InventoryItem.itemId

---

## Document Metadata

| Attribute | Value |
|---|---|
| Document | ER Diagram |
| Version | 1.0 |
| Project | Tent House Management System |
| Status | Final |
| Last Updated | 2026-07-07 |
