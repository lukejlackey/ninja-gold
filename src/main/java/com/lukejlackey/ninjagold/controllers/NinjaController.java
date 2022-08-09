package com.lukejlackey.ninjagold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukejlackey.ninjagold.models.NinjaModel;

@Controller
public class NinjaController {
	
	@GetMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("ninja") == null) session.setAttribute("ninja", new NinjaModel());
		return "/index.jsp";
	}
	
	@PostMapping("/location")
	public String visitLocation(
			@RequestParam("loc") String loc,
			HttpSession session
			) {
		((NinjaModel) session.getAttribute("ninja")).addEvent(loc);
		return "redirect:/";
	}
	
	
}
