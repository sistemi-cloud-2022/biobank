package sprec.biobank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sprec.biobank.domain.Freezer;

public interface FreezerRepository extends CrudRepository<Freezer, Integer> {
	public Optional<Freezer> findById(Integer id);
	public void deleteById(Integer id);
}
