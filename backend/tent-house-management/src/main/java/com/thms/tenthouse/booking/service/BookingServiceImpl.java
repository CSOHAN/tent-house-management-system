package com.thms.tenthouse.booking.service;

import com.thms.tenthouse.booking.dto.BookingRequestDto;
import com.thms.tenthouse.booking.dto.BookingResponseDto;
import com.thms.tenthouse.booking.entity.Booking;
import com.thms.tenthouse.booking.repository.BookingRepository;
import com.thms.tenthouse.common.exceptions.BookingNotFoundException;
import com.thms.tenthouse.customer.entity.Customer;
import com.thms.tenthouse.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;

    private BookingResponseDto mapToResponse(Booking booking) {
        return BookingResponseDto.builder()
            .bookingId(booking.getBookingId())
            .customerId(booking.getCustomer().getCustomerId())
            .customerName(booking.getCustomer().getName())
            .mobileNumber(booking.getCustomer().getMobileNumber())
            .place(booking.getCustomer().getPlace())
            .eventDate(booking.getEventDate())
            .eventPlace(booking.getEventPlace())
            .bookingStatus(booking.getBookingStatus())
            .totalAmount(booking.getTotalAmount())
            .advancePaid(booking.getAdvancePaid())
            .balanceAmount(booking.getBalanceAmount())
            .transportChargeDelivery(
                booking.getTransportChargeDelivery())
            .transportChargeReturn(
                booking.getTransportChargeReturn())
            .discount(booking.getDiscount())
            .damageCharge(booking.getDamageCharge())
            .missingCharge(booking.getMissingCharge())
            .finalAmount(booking.getFinalAmount())
            .paymentStatus(booking.getPaymentStatus())
            .createdAt(booking.getCreatedAt())
            .updatedAt(booking.getUpdatedAt())
            .build();
    }

    @Override
    public BookingResponseDto createBooking(
        BookingRequestDto requestDto) {

        Customer customer =
            customerRepository
                .findByMobileNumber(
                    requestDto.getMobileNumber())
                .orElseGet(() -> {

                    Customer newCustomer =
                        Customer.builder()
                            .name(
                                requestDto.getName())
                            .mobileNumber(
                                requestDto.getMobileNumber())
                            .place(
                                requestDto.getPlace())
                            .build();

                    return customerRepository
                        .save(newCustomer);
                });

        Booking booking =
            Booking.builder()
                .customer(customer)
                .eventDate(
                    requestDto.getEventDate())
                .eventPlace(
                    requestDto.getEventPlace())

                .advancePaid(
                    requestDto.getAdvancePaid())
                .transportChargeDelivery(
                    requestDto.getTransportChargeDelivery())
                .transportChargeReturn(
                    requestDto.getTransportChargeReturn())
                .discount(
                    requestDto.getDiscount())

                .bookingStatus("BOOKED")
                .paymentStatus("PENDING")

                .build();

        Booking savedBooking =
            bookingRepository.save(booking);

        return mapToResponse(savedBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDto> getAllBookings() {
        return bookingRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookingResponseDto getBookingById(Long id) {

        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() ->
                new BookingNotFoundException(
                    "Booking not found"));

        return mapToResponse(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDto>
    getBookingsByCustomerId(Long customerId) {

        return bookingRepository
            .findByCustomerCustomerId(customerId)
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDto>
    getBookingsByEventDate(
        LocalDate eventDate) {

        return bookingRepository
            .findByEventDate(eventDate)
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDto>
    getBookingsByStatus(String status) {

        return bookingRepository
            .findByBookingStatusIgnoreCase(status)
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    @Transactional
    public BookingResponseDto updateBooking(
        Long id,
        BookingRequestDto requestDto) {

        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() ->
                new BookingNotFoundException(
                    "Booking not found"));

        booking.setEventDate(
            requestDto.getEventDate());

        booking.setEventPlace(
            requestDto.getEventPlace());

        booking.setAdvancePaid(
            requestDto.getAdvancePaid());

        booking.setTransportChargeDelivery(
            requestDto.getTransportChargeDelivery());

        booking.setTransportChargeReturn(
            requestDto.getTransportChargeReturn());

        booking.setDiscount(
            requestDto.getDiscount());

        Booking updatedBooking =
            bookingRepository.save(booking);

        return mapToResponse(updatedBooking);
    }

    @Override
    @Transactional
    public void cancelBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() ->
                new BookingNotFoundException(
                    "Booking not found"));

        booking.setBookingStatus("CANCELLED");

        bookingRepository.save(booking);
    }
}


