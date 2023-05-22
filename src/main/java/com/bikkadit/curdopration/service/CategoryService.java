package com.bikkadit.curdopration.service;

import java.util.List;

import com.bikkadit.curdopration.model.Category;
import com.bikkadit.curdopration.payload.CategoryDto;

public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto categorydto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categorydto, Long categoryId);
	
	//delete
	public void deleteCategory(Long categoryId);
	
	//get
	public CategoryDto getCategory(Long categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategory();
}
