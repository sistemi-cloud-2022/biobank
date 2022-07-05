package sprec.biobank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sprec.biobank.domain.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer> {
	public Optional<Document> findById(Integer id);
	public void deleteById(Integer id);
}
