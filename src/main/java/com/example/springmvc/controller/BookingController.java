package com.example.springmvc.controller;

import com.example.springmvc.model.Booking;
import com.example.springmvc.repository.BookingRepository;
import com.example.springmvc.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/hotelit/booking")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IBookingService bookingService;

    @PostMapping("/createBooking")
    public ResponseEntity<String> createBooking(@RequestParam String firstName, String secondName, String thirdName, String phoneNumber, String email, String arrivalDate, String departmentDate, Long wholePeriodPrice, int peopleAmount,String additionalInfo){
        try {
            Booking booking = new Booking(firstName, secondName, thirdName, phoneNumber, email, arrivalDate, departmentDate, wholePeriodPrice, peopleAmount, additionalInfo);
            booking = bookingRepository.save(booking);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value="getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> getAllBookings(){
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    @RequestMapping(value="getGreaterArrival", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> getArrivalGreaterThan(@RequestParam Date arrival){
        List<Booking>  bookings = bookingRepository.findAllByArrivalGreaterThan(arrival);
        return bookings;
    }

}
