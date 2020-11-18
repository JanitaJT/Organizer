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
	// On eri koska kaikki laatikot eivät näy, ellei ole kirjautunut

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<Box> boxes = (List<Box>) boxRepository.findAll();
		model.addAttribute("boxes", boxes);
		return "home";

	}

	// HasAnyAuthority jotta vain autentikoituneet käyttäjät voivat lisätä/muokata ja poistaa laatikoita
	// Käytetty /auth/* endpointtia, näihin pääsee vain autentikoitunut käyttäjä
	
	// Haetaan kaikki laatikot logged-sivulle

	@RequestMapping(value = "/auth/logged", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String loggedPage(Model model) {
		List<Box> boxes2 = (List<Box>) boxRepository.findAll();
		model.addAttribute("boxes2", boxes2);
		return "logged";

	}

	// Muodostetaan tyhjä laatikkolomake

	@RequestMapping(value = "/auth/addbox", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String addBox(Model model) {
		model.addAttribute("box", new Box());
		return "addbox";

	}

	// Tallennetaan uusi laatikko

	@RequestMapping(value = "/savebox", method = RequestMethod.POST)
	public String saveBox(@Valid @ModelAttribute Box box, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) { // Jos tulee virheitä
			return "addbox";
		} else { // Jos kaikki menee oikein
			boxRepository.save(box);
			model.addAttribute("box", box);
			return "redirect:/auth/logged";
		}
	}

// Laatikon poisto

	@RequestMapping(value = "/auth/deletebox/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String deleteBox(@PathVariable("id") Long boxId, Model model) {
		boxRepository.deleteById(boxId);
		return "redirect:../logged";
	}

	// Laatikon muokkaus
	
	@RequestMapping(value = "/auth/editbox/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String editBox(@PathVariable("id") Long boxId, Model model) {
		Box box = boxRepository.findById(boxId).get();
		model.addAttribute("box", box);
		return "edit";
		}
	
	@RequestMapping(value = "/saveeditbox", method = RequestMethod.POST)
	public String saveEditedBox(@Valid @ModelAttribute Box box, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) { // Jos tulee virheitä
			return "edit";
		} else { // Jos kaikki menee oikein
			boxRepository.save(box);
			model.addAttribute("box", box);
			return "redirect:/auth/logged";
		}
	}

}
