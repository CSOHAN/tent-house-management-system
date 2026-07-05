📊 🧩 THMS ER DIAGRAM (CLEAN VERSION)
                         ┌────────────────────┐
                         │     CUSTOMERS      │
                         ├────────────────────┤
                         │ customer_id (PK)   │
                         │ name               │
                         │ mobile_number      │
                         │ place              │
                         │ created_at         │
                         │ updated_at         │
                         └─────────┬──────────┘
                                   │
                                   │ 1
                                   │
                                   │ M
                         ┌─────────▼──────────┐
                         │     BOOKINGS       │
                         ├────────────────────┤
                         │ booking_id (PK)    │
                         │ customer_id (FK)   │
                         │ event_date         │
                         │ event_place        │
                         │ booking_status     │
                         │ total_amount       │
                         │ advance_paid       │
                         │ discount           │
                         │ transport charges  │
                         │ payment_status     │
                         └──────┬───────┬─────┘
                                │       │
                                │       │ 1
                                │       │
                                │       │
                                │       ▼
                                │  ┌──────────────┐
                                │  │   RETURNS    │
                                │  ├──────────────┤
                                │  │ return_id PK │
                                │  │ booking_id FK│
                                │  │ return_date  │
                                │  │ damage_amt   │
                                │  │ missing_amt  │
                                │  └──────┬───────┘
                                │         │ 1
                                │         │
                                │         │ M
                                │  ┌──────▼────────┐
                                │  │ RETURN_ITEMS   │
                                │  ├────────────────┤
                                │  │ return_item_id │
                                │  │ return_id (FK) │
                                │  │ item_id (FK)   │
                                │  │ returned_qty   │
                                │  │ missing_qty    │
                                │  │ damage_qty     │
                                │  └──────┬────────┘
                                │         │
                                │         │ M
                                │         │
                                │  ┌──────▼──────────────┐
                                │  │ INVENTORY_ITEMS     │
                                │  ├──────────────────────┤
                                │  │ item_id (PK)        │
                                │  │ item_name           │
                                │  │ total_quantity      │
                                │  │ available_quantity  │
                                │  │ rental_price        │
                                │  └────────┬────────────┘
                                │           │ 1
                                │           │
                                │           │ M
                     ┌──────────▼──────────┐
                     │   BOOKING_ITEMS     │
                     ├─────────────────────┤
                     │ booking_item_id PK  │
                     │ booking_id (FK)     │
                     │ item_id (FK)        │
                     │ quantity            │
                     │ price_at_booking    │
                     │ total_price         │
                     └─────────────────────┘

🧠 SIMPLE EXPLANATION
1️⃣ Customers → Bookings

One customer can have many bookings.

2️⃣ Bookings → Booking Items

One booking contains multiple items.

3️⃣ Inventory → Booking Items

Same item can be used in many bookings.

👉 This is a many-to-many relationship resolved using booking_items

4️⃣ Bookings → Returns

One booking has one return record.

5️⃣ Returns → Return Items

Each return has multiple item-level checks.

6️⃣ Inventory → Return Items

Same inventory item is tracked in returns.
