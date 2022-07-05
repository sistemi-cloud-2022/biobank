package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Biobank;
import sprec.biobank.repository.BiobankRepository;

@Service
public class BiobankService {
	
	@Autowired
	BiobankRepository biobankRepository;
	
	public Iterable<Biobank> findAll(){
		return biobankRepository.findAll();
	}
	
	public Biobank addBiobank(Biobank biobank) {
		return biobankRepository.save(biobank);
	}
	
	public Iterable<Biobank> getBiobankByName(String name) {
		return biobankRepository.findByName(name);
	}

	public Iterable<Biobank> getAllBiobanks() {
		return biobankRepository.findAll();
	}
	
	public Optional<Biobank> getBiobankById(Integer id) {
		return biobankRepository.findById(id);
	}

	public String deleteBiobankById(Integer id) {
		Optional<Biobank> ob = biobankRepository.findById(id);
		if(ob.isPresent()) {
			biobankRepository.deleteById(id);
			return "object deleted";
		}	
		return "object not found!";
	}
	
	//per quando si aggiorna con il @PathVariable fornendo l'id
	public Biobank updateBiobank(Integer id, Biobank b) {
		return biobankRepository.findById(id).map(biobank -> {
			biobank.setName(b.getName());
			biobank.setAcronym(b.getAcronym());
			biobank.setUrl(b.getUrl());
			biobank.setJuristicPerson(b.getJuristicPerson());
			biobank.setCountry(b.getCountry());
			biobank.setContactInformation(b.getContactInformation());
			biobank.setDescription(b.getDescription());
			
			return biobankRepository.save(biobank);
		})
		.orElseGet(() -> {
			b.setId(id);
			return biobankRepository.save(b);}); 
	}
	
	/*
	//per quando si aggiorna fornendo solo l'oggetto dentro la richiesta
	public Biobank updateBiobank(Biobank b) {
		return biobankRepository.findById(b.getId()).map(biobank -> {
			biobank.setName(b.getName());
			biobank.setAcronym(b.getAcronym());
			biobank.setUrl(b.getUrl());
			biobank.setJuristicPerson(b.getJuristicPerson());
			biobank.setCountry(b.getCountry());
			biobank.setContactInformation(b.getContactInformation());
			biobank.setDescription(b.getDescription());
			
			return biobankRepository.save(biobank);
		}).orElseGet(() -> {return biobankRepository.save(b);}); //idem
	}
	*/
}
