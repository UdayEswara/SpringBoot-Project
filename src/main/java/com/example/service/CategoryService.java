package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.CategoryRepository;
import com.example.exceptions.NotFoundException;
import com.example.model.Category;

@Service
public class CategoryService 
{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategorys()
	{
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(int id)
	{
		Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category id "+id+" does not exist."));
		return category;
	}
	
	public Category addnewCategory(Category category)
	{
		category.setDate(new Date());
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(int id,Category category)
	{
		Category categoryDetails = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category id "+id+" does not exist."));
		
		if(category.getName()!=null)
			categoryDetails.setName(category.getName());
		if(category.getBook()!=null)
			categoryDetails.setBook(category.getBook());
		
		Category updateCategory = categoryRepository.save(categoryDetails);
		
		return updateCategory;
	}
	
	public String deleteCategory(int id)
	{
		Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category id "+id+" does not exist."));
		String categoryName = category.getName();
		categoryRepository.delete(category);
		
		return categoryName+" category is deleted";
	}
	
}
