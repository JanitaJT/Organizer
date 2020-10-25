package hh.swd20.organizer;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findBycName() {
		List<Category> categories = repository.findBycName("Kengät");
		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void addCategory() {
		Category category = new Category("test", "test");
		repository.save(category);
		assertThat(category.getCateId()).isNotNull();
	}
}
