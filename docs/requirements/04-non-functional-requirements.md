# Non-Functional Requirements (NFR)

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

This document defines the quality attributes and operational requirements of the Tent House Management System.

Unlike functional requirements, non-functional requirements describe how the system should perform and behave under various conditions.

# 1. Performance

| ID      | Requirement                                                                 |
|---------|-----------------------------------------------------------------------------|
| NFR-001 | The system should load dashboard pages within 3 seconds under normal usage. |
| NFR-002 | Customer search results should be displayed within 2 seconds.               |
| NFR-003 | Booking creation should complete within 5 seconds.                          |

---

# 2. Security

| ID      | Requirement                                                 |
|---------|-------------------------------------------------------------|
| NFR-004 | Only authenticated users can access the system.             |
| NFR-005 | Passwords shall be securely encrypted before storage.       |
| NFR-006 | User sessions should expire automatically after inactivity. |

---

# 3. Reliability

| ID      | Requirement                                             |
|---------|---------------------------------------------------------|
| NFR-007 | The system shall preserve booking data without loss.    |
| NFR-008 | Database transactions should maintain data consistency. |

---

# 4. Availability

| ID      | Requirement                                                         |
|---------|---------------------------------------------------------------------|
| NFR-009 | The application should be available whenever the owner requires it. |
| NFR-010 | Scheduled maintenance should not result in data loss.               |

---

# 5. Scalability

| ID      | Requirement                                                           |
|---------|-----------------------------------------------------------------------|
| NFR-011 | The application should support future expansion to multiple branches. |
| NFR-012 | The application architecture should support additional user roles.    |

---

# 6. Maintainability

| ID      | Requirement                                              |
|---------|----------------------------------------------------------|
| NFR-013 | Source code shall follow clean coding principles.        |
| NFR-014 | The project shall follow a layered architecture.         |
| NFR-015 | All REST APIs shall be documented using OpenAPI/Swagger. |

---

# 7. Backup and Recovery

| ID      | Requirement                                        |
|---------|----------------------------------------------------|
| NFR-016 | Database backups should be performed regularly.    |
| NFR-017 | The system should support restoration from backup. |

---

# 8. Logging and Monitoring

| ID      | Requirement                                                  |
|---------|--------------------------------------------------------------|
| NFR-018 | All application errors should be logged.                     |
| NFR-019 | Important business operations should be logged for auditing. |

---

# 9. Compatibility

| ID      | Requirement                                                                           |
|---------|---------------------------------------------------------------------------------------|
| NFR-020 | The application should support modern web browsers such as Chrome, Edge, and Firefox. |
| NFR-021 | The backend shall be compatible with Java 21.                                         |
