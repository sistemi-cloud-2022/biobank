package sprec.biobank.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sprec.biobank.domain.DocumentType;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer> {
	
}
