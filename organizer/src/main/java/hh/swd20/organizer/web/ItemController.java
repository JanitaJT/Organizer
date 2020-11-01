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
import hh.swd20.organizer.domain.BoxRepository;
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
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String itemPage(Model model) {
		List<Item> items = (List<Item>) itemRepository.findAll();
		model.addAttribute("items", items);
		return "items";
	}
	
	//Haetaan boxId:llä siihen kuuluvat itemit
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public String findItems(@PathVariable("id") Long boxId, Model model) {
		Box box = 	boxRepository.findById(boxId).get();
		List<Item> items = box.getItems();
		System.out.println(items);
		model.addAttribute("items", items);
		return "items";
	}

	
	@RequestMapping(value="/additem/{id}", method = RequestMethod.GET)
	public String addItem(@PathVariable("id") Long boxId, Model model) {
		Box box = 	boxRepository.findById(boxId).get();
		Item item = new Item();
		item.setBox(box);
		model.addAttribute("item", item);
		model.addAttribute("categories", categoryRepository.findAll());
		return "additem";
		
	}
	
	@RequestMapping(value = "/saveitem", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item) {
		
		itemRepository.save(item);
		return "redirect:logged";
	}
}
