package hh.swd20.organizer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;
import hh.swd20.organizer.domain.CategoryRepository;
import hh.swd20.organizer.domain.ItemRepository;

@CrossOrigin
@Controller
public class BoxController {

	@Autowired
	BoxRepository boxRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository cateRepository;

	// Haetaan kaikki laatikot home-sivulle
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<Box> boxes = (List<Box>) boxRepository.findAll();
		model.addAttribute("boxes", boxes);
		return "home";

	}

	// Haetaan kaikki laatikot logged-sivulle
	@RequestMapping(value = "/logged", method = RequestMethod.GET)
	public String loggedPage(Model model) {
		List<Box> boxes2 = (List<Box>) boxRepository.findAll();
		model.addAttribute("boxes2", boxes2);
		return "logged";

	}

	// Muodostetaan tyhjä boxlomake

	@RequestMapping(value = "/addbox", method = RequestMethod.GET)
//	@PreAuthorize("hasRole('USER')")
	public String addBox(Model model) {
		model.addAttribute("box", new Box());
		return "addbox";

	}
	
	// Tallennetaan uusi laatikko
	@RequestMapping(value= "/savebox", method = RequestMethod.POST)
//	@PreAuthorize("hasRole('USER')")
	public String saveBox(@ModelAttribute Box box) {
		boxRepository.save(box);
		return "redirect:/logged";
	}
	
//	//Boxin poisto
	@RequestMapping(value="/deletebox/{id}", method = RequestMethod.GET)
	public String deleteBox(@PathVariable("id") Long boxId, Model model) {
		boxRepository.deleteById(boxId);
		return "redirect:../logged";
	}
	
	@RequestMapping(value= "/editbox/{id}", method = RequestMethod.GET)
	public String editBox(@PathVariable("id") Long boxId, Model model) {
		Box box = boxRepository.findById(boxId).get();
		model.addAttribute("box", box);
		return "edit";
	}

}
