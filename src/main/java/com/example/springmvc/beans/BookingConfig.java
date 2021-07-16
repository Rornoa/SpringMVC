package com.example.springmvc.beans;

import com.example.springmvc.model.Booking;
import com.example.springmvc.repository.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.time.*;
import java.util.List;

@Configuration
public class BookingConfig {

	@Bean
	CommandLineRunner commandLineRunner(BookingRepository repository) {
		return (args) -> {
			Booking booking1 = new Booking(
				"name",
				LocalDate.of(2000, Month.APRIL, 10),
				"vasilii@outlook.com"
			);

			Booking booking2 = new Booking(
				"ghbdhdhdhdh",
				LocalDate.of(2000, Month.NOVEMBER, 10),
				"vasilii@outlook.com"
			);

			repository.saveAll(List.of(booking1, booking2));
		};
	}
}
