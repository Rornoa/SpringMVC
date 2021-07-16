package com.example.springmvc.controller;

import com.example.springmvc.model.Booking;
import com.example.springmvc.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/booking")
public class BookingController {

	private final BookingService bookingService;

	@Autowired
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@GetMapping
	public List<Booking> getBookings() {
		return bookingService.getBookings();
	}

	@PostMapping
	public void registerNewBooking(@RequestBody Booking booking) {
		bookingService.addNewBooking(booking);
	}

	@DeleteMapping(path = "{bookingId}")
	public void deleteStudent(@PathVariable("bookingId") Long bookingId) {
		bookingService.deleteBooking(bookingId);
	}

	@PutMapping(path = "{bookingId}")
	public void updateBookingDetails(@PathVariable("bookingId") Long bookingId,
									 @RequestParam(required = false, name = "cool") String name,
									 @RequestParam(required = false) String email) {
		bookingService.updateBooking(bookingId, name, email);
	}

}
