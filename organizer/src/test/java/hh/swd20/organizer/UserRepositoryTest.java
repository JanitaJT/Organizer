package hh.swd20.organizer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.organizer.domain.User;
import hh.swd20.organizer.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsername() {
	User users = repository.findByuserName("admin");
		assertThat(users);
	}
	@Test
	public void addUser() {
		User user = new User("Test1234","Test1234","test","test","$2b$10$98p3oJwfsXOMMLkRXy088Ou9s.jeOotErPolxNPF8FuIY9sET3VGe", "test1234.test@test.com", "USER");
		repository.save(user);
		assertThat(user.getUsId()).isNotNull();
	}
	
	@Test
	@Rollback(false)
	public void deleteUser() {
		User user = repository.findById(Long.valueOf(1)).get();
		repository.delete(user);
		
		Optional<User> deleteUser = repository.findById(Long.valueOf(1));
		assertThat(deleteUser).isEmpty();
	}
}
