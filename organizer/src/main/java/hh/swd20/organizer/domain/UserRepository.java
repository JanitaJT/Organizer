package hh.swd20.organizer.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByuserName(String userName);
}
