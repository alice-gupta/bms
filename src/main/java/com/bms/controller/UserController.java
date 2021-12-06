package com.bms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.dao.UserRepo;
import com.bms.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String dashboard(User user) {

		System.out.println(user);

		// get the user from userName(Email)

		// User user = userRepo.getUserByName(userName);
		// System.out.println(userName);
		// model.addAttribute("user", user);

		return "normal/user_dashboard";

	}

}
