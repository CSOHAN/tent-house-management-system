# Business Requirements Document (BRD)

## 1. Introduction

# Business Requirements Document (BRD)

| Project      | Tent House Management System (THMS) |
|--------------|-------------------------------------|
| Version      | 1.0                                 |
| Status       | Draft                               |
| Author       | C. Sohan                            |
| Reviewed By  | Pending                             |
| Created On   | 02-Jul-2026                         |
| Last Updated | 02-Jul-2026                         |

## 1.1 Purpose

The primary purpose of this project is to digitize and automate the day-to-day operations of a tent house business.
Currently, business records are maintained manually, making it difficult to track customer bookings, inventory, payments, and event details. Manual record-keeping often results in missing or misplaced records, inventory discrepancies, and difficulties in managing changes to existing bookings.
This system aims to provide a centralized platform that enables efficient booking management, accurate inventory tracking, payment monitoring, and business reporting.
Additionally, this project serves as a real-world enterprise software application to demonstrate modern Java backend development skills using Spring Boot and related technologies.

## 1.2 Business Overview

**Business Name:** Sri Lakshmi Shamiyana
**Years in Business:** 14 Years
**Location:** T. Narasipura, Karnataka, India

### Business Description

Sri Lakshmi Shamiyana is a tent house rental business that has been serving customers for over 14 years. The business provides tents (shamiyana), furniture, and event-related rental items for various occasions.
The business primarily serves customers in and around T. Narasipura and nearby areas, offering rental services for both small and medium-sized events.
### Types of Events
The business provides rental services for:
- Weddings
- Birthday Celebrations
- Religious Functions
- House Functions
- Funeral Services
- Community Events
- Small Gatherings

### Business Volume

- Average Bookings Per Month: **15–20**
- Business Type: **Event Equipment Rental**

### 1.3 Business Objectives

## 1.3 Business Objectives

The primary objectives of the Tent House Management System are:

- Digitize all business operations and eliminate manual record keeping.
- Maintain a centralized database for customers, bookings, inventory, and payments.
- Prevent loss of customer records and booking information.
- Track inventory accurately and reduce missing or lost rental items.
- Simplify modifications to existing bookings.
- Provide quick access to customer and booking history.
- Monitor advance payments, pending balances, and completed payments.
- Generate business reports for better decision-making.
- Improve operational efficiency and reduce manual effort.
- Build a scalable software solution that can support future business growth.

## 2. Current Business Process

### Customer Booking Process

1. The customer contacts the business by phone or visits the shop.
2. The customer provides the event details, including:
    - Event date
    - Event location
    - Type of event
    - Required rental items and quantities
3. The owner checks the availability of the requested items.
4. If the items are available, the booking is confirmed.
5. The booking details are recorded manually.

---

### Delivery Process

1. On the scheduled date, the required rental items are prepared.
2. An auto/transport vehicle is arranged.
3. The items are loaded into the vehicle.
4. The items are delivered to the customer's event location.
5. Workers set up the required items if necessary.

---

### Additional Item Requests

During the event, customers may request additional rental items.

Example:

- Extra chairs
- Extra tables
- Additional shamiyana
- Extra lighting

The owner checks inventory availability.

If available:
- Additional items are sent to the event location.
- The booking is updated with the newly delivered items.
- Additional charges are added to the final bill.

---

### Item Return Process

1. After the event is completed, the customer contacts the business.
2. An auto/transport vehicle is arranged.
3. Workers visit the event location.
4. All rented items are counted and verified.
5. The items are transported back to the warehouse.
6. Missing or damaged items are identified.
7. The booking is marked as completed after inventory verification.

## Payment Process

### Advance Payment

Advance payment is optional.

Business Rules:

- Customers may pay an advance amount during booking.
- Customers may also choose not to pay any advance.
- The remaining balance is generally collected after the event is completed.
- The system should maintain the following:
    - Total Amount
    - Advance Paid
    - Pending Balance
    - Payment Status

---

## Additional Item Requests

Customers may request additional rental items while the event is in progress.

Business Rules:

- Additional items are supplied only if inventory is available.
- The booking should be updated with the newly supplied items.
- Additional charges should automatically be added to the booking's total amount.
- All additional item requests should be recorded for future reference.

