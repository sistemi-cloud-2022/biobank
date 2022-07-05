package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.DocumentType;
import sprec.biobank.repository.DocumentTypeRepository;

@Service
public class DocumentTypeService {
	
	@Autowired
	DocumentTypeRepository documentTypeRepository;
	
	public Iterable<DocumentType> getAllDocumentTypes(){
		return documentTypeRepository.findAll();
	}
	
	public Optional<DocumentType> getDocumentTypeById(Integer id){
		return documentTypeRepository.findById(id);
	}
	
	public DocumentType addDocumentType(DocumentType documentType) {
		return documentTypeRepository.save(documentType);
	}
}
