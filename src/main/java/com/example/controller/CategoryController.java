package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryController 
{

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categorys")
	public List<Category> getAllCategorys()
	{
		return categoryService.getAllCategorys();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable(name = "id") int id)
	{
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/addnewCategory")
	public Category addnewCategory(@RequestBody Category category)
	{
		return categoryService.addnewCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable(name = "id") int id,@RequestBody Category category)
	{
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable(name = "id") int id)
	{
		return categoryService.deleteCategory(id);
	}
	
}
