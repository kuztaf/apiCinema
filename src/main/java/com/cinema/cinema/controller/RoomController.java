package com.cinema.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinema.dto.RoomRequestDto;
import com.cinema.cinema.dto.SeatRequestDto;
import com.cinema.cinema.entity.Room;
import com.cinema.cinema.service.RoomService;
import com.cinema.cinema.service.SeatService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private SeatService seatService;

    @GetMapping("/")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoomById(@PathVariable int id) {
        Room deletedRoom = roomService.deleteRoomById(id);
        if (deletedRoom != null) {
            return ResponseEntity.ok(deletedRoom);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody RoomRequestDto roomRequestDto) {
        Room updatedRoom = roomService.updateRoom(id, roomRequestDto);
        if (updatedRoom != null) {
            return ResponseEntity.ok(updatedRoom);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Room> addRoom(@RequestBody RoomRequestDto roomRequestDto) {
        Room newRoom = roomService.addRoom(roomRequestDto);
        if (newRoom != null) {
            createSeatsForRoom(newRoom);
            return ResponseEntity.status(201).body(newRoom);
        }
        return ResponseEntity.badRequest().build();
    }

    private void createSeatsForRoom(Room newRoom) {
        // create all seats for the room
        // each col = 10 and each row = capacity / 10
        int cols = 10;
        int rows = newRoom.getCapacity() / cols;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                SeatRequestDto seatRequestDto = new SeatRequestDto(row, col, newRoom);
                seatService.addSeat(seatRequestDto);
            }
        }
    }

}
