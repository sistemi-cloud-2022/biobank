package sprec.biobank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sprec.biobank.domain.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer>{
	public Optional<Room> findById(Integer id);
	public void deleteById(Integer id);
}