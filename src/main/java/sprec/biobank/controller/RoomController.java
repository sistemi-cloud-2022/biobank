package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sprec.biobank.domain.Room;
import sprec.biobank.service.RoomService;

@Controller
@RequestMapping("/biobank/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/")
	public @ResponseBody Iterable<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
		Optional<Room> room = roomService.getRoomById(id);
	    if(room.isPresent())
	    	return ResponseEntity.ok().body(room.get());
	    return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/")
	public @ResponseBody Room insertRoom(@Valid @RequestBody Room room) {
		return roomService.addRoom(room);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody String insertRoom(@Valid @PathVariable Integer id) {
		return roomService.deleteRoom(id);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateRoom(@PathVariable Integer id, @Valid @RequestBody Room newRoom) {
		return roomService.updateRoom(id, newRoom);
	}	
	
}
