# Functional Requirements Specification (FRS)

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

This document defines all functional requirements of the Tent House Management System.

Each requirement is assigned a unique identifier (FR-XXX) for traceability throughout design, development, testing, and deployment.

# 1. Customer Management

| ID     | Functional Requirement                                                            | Priority |
|--------|-----------------------------------------------------------------------------------|----------|
| FR-001 | The system shall allow the owner to create a new customer.                        | Must     |
| FR-002 | The system shall allow the owner to update customer details.                      | Must     |
| FR-003 | The system shall allow the owner to search customers using name or mobile number. | Must     |
| FR-004 | The system shall display complete customer booking history.                       | Should   |
| FR-005 | The system shall validate duplicate customers based on mobile number.             | Must     |
Inventory Management Module
# 2. Inventory Management

| ID     | Functional Requirement                                                      | Priority |
|--------|-----------------------------------------------------------------------------|----------|
| FR-006 | The system shall allow the owner to add a new inventory item.               | Must     |
| FR-007 | The system shall allow the owner to update inventory item details.          | Must     |
| FR-008 | The system shall allow the owner to update rental price of an item.         | Must     |
| FR-009 | The system shall maintain the total quantity of each inventory item.        | Must     |
| FR-010 | The system shall display available quantity of each inventory item.         | Must     |
| FR-011 | The system shall track damaged inventory items.                             | Must     |
| FR-012 | The system shall maintain inventory movement history.                       | Should   |
| FR-013 | The system shall allow the owner to activate or deactivate inventory items. | Should   |
Booking Management Module
# 3. Booking Management

| ID     | Functional Requirement                                                           | Priority |
|--------|----------------------------------------------------------------------------------|----------|
| FR-014 | The system shall allow the owner to create a booking.                            | Must     |
| FR-015 | The system shall generate a unique booking number automatically.                 | Must     |
| FR-016 | The system shall record event date and location.                                 | Must     |
| FR-017 | The system shall allow multiple inventory items to be added to a booking.        | Must     |
| FR-018 | The system shall calculate booking amount automatically.                         | Must     |
| FR-019 | The system shall allow modification of existing bookings.                        | Must     |
| FR-020 | The system shall allow additional items to be added after booking confirmation.  | Must     |
| FR-021 | The system shall allow removal of items before event completion.                 | Must     |
| FR-022 | The system shall maintain booking status (Booked, Active, Completed, Cancelled). | Must     |
Payment Management Module
# 4. Payment Management

| ID     | Functional Requirement                                            | Priority |
|--------|-------------------------------------------------------------------|----------|
| FR-023 | The system shall record advance payment.                          | Must     |
| FR-024 | The system shall support bookings without advance payment.        | Must     |
| FR-025 | The system shall calculate pending balance automatically.         | Must     |
| FR-026 | The system shall allow discounts to be applied.                   | Must     |
| FR-027 | The system shall add transport charges separately.                | Must     |
| FR-028 | The system shall add damage charges to the final bill.            | Must     |
| FR-029 | The system shall generate the final payable amount automatically. | Must     |
Return Management Module
# 5. Return Management

| ID     | Functional Requirement                                     | Priority |
|--------|------------------------------------------------------------|----------|
| FR-030 | The system shall record returned inventory quantities.     | Must     |
| FR-031 | The system shall identify missing inventory items.         | Must     |
| FR-032 | The system shall mark missing items as pending return.     | Must     |
| FR-033 | The system shall allow pending items to be returned later. | Must     |
| FR-034 | The system shall record damaged inventory items.           | Must     |
| FR-035 | The system shall close a booking only after verification.  | Should   |
Reports Module
# 6. Reports

| ID     | Functional Requirement                                    | Priority |
|--------|-----------------------------------------------------------|----------|
| FR-036 | The system shall generate daily booking reports.          | Should   |
| FR-037 | The system shall generate monthly booking reports.        | Should   |
| FR-038 | The system shall generate revenue reports.                | Should   |
| FR-039 | The system shall display pending payment reports.         | Must     |
| FR-040 | The system shall display pending return reports.          | Must     |
| FR-041 | The system shall generate inventory availability reports. | Should   |
Authentication Module
# 7. Authentication

| ID     | Functional Requirement                                           | Priority |
|--------|------------------------------------------------------------------|----------|
| FR-042 | The system shall allow the owner to log in securely.             | Must     |
| FR-043 | The system shall allow the owner to change the account password. | Must     |
| FR-044 | The system shall terminate inactive user sessions automatically. | Should   |
Future Enhancements
# 8. Future Enhancements

| ID     | Functional Requirement                                                | Priority |
|--------|-----------------------------------------------------------------------|----------|
| FR-045 | The system shall support multiple users with different roles.         | Future   |
| FR-046 | The system shall send booking reminders to customers.                 | Future   |
| FR-047 | The system shall support online payment integration.                  | Future   |
| FR-048 | The system shall provide a mobile application.                        | Future   |
| FR-049 | The system shall provide dashboard analytics.                         | Future   |
| FR-050 | The system shall support barcode or QR code based inventory tracking. | Future   |
