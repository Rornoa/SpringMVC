package com.example.springmvc.repository;

import com.example.springmvc.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    List<Room> findApartmentsById(long id);

    List<Room> findRoomsByBedAmount(int bedAmount);

    List<Room> findRoomsByFloorNumber(int floorNumber);

    List<Room> findRoomsByCategory(Room.Category category);

    List<Room> findRoomsByWindowView(Room.View view);

    List<Room> findRoomsByPrice(int price);

    List<Room> findRoomsByRoomNumber(int roomNumber);

    List<Room> findRoomsByPricePerNight(int price);

    List<Room> findRoomsByStatus(Room.Status status);

}
