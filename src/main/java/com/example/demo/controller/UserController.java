package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserRepository;
import com.example.demo.entiy.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userdao;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		// modelAndView.addObject("learnList", learnList);
		return modelAndView;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/loginin")
	public Map loginin(User user, HttpSession h) {
		User u = userdao.findByNameAndPassword(user.getUsername(), user.getPassword());
		System.out.println(user.toString());
		Map<String, String> message = new HashMap<String, String>();
		message.put("message", "404");
		if (u == null || !user.getUsername().equals(u.getUsername())) {
			message.put("message", "not found");
		} else {
			h.setAttribute("user", u);
			message.put("message", "ok");
			message.put("username", u.getUsername());
			message.put("nickname", u.getNickname());
			message.put("regtime", u.getRegtime());
		}
		return message;
	}

	@RequestMapping("/user")
	public Map getUser(HttpSession h) {
		Map<String, String> message = new HashMap<String, String>();
		User user = null;
		if (h.getAttribute("user") instanceof User) {
			user = (User) h.getAttribute("user");
			message.put("username", user.getUsername());
			message.put("nickname", user.getNickname());
			message.put("regtime", user.getRegtime());
		} else {
			message.put("message", "null");
		}
		return message;
	}

	@RequestMapping("/loginout")
	public void loginout(HttpSession h) {
		h.removeAttribute("user");
	}

	@PostMapping("/save")
	public String SetSave(User user, HttpSession h) {
		user.setRegtime(new Date().toString());
		userdao.save(user);
		System.out.println(user.toString());
		return "index";
	}

}
