package com.example.springmvc.service;

import com.example.springmvc.model.Booking;
import com.example.springmvc.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

	public void addNewBooking(Booking booking) {
		Optional<Booking> bookingOptional = bookingRepository.findBookingByEmail(booking.getEmail());

		if (bookingOptional.isPresent()) {
			throw new IllegalStateException("Email has already registered!"); // // TODO: 15/06/2021 change it to
			// custom ex
		}

		//much more validation may needed

		bookingRepository.save(booking);
	}


	@Transactional
	public void updateBooking(Long bookingId, String clientName, String email) {
		Booking booking = bookingRepository
			.findById(bookingId)
			.orElseThrow(() -> new IllegalStateException("Id Search error"));

		if (clientName != null && clientName.length() > 0
			&& !Objects.equals(booking.getClientName(), clientName)) {
			booking.setClientName(clientName);
		}

		if (email != null && email.length() > 0 && !Objects.equals(booking.getEmail(), email)) {

			Optional<Booking> optionalBooking = bookingRepository.findBookingByEmail(email);
			if (optionalBooking.isPresent()) {
				throw new IllegalStateException("Email is already taken!");
			}

			booking.setEmail(email);
		}

	}

	public void deleteBooking(Long bookingId) {
		boolean exists = bookingRepository.existsById(bookingId);
		if (!exists) {
			throw new IllegalStateException("Booking with id" + bookingId + " does not exists!");
		}
		bookingRepository.deleteById(bookingId);
	}
}
