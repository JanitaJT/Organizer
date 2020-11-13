package hh.swd20.organizer.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	// HasAnyAuthority jotta vain autentikoituneet käyttäjät voivat lisätä/muokata ja poistaa kategorioita
	// Vain autentikoituneet käyttäjät pystyvät näkemään kategoria listauksen
	// Käytetty /auth/* endpointtia, näihin pääsee vain autentikoitunut käyttäjä
	
	@RequestMapping(value = "auth/cates", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String catePage(Model model) {
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "cates";
	}
	
	 // Tyhjän kategorialistan muodostaminen
	
	@RequestMapping(value = "auth/addcategory", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String getNewCate(Model model) {
		model.addAttribute("category", new Category());
		return "addcate";
	}
	
	// Lomakkeen tietojen vastaanotto ja tallennus
	
	@RequestMapping(value = "/savecate", method = RequestMethod.POST)
	public String saveCate(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addcate";
		}
		else {
		categoryRepository.save(category);
		model.addAttribute("category", category);
		return "redirect:/auth/cates";
		}
	}
	
	// Kategorian muokkaus
	
	@RequestMapping(value= "/auth/editcate/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String editCate(@PathVariable("id") Long cateId, Model model) {
		Category category = categoryRepository.findById(cateId).get();
		model.addAttribute("category", category);
		return "editcates";
	}
	
}