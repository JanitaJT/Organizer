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
import hh.swd20.organizer.domain.Category;
import hh.swd20.organizer.domain.CategoryRepository;
import hh.swd20.organizer.domain.Item;
import hh.swd20.organizer.domain.ItemRepository;

@CrossOrigin
@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	BoxRepository boxRepository;

	@Autowired
	CategoryRepository categoryRepository;

	// Haetaan boxid:llä siihen kuuluvat esineet home-sivulle

	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public String findItemsHome(@PathVariable("id") Long boxId, Model model) {
		Box box = boxRepository.findById(boxId).get();
		List<Item> items = box.getItems();
		System.out.println(items);
		model.addAttribute("items", items);
		return "items";
	}

	// HasAnyAuthority jotta vain autentikoituneet käyttäjät voivat lisätä/muokata
	// ja poistaa esineitä
	// Käytetty /auth/* endpointtia, näihin pääsee vain autentikoitunut käyttäjä

	// Tyhjä itemilomake

	@RequestMapping(value = "/auth/additem/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String addItem(@PathVariable("id") Long boxId, Model model) { // Koska esineet ovat laatikon sisällä,
		Box box = boxRepository.findById(boxId).get();					//  pitää etsiä boxId:llä	
		Item item = new Item();
		item.setBox(box);
		model.addAttribute("item", item);
		model.addAttribute("categories", categoryRepository.findAll());	// Kategoriat ovat yhteydessä esineeseen
		return "additem";

	}

	// Tallennetaan uusi itemi

	@RequestMapping(value = "/saveitem", method = RequestMethod.POST)
	public String saveItem(@Valid @ModelAttribute Item item, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {	// Jos tulee virheitä
			model.addAttribute("item", item);
			model.addAttribute("categories", categoryRepository.findAll());
			return "additem";
		} else {		// Jos kaikki menee oikein
			itemRepository.save(item);
			model.addAttribute("item", item);
			model.addAttribute("categories", categoryRepository.findAll());
			return "redirect:/auth/itemit";
		}
	}

	// Listaa esineet itemslogged-sivulle

	@RequestMapping(value = "/auth/itemit", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String itemPageLogged(Model model) {
		List<Item> itemit = (List<Item>) itemRepository.findAll();
		model.addAttribute("itemit", itemit);
		return "itemslogged";
	}

	// Haetaan boxid:llä siihen kuuluvat esineet logged-sivulle

	@RequestMapping(value = "/auth/itemit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String findItemsLogged(@PathVariable("id") Long boxId, Model model) {
		Box box = boxRepository.findById(boxId).get();
		List<Item> itemit = box.getItems();
		System.out.println(itemit);
		model.addAttribute("itemit", itemit);
		return "itemslogged";
	}

	// Itemin editointi

	@RequestMapping(value = "/auth/edititem/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String editItem(@PathVariable("id") Long itemId, Model model) {
		Item item = itemRepository.findById(itemId).get();
		model.addAttribute("item", item);
		model.addAttribute("categories", categoryRepository.findAll());
		return "edititem";
	}

	// Itemin poisto

	@RequestMapping(value = "/auth/deleteitem/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String deleteItem(@PathVariable("id") Long itemId, Model model) {
		itemRepository.deleteById(itemId);
		return "redirect:/auth/itemit";
	}

}
