package com.tsmc.template.online.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/reserve")
public class ReserveController {
	
	@RequestMapping("/list")
	public String list(Model model) {
	//	model.addAttribute("copysessionList", copySessionService.findAll());
		return "reserve/list";
	}
	
	
}
