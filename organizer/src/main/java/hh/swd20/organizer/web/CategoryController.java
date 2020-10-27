package hh.swd20.organizer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/cates", method = RequestMethod.GET)
	public String catePage(Model model) {
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "cates";
	}
}
