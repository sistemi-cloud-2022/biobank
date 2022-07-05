package sprec.biobank.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sprec.biobank.domain.DocumentType;
import sprec.biobank.service.DocumentTypeService;

@Controller
@RequestMapping("/biobank/documentTypes")
public class DocumentTypeController {
	
	@Autowired
	DocumentTypeService documentTypeService;
	
	//Read
	@GetMapping("/")
	public @ResponseBody Iterable<DocumentType> getAllDocumentTypes(){
		return documentTypeService.getAllDocumentTypes();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<DocumentType> getDocumentTypeById(@PathVariable Integer id){
		return documentTypeService.getDocumentTypeById(id);
	}
	
	//Post
	@PostMapping("/")
	public @ResponseBody DocumentType addDocumentType(@RequestBody @Valid DocumentType documentType) {
		return documentTypeService.addDocumentType(documentType);
	}
	
	//fare delete e put

}
