package hh.swd20.organizer;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
		Item item = new Item("Test", "Test", true, null);
		repository.save(item);
		assertThat(item.getItemId()).isNotNull();
		
	}
}
