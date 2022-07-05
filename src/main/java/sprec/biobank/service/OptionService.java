package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Option;
import sprec.biobank.repository.OptionRepository;

@Service
public class OptionService {
	
	@Autowired
	private OptionRepository optionRepository;
	
	public Iterable<Option> getAllOptions() {
		return optionRepository.findAll();
	}
	
	public Optional<Option> getOptionById(Integer id){
		return optionRepository.findById(id);
	}
	
	public Option addOption(Option option) {
		return optionRepository.save(option);
	}
	
	public String deleteOption(Integer id) {
		Optional<Option> obj = getOptionById(id);
		if(obj.isPresent()) {		
			optionRepository.deleteById(id);
			return "deleted";
		}
		return "object not found!";
	}
	
	
	/*
	 * public String updateFreezer(Integer id, Freezer newFreezer){
		Optional<Freezer> freezer = freezerRepository.findById(id);
		
		if(freezer.isPresent()) {
			Freezer r = freezer.get(); //conversione Optional<Freezer> in Freezer
			
			r.setName(newFreezer.getName());
			r.setCreatedAt(newFreezer.getCreatedAt());
			r.setDeletedAt(newFreezer.getDeletedAt());
			r.setUpdatedAt(newFreezer.getUpdateAt());
			freezerRepository.save(r); //si salva perchè deve tornare nel db, se no abbiamo solo aggiornato i valori dell'oggetto
			return "elemento aggiornato";
		}
		return "elemento non trovato, aggiornamento non avvenuto";
	}
	*/
	
	/* versione con map */
	public String updateOption(Integer id, Option newOption) {
		return optionRepository.findById(id).map(option -> {
			option.setName(newOption.getName());
			//freezer.setCreatedAt(newFreezer.getCreatedAt());
			//freezer.setDeletedAt(newFreezer.getDeletedAt());
			//freezer.setUpdatedAt(newFreezer.getUpdateAt());
			optionRepository.save(option);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
}
