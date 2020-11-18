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
import hh.swd20.organizer.domain.User;
import hh.swd20.organizer.domain.UserRepository;

@SpringBootApplication
public class OrganizerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OrganizerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner boxDemo(BoxRepository boxRepository, ItemRepository itemRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Test data");
			
			Box box1 = new Box("Talvi", "Janita talvitakkeja", false , "Varasto hylly 1");
			Box box2 = new Box("Kesä", "Janita kesä vaatteet ja kengät", false , "Varasto hylly 1");
			Box box3 = new Box ("Joulu", "Joulukuusen koristeet", false, "Varasto");
			Box box4 = new Box("Joululahjat", "Joululahjat 2020", true, "Piilotettu muiden laatikoiden taakse");
			boxRepository.save(box1);
			boxRepository.save(box2);
			boxRepository.save(box3);
			boxRepository.save(box4);

			Category cate1 = new Category("Kengät", "Korot, juhlakengät");
			Category cate2 = new Category("Kesä", "Kesä takkeja");
			Category cate3 = new Category("Talvi", "Talvivaatteita");
			Category cate4 = new Category("Joulu", "Joulu koristeet");
			Category cate5 = new Category("Joululahjat", "Joululahjat 2020");
			categoryRepository.save(cate3);
			categoryRepository.save(cate1);
			categoryRepository.save(cate2);
			categoryRepository.save(cate4);
			categoryRepository.save(cate5);
			

			Item item1 = new Item("Nahkatakki", "Janita", false, box2, cate2);
			Item item2 = new Item("Tekoturkkis", "Janita", false, box1, cate3);
			Item item3 = new Item("Pitkä musta takki", "Janita", false, box1,cate3);
			Item item4 = new Item("Hopeat pallot", "Janita", false, box3, cate4);
			Item item5 = new Item("Mustat korot", "Janita", true, box2, cate1);
			Item item6 = new Item("Kultaiset pallot", "Janita", false, box3, cate4);
			Item item7 = new Item("Mini Kahvinkeitin", "Janita", false, box4, cate5);
			Item item8 = new Item("7x Pyjama", "Janita", false, box4 ,cate5);
			Item item9 = new Item("Mini vedenkeitin", "Janita", false, box4, cate5);
			Item item10 = new Item("Juhlakengät", "Jussi", true, box2, cate1);
			itemRepository.save(item1);
			itemRepository.save(item2);
			itemRepository.save(item3);
			itemRepository.save(item4);
			itemRepository.save(item5);
			itemRepository.save(item6);
			itemRepository.save(item7);
			itemRepository.save(item8);
			itemRepository.save(item9);
			itemRepository.save(item10);
			
			
			User user1 = new User("Janita", "Toivola", "Nainen", "HattiVatti", "$2b$10$I19tmTMN1rFq4.guoJc1heLtSyyFXdgvoklEUVhg9JQkcPSrztUxG", "hatti.vatti@gmail.com", "USER"); //hatti
			User user2 = new User("Aatu", "Aatunen", "Mies", "Admin", "$2b$10$laoLfIwAJ4Zf.uuwK0DrgO1GR0tv3nXG4/N/vb6Z/RFClbjZ0Qiqe", "admin.admin@gmail,com", "ADMIN"); //matti
			userRepository.save(user1);
			userRepository.save(user2);
			
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
			
			log.info("Fetch users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
		};
		
	}
}
