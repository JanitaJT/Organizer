package hh.swd20.organizer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.organizer.domain.Box;
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
	
	 //tyhjän kategorialistan muodostaminen
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String getNewCate(Model model) {
		model.addAttribute("category", new Category());
		return "addcate";
	}
	
	//lomakkeen tietojen vastaanotto ja tallennus
	@RequestMapping(value = "/savecate", method = RequestMethod.POST)
	public String saveCate(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "redirect:/cates";
		
	}
	
	@RequestMapping(value= "/editcate/{id}", method = RequestMethod.GET)
	public String editCate(@PathVariable("id") Long cateId, Model model) {
		Category category = categoryRepository.findById(cateId).get();
		model.addAttribute("category", category);
		return "editcates";
	}
	
}