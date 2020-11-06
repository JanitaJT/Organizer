package hh.swd20.organizer;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.swd20.organizer.web.BoxController;
import hh.swd20.organizer.web.CategoryController;
import hh.swd20.organizer.web.ItemController;
import hh.swd20.organizer.web.UserController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrganizerApplicationTests {
	
	@Autowired
	private BoxController bController;
	
	@Test
	public void contextLoads() {
		assertThat(bController).isNotNull();
		
	}
	
	@Autowired
	private CategoryController cController;
	
	@Test
	public void contextLoads2() {
		assertThat(cController).isNotNull();
		
	}
	
	@Autowired
	private UserController uController;
	
	@Test
	public void contextLoads3() {
		assertThat(uController).isNotNull();
		
	}
	@Autowired
	private ItemController iController;
	
	@Test
	public void contextLoads4() {
		assertThat(iController).isNotNull();
		
	}
	}
