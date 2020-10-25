package hh.swd20.organizer.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BoxRepository extends CrudRepository<Box, Long> {
	
	List<Box> findByName(String bName);

}
