package com.thms.tenthouse.booking.service;

import com.thms.tenthouse.booking.dto.BookingRequestDto;
import com.thms.tenthouse.booking.dto.BookingResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingResponseDto createBooking(
        BookingRequestDto requestDto);

    List<BookingResponseDto> getAllBookings();

    BookingResponseDto getBookingById(Long id);

    BookingResponseDto updateBooking(
        Long id,
        BookingRequestDto requestDto);

    void cancelBooking(Long id);

    List<BookingResponseDto>
    getBookingsByCustomerId(Long customerId);

    List<BookingResponseDto>
    getBookingsByEventDate(LocalDate eventDate);

    List<BookingResponseDto>
    getBookingsByStatus(String status);
}
