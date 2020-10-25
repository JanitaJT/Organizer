package hh.swd20.organizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;
import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;
import hh.swd20.organizer.domain.Item;
import hh.swd20.organizer.domain.ItemRepository;

@SpringBootApplication
public class OrganizerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OrganizerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner boxDemo(BoxRepository boxRepository, ItemRepository itemRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("Test data");
			
			Box box1 = new Box("Talvi", "Janita talvitakkeja", true , "Varasto hylly 1");
			Box box2 = new Box("Kesä", "Janita kesätakkeja", false , "Varasto hylly 1");
			boxRepository.save(box1);
			boxRepository.save(box2);

			Category cate1 = new Category("Kengät", "kesäkenkiä");
			Category cate2 = new Category("Kesä", "Kesä takkeja");
			categoryRepository.save(cate1);
			categoryRepository.save(cate2);
			
			Item item1 = new Item("Nahkatakki", "Janita", true, box1, cate2);
			itemRepository.save(item1);
			
			log.info("Fetch boxes");
			for(Box box : boxRepository.findAll()) {
				log.info(box.toString());
			}
			
			log.info("Fetch Items");
			for (Item item : itemRepository.findAll()) {
				log.info(item.toString());
			}
			
			log.info("Fetch Categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
		
	}
}
