package com.thms.tenthouse.booking.controller;

import com.thms.tenthouse.booking.dto.BookingRequestDto;
import com.thms.tenthouse.booking.dto.BookingResponseDto;
import com.thms.tenthouse.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto createBooking(
        @Valid @RequestBody
        BookingRequestDto requestDto) {

        return bookingService
            .createBooking(requestDto);
    }

    @GetMapping
    public List<BookingResponseDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingResponseDto getBookingById(
        @PathVariable Long id) {

        return bookingService.getBookingById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<BookingResponseDto>
    getBookingsByCustomerId(
        @PathVariable Long customerId) {

        return bookingService
            .getBookingsByCustomerId(customerId);
    }

    @GetMapping("/date")
    public List<BookingResponseDto>
    getBookingsByEventDate(
        @RequestParam LocalDate eventDate) {

        return bookingService
            .getBookingsByEventDate(eventDate);
    }

    @GetMapping("/status/{status}")
    public List<BookingResponseDto>
    getBookingsByStatus(
        @PathVariable String status) {

        return bookingService
            .getBookingsByStatus(status);
    }

    @PutMapping("/{id}")
    public BookingResponseDto updateBooking(
        @PathVariable Long id,
        @RequestBody BookingRequestDto requestDto) {

        return bookingService
            .updateBooking(id, requestDto);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String>
    cancelBooking(@PathVariable Long id) {

        bookingService.cancelBooking(id);

        return ResponseEntity.ok(
            "Booking cancelled successfully");
    }
}
