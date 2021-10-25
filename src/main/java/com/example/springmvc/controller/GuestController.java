package com.example.springmvc.controller;

import com.example.springmvc.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repository.GuestRepository;

import java.util.List;

@RequestMapping(value = "/hotelit/guest")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createGuest(@RequestParam String name,@RequestParam String lastName){
        Guest guest = new Guest(name,lastName);
        guest = guestRepository.save(guest);
        return ResponseEntity.ok("Guest "+name+" "+lastName+" successfully created");
    }

    @RequestMapping(value="all",method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> getAllGuests(){
        List<Guest> guests = guestRepository.findAll();
        return guests;
    }

}
