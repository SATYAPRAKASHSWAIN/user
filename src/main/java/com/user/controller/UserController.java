package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.entity.User;
import com.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getAllUser(Model model) {
		model.addAttribute("listUser", userService.getAllUser());
		return "index";

	}
	@GetMapping("/ShowNewUserForm")
	public String ShowNewUserForm(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "add_user";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	@GetMapping("/ShowNewUserFormForUpdate/{id}")
	public String showfromforUpdate(@PathVariable(value="id")long id,Model model) {
		User user=userService.getUserbyId(id);
		model.addAttribute("user",user);
		return "update_user";
		
	}
	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable(value="id")long id) {
		this.userService.deletUser(id);
		return "redirect:/";
	}

}
