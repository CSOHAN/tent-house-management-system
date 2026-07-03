# Business Rules

| Project      | Tent House Management System (THMS) |
|--------------|-------------------------------------|
| Version      | 1.0                                 |
| Status       | Draft                               |
| Author       | C. Sohan                            |
| Reviewed By  | Pending                             |
| Created On   | 03-Jul-2026                         |
| Last Updated | 03-Jul-2026                         |

---

# Purpose

This document defines the business rules governing the Tent House Management System.

Business rules describe how the business operates and serve as the foundation for validations, workflows, calculations, and application logic.

---

Business Rules
# Business Rules

| Rule ID | Business Rule                                                                                                                                                |
|---------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BR-001  | Only the owner can access and manage the system in Version 1.                                                                                                |
| BR-002  | Every booking shall have a unique booking number.                                                                                                            |
| BR-003  | Advance payment is optional.                                                                                                                                 |
| BR-004  | Discounts may be applied at the owner's discretion.                                                                                                          |
| BR-005  | Transport charges shall be charged separately for delivery and return.                                                                                       |
| BR-006  | Additional items may be added to a booking even after the event has started.                                                                                 |
| BR-007  | If customers return fewer items than delivered, the remaining items shall be marked as Pending Return.                                                       |
| BR-008  | Damaged items shall incur additional charges determined by the owner.                                                                                        |
| BR-009  | Every inventory item shall have a fixed rental price.                                                                                                        |
| BR-010  | New inventory purchases shall increase the existing stock quantity.                                                                                          |
| BR-011  | Inventory shall be reserved immediately after a booking is confirmed.                                                                                        |
| BR-012  | Inventory availability shall be calculated based on existing bookings and expected return dates.                                                             |
| BR-013  | A booking may use borrowed inventory from one or more supplier tent houses if internal inventory is insufficient.                                            |
| BR-014  | Borrowed inventory shall be recorded against the supplier from whom it was borrowed.                                                                         |
| BR-015  | Borrowed inventory shall use the standard per-item borrowing rate.                                                                                           |
| BR-016  | Borrowed inventory should be returned immediately after customer return to avoid additional rental charges.                                                  |
| BR-017  | Payment to the supplier shall be made when borrowed inventory is returned.                                                                                   |
| BR-018  | If borrowed inventory is not fully returned, the borrow transaction shall remain in Pending Return status until all items are returned or otherwise settled. |
| BR-019  | Every booking shall record Booking Date, Delivery Date, Event Date, and Expected Return Date.                                                                |
| BR-020  | Inventory shall remain reserved from the delivery date until the expected return date.                                                                       |
| BR-021  | A booking shall be completed only after all returned items have been physically verified by the owner.                                                       |
| BR-022  | During return verification, the system shall display the original delivered quantities for comparison.                                                       |
| BR-023  | The system shall automatically calculate missing quantities based on returned quantities entered by the owner.                                               |
| BR-024  | Inventory quantities shall be updated only after return verification is completed.                                                                           |
