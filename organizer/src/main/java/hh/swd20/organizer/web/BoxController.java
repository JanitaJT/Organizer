package hh.swd20.organizer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.organizer.domain.Box;
import hh.swd20.organizer.domain.BoxRepository;

@CrossOrigin
@Controller
public class BoxController {

	@Autowired
	BoxRepository boxRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loginPage(Model model) {
		List<Box> boxes = (List<Box>) boxRepository.findAll();
		model.addAttribute("boxes", boxes);
		return "home";

	}

}
