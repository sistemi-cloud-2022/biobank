package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sprec.biobank.domain.Document;
import sprec.biobank.service.DocumentService;

@Controller
@RequestMapping("/biobank/documents")
public class DocumentController {
	@Autowired
	DocumentService documentService;
	
	//Read
	@GetMapping("/")
	public @ResponseBody Iterable<Document> getAllDocuments(){
		return documentService.getAllDocuments();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Document> getDocumentById(@PathVariable Integer id) {
		return documentService.getDocumentById(id);
	}
	
	//Create
	@PostMapping("/")
	public @ResponseBody Document addDocument(@Valid @RequestBody Document document) {
		return documentService.addDocument(document);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public @ResponseBody String deleteDocumentById(@PathVariable Integer id) {
		return documentService.deleteDocumentById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public @ResponseBody String updateDocument(@PathVariable Integer id, @Valid @RequestBody Document document){
		return documentService.updateDocument(id, document);
	}
}
