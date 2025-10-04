package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.RoomRequestDto;
import com.cinema.cinema.entity.Room;
import com.cinema.cinema.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room deleteRoomById(int id) {
        Room room = getRoomById(id);
        if (room != null) {
            roomRepository.delete(room);
            return room;
        }
        return null;
    }

    public Room updateRoom(int id, RoomRequestDto roomRequestDto) {
        Room existingRoom = getRoomById(id);
        if (existingRoom != null) {
            existingRoom.setName(roomRequestDto.name());
            existingRoom.setCapacity(roomRequestDto.capacity());
            return roomRepository.save(existingRoom);
        }
        return null;
    }

    public Room addRoom(RoomRequestDto roomRequestDto) {
        Room room = Room.builder()
                .name(roomRequestDto.name())
                .capacity(roomRequestDto.capacity())
                .build();
        return roomRepository.save(room);
    }
}
