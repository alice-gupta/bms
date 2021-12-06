package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.dao.UserRepo;
import com.bms.entities.User;
import com.bms.entities.UserDetail;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-Bookstore Management System");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Signup-Bookstore Management System");
		model.addAttribute("user", new User());
		return "signup";
	}

	// handler for custom login
	@GetMapping("/login")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login page");
		return "login";
	}

	// handler for registering user
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(User user, Model model) {
		System.out.println(user);

		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User result = this.userRepo.save(user);
		model.addAttribute("user", result);

		model.addAttribute("message", "Something went wrong!!");

		return "signup";

	}
}
