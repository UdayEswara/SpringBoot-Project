package com.spark.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Category;
import com.spark.lms.service.CategoryService;
import com.spark.lms.service.IssueService;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.getAllBySort();
	}
	
	@GetMapping({"/", "/list"})
	public String listIssuePage(Model model) {
		model.addAttribute("issues", issueService.getAllUnreturned());
		return "/issue/list";
	}
	
	@GetMapping("/new")
	public String newIssuePage(Model model) { 
		return "/issue/form";
	}
	
}