---

## Missing Item Handling

Sometimes customers do not return all rented items immediately.

Business Rules:

- Missing items should be marked as **Pending Return**.
- Customers may return the missing items later.
- The booking should remain open until all pending items are returned or the owner decides to close the booking.
- The system should maintain a history of pending returns.

---

## Damaged Item Handling

If any rented item is returned in damaged condition:

Business Rules:

- The damaged item should be recorded.
- The owner can specify the damage charges.
- Damage charges should be added to the customer's final bill.
- The damaged inventory should no longer be considered available until repaired or replaced.


## System Users

### Primary User

The system is primarily designed for the business owner.

### Responsibilities

The owner can:

- Manage customers
- Create and update bookings
- Manage inventory
- Add new inventory items
- Update item quantities
- Record payments
- Track pending returns
- Record damaged items
- Generate invoices
- View reports

Future versions of the system may support additional roles such as Manager or Staff.

Note: We'll still design the application with role-based access in mind, but initially we'll only have one role: OWNER.

## Discount Policy

Customers may negotiate rental prices.

Business Rules:

- Discounts are optional.
- The owner decides whether to provide a discount.
- The discount amount should be recorded.
- The final payable amount should reflect the applied discount.

## Booking Modification

Customers may modify an existing booking before or during the event.

Examples:

- Reduce the quantity of booked items.
- Add additional rental items.
- Remove items that are no longer required.

Business Rules:

- The booking total should be recalculated automatically.
- Inventory should be updated accordingly.
- A history of booking modifications should be maintained.

## Booking Identification

Each booking should contain:

- Booking Number (System Generated)
- Customer Name
- Mobile Number
- Event Location
- Event Date

The booking number will be the primary identifier within the system, while customer name and mobile number will help users search for bookings.

# 3. Business Problems

The business currently faces several operational challenges due to manual record keeping and the absence of a centralized management system.

### Identified Problems

- Customer bookings are maintained manually, increasing the risk of losing records.
- Updating an existing booking is difficult and time-consuming.
- Inventory items are not tracked accurately, resulting in missing or lost items.
- There is no easy way to check the availability of rental items.
- Additional items requested during an event are recorded manually and can be forgotten.
- Transport charges are calculated manually.
- Pending payments are difficult to track.
- Damaged items are not systematically recorded.
- Business reports and income summaries are not readily available.

# 4. Business Goals

The primary goals of the system are:

- Digitize all business operations.
- Maintain accurate booking records.
- Track inventory availability in real time.
- Reduce inventory loss.
- Simplify booking modifications.
- Record additional item requests during events.
- Track customer payments and pending balances.
- Record damaged and missing items.
- Generate invoices automatically.
- Generate business reports.
- Reduce manual work and improve efficiency.

# 5. Stakeholders

The following stakeholders are involved in the business.

## Primary Stakeholder

### Owner

Responsibilities:

- Manage customers
- Create bookings
- Update bookings
- Manage inventory
- Record payments
- Generate reports
- Track pending returns
- Record damaged items

---

## Secondary Stakeholders

### Customers

Customers rent items for events.

### Transport Provider

External auto/tempo drivers hired for delivering and collecting rental items.

# 6. Assumptions

The following assumptions are considered during system development.

- Only the business owner will use the system in Version 1.
- Inventory data will be entered into the system before daily operations.
- Customers provide accurate contact details.
- Internet connectivity is available whenever the application is used.
- Transport vehicles are hired externally.
- Pricing may vary depending on customer negotiation.

# 7. Constraints

The following constraints apply to the project.

- Initial version supports only a single business.
- Only one owner account will be available.
- Workers will not access the application directly.
- Transport vehicles are not owned by the business.
- Inventory quantities must be maintained accurately by the owner.
- The application is initially designed for desktop/web usage.

# 8. Success Criteria

The project will be considered successful if it achieves the following objectives.

- 100% digital booking management.
- Elimination of manual booking records.
- Accurate inventory tracking.
- Ability to modify bookings easily.
- Ability to track additional item requests.
- Accurate payment tracking.
- Automatic invoice generation.
- Reduced inventory loss.
- Reduced manual effort.
- Faster booking creation and retrieval.
- Improved customer service.

