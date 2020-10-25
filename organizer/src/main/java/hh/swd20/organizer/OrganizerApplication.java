package hh.swd20.organizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;

@SpringBootApplication
public class OrganizerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OrganizerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner boxDemo(BoxRepository boxRepository) {
		return (args) -> {
			log.info("Test data");
			
			Box box1 = new Box("Talvi", "Janita talvitakkeja", true , "Varasto hylly 1");
			Box box2 = new Box("Kesä", "Janita kesätakkeja", false , "Varasto hylly 1");
			boxRepository.save(box1);
			boxRepository.save(box2);
			
			log.info("Fetch boxes");
			for(Box box : boxRepository.findAll()) {
				log.info(box.toString());
			}
		};
		
	}
}
