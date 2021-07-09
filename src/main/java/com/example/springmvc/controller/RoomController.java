package com.example.springmvc.controller;

import com.example.springmvc.model.Room;
import com.example.springmvc.repository.GuestRepository;
import com.example.springmvc.repository.RoomRepository;
import com.example.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/room")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.ok(roomRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestParam int roomNumber){
        Room room = new Room(roomNumber);
        room = roomRepository.save(room);
        return ResponseEntity.ok("Room "+roomNumber+" successfully created");
    }

}
