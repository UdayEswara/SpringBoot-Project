package com.spark.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.spark.lms.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;
	
	@GetMapping({"/", "/home"})
	public String homePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		return "home";
	}	
	
}
