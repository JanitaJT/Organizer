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
import hh.swd20.organizer.domain.Item;
import hh.swd20.organizer.domain.ItemRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findByiName() {
		List<Item> items = repository.findByiName("Nahkatakki");
		assertThat(items).hasSize(1);
	}
	
	@Test
	public void addItem() {
		Item item = new Item("Test", "Test", true, null, null);
		repository.save(item);
		assertThat(item.getItemId()).isNotNull();
		
	}
	
	@Test
	@Rollback(false)
	public void deleteItem() {
		Item item = repository.findById(Long.valueOf(5)).get();
		repository.delete(item);
		
		Optional<Item> deleteItem = repository.findById(Long.valueOf(5));
		assertThat(deleteItem).isEmpty();
	}
}
