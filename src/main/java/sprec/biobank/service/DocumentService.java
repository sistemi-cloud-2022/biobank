package sprec.biobank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprec.biobank.domain.Document;
import sprec.biobank.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	
	public Iterable<Document> getAllDocuments() {
		return documentRepository.findAll();
	}
	
	public Document addDocument(Document document) {
		return documentRepository.save(document);
	}

	public Optional<Document> getDocumentById(Integer id) {
		return documentRepository.findById(id);
	}

	public String deleteDocumentById(Integer id) {
		Optional<Document> ob = documentRepository.findById(id);
		if(ob.isPresent()) {
			documentRepository.deleteById(id);
			return "object deleted";
		}	
		return "object not found!";
	}
	
	public String updateDocument(Integer id, Document newDocument) {
		return documentRepository.findById(id).map(document -> {
			document.setObjectId(newDocument.getObjectId());
			document.setFileName(newDocument.getFileName());
			document.setSize(newDocument.getSize());
			document.setGuid(newDocument.getGuid());
			document.setTypeId(newDocument.getTypeId());
			document.setCreatedAt(newDocument.getCreatedAt());
			document.setDeletedAt(newDocument.getDeletedAt());
			document.setUpdatedAt(newDocument.getUpdateAt());
			documentRepository.save(document);
			return "elemento aggiornato";
		}).orElseGet(() -> {
			return "elemento non trovato, aggiornamento non avvenuto";
		});
	}
	
	/*
	//per quando si aggiorna fornendo solo l'oggetto dentro la richiesta
	public Document updateDocument(Document b) {
		return documentRepository.findById(b.getId()).map(document -> {
			document.setName(b.getName());
			document.setAcronym(b.getAcronym());
			document.setUrl(b.getUrl());
			document.setJuristicPerson(b.getJuristicPerson());
			document.setCountry(b.getCountry());
			document.setContactInformation(b.getContactInformation());
			document.setDescription(b.getDescription());
			
			return documentRepository.save(document);
		}).orElseGet(() -> {return documentRepository.save(b);}); //idem
	}
	*/
	
}
