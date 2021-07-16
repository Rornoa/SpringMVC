package com.example.springmvc.controller;

import com.example.springmvc.model.Guest;
import com.example.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repository.GuestRepository;
import com.example.springmvc.repository.UserRepository;

import java.util.List;

@RequestMapping(value = "/api/guest")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createGuest(@RequestParam String firstName,@RequestParam String secondName){
        Guest guest = new Guest(firstName,secondName);
        guest = guestRepository.save(guest);
        return ResponseEntity.ok("Guest "+firstName+" "+secondName+" successfully created");
    }

    @RequestMapping(value="all",method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> getAllGuests(){
        List<Guest> guests = guestRepository.findAll();
        return guests;
    }

}
