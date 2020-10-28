package hh.swd20.organizer;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BoxRepositoryTest {
	
	@Autowired
	private BoxRepository repository;
	
//	@Test
//	public void findBybName() {
//		List<Box> boxes = repository.findBybName("Kesä");
//		assertThat(boxes).hasSize(1);
//	}
	
	@Test
	public void addBox() {
		Box box = new Box("test", "test", false, "test");
		repository.save(box);
		assertThat(box.getBoxId()).isNotNull();
		
	}
	
	@Test
	@Rollback(false)
	public void deleteBox() {
		Box box = repository.findById(Long.valueOf(2)).get();
		repository.delete(box);
		
		Optional<Box> deleteBox = repository.findById(Long.valueOf(2));
		assertThat(deleteBox).isEmpty();
	}

}
