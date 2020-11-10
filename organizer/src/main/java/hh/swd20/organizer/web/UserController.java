package hh.swd20.organizer.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.swd20.organizer.domain.SignUpForm;
import hh.swd20.organizer.domain.User;
import hh.swd20.organizer.domain.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignUpForm());
		return "signup";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String homePage() {
		return "login";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("signupform") SignUpForm signupform, BindingResult bindingResult) {
//		System.out.println(signUpForm);
		if (!bindingResult.hasErrors()) {
			if (signupform.getPassword().equals(signupform.getPasswordCheck())) {
				String pwd = signupform.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hasPwd = bc.encode(pwd);

				User newUser = new User();
				newUser.setuFirstname(signupform.getFirstname());
				newUser.setuLastname(signupform.getLastname());
				newUser.setGender(signupform.getGender());
				newUser.setUserPassword(hasPwd);
				newUser.setUserName(signupform.getUsername());
				newUser.setuEmail(signupform.getEmail());
				newUser.setRole("USER");

				System.out.println("UUSI KÄYTTÄJÄ: " + newUser);

				if (userRepository.findByuserName(signupform.getUsername()) == null) {
					userRepository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Käyttäjä nimi on jo olemassa");
					return "signup";
				}

			} else {
				bindingResult.rejectValue("passwordCheck", "err.passwordCheck", "Salsana ei täsmännyt");
				return "signup";
			}

		} else {
			return "signup";
		}
		return "redirect:/login";
	}
}
