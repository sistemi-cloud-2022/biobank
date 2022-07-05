package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sprec.biobank.domain.Freezer;

import sprec.biobank.repository.FreezerRepository;

@Service
public class FreezerService {
	
	@Autowired
	private FreezerRepository freezerRepository;
	
	public Iterable<Freezer> getAllFreezers() {
		return freezerRepository.findAll();
	}
	
	public Optional<Freezer> getFreezerById(Integer id){
		return freezerRepository.findById(id);
	}
	
	public Freezer addFreezer(Freezer freezer) {
		return freezerRepository.save(freezer);
	}
	
	public String deleteFreezer(Integer id) {
		Optional<Freezer> obj = getFreezerById(id);
		if(obj.isPresent()) {
			Freezer freezer = obj.get();
			freezer.setDeletedAt();
			freezerRepository.save(freezer);
			freezerRepository.deleteById(id);
			return "deleted";
		}
		return "object not found!";
	}
	
	/* lambda ex */
	public String updateFreezer(Integer id, Freezer newFreezer) {
		return freezerRepository.findById(id).map(freezer -> {
			freezer.setName(newFreezer.getName());
			freezer.setParentId(newFreezer.getParentId());
			//freezer.setCreatedAt(newFreezer.getCreatedAt());
			//freezer.setDeletedAt(newFreezer.getDeletedAt());
			freezer.setUpdatedAt();
			freezer.setRoomId(newFreezer.getRoomId());
			freezerRepository.save(freezer);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
}
