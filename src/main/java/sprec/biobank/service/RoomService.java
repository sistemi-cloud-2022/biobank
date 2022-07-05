package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Room;
import sprec.biobank.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Iterable<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	public Optional<Room> getRoomById(Integer id){
		return roomRepository.findById(id);
	}
	
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
	
	public String deleteRoom(Integer id) {
		return roomRepository.findById(id).map(room -> {
			room.setDeletedAt();
			roomRepository.save(room);
			roomRepository.deleteById(id);
			return "eliminato";
		}).orElseGet(() -> {
			return "elemento non trovato, eliminazione non avvenuta";
		});
	}
	
	/* lambda ex */
	public String updateRoom(Integer id, Room newRoom) {
		return roomRepository.findById(id).map(room -> {
			room.setName(newRoom.getName());
			//room.setCreatedAt(newRoom.getCreatedAt());
			//room.setDeletedAt(newRoom.getDeletedAt());
			room.setUpdatedAt();
			roomRepository.save(room);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
}