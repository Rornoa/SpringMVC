package com.example.springmvc.repository;

import com.example.springmvc.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	Optional<Booking> findBookingByEmail(String email);

}
