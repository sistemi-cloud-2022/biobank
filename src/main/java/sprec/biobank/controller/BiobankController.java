package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sprec.biobank.domain.Biobank;
import sprec.biobank.service.BiobankService;

@RestController
@RequestMapping("/biobank/biobanks")
public class BiobankController {
	
	@Autowired
	BiobankService biobankService;
	
	//Read
	@GetMapping("")
	public @ResponseBody Iterable<Biobank> getBiobankByName(@RequestParam String name){
		return biobankService.getBiobankByName(name);
	}
	
	@GetMapping("/")
	public @ResponseBody Iterable<Biobank> getAllBiobanks(){
		return biobankService.getAllBiobanks();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Biobank> getBiobankById(@PathVariable int id) {
		return biobankService.getBiobankById(id);
	}
	
	//Create
	@PostMapping("/")
	public @ResponseBody Biobank addBiobank(@Valid @RequestBody Biobank biobank) {
		return biobankService.addBiobank(biobank);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public String deleteBiobankById(@PathVariable int id) {
		return biobankService.deleteBiobankById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public @ResponseBody Biobank updateBiobank(@PathVariable int id, @Valid @RequestBody Biobank biobank){
		return biobankService.updateBiobank(id, biobank);
	}
}