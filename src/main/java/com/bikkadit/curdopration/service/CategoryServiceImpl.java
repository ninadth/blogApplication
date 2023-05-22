package com.bikkadit.curdopration.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.curdopration.dao.CategoryRepository;
import com.bikkadit.curdopration.exceptionhandling.CategoryNotFoundException;
import com.bikkadit.curdopration.exceptionhandling.UserNotFoundException;
import com.bikkadit.curdopration.model.Category;
import com.bikkadit.curdopration.payload.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categorydto) {
		// TODO Auto-generated method stub
		Category category = this.mapper.map(categorydto,Category.class);
		Category category2 = this.categoryRepo.save(category);
		return this.mapper.map(category2,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, Long categoryId) {
		Category categoryid = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category","Category Id", categoryId));
		categoryid.setCategoryTital(categorydto.getCategoryTital());
		categoryid.setCategoryDescription(categorydto.getCategoryDescription());
		
		Category category = this.categoryRepo.save(categoryid);
		
		return this.mapper.map(category,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category categoryid = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category","Category Id", categoryId));
		this.categoryRepo.delete(categoryid);
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category categoryid = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category","Category Id", categoryId));
		
		return this.mapper.map(categoryid,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> list = categories.stream().map((cat)->this.mapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return list;
	}

}
