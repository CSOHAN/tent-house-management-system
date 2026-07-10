package com.thms.tenthouse.booking.repository;

import com.thms.tenthouse.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerCustomerId(Long customerId);

    List<Booking> findByEventDate(LocalDate eventDate);

    List<Booking> findByPaymentStatus(String paymentStatus);

    List<Booking> findByBookingStatusIgnoreCase(
        String bookingStatus);
}
