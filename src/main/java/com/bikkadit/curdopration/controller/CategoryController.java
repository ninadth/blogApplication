package com.bikkadit.curdopration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.curdopration.payload.CategoryDto;
import com.bikkadit.curdopration.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	Logger logger= LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * @author Ninad
	 * @apiNote This API is used for create category
	 * @param categoryDto
	 * @return
	 */
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		logger.info("Initiated request for create Category Details");
		CategoryDto category = this.categoryService.createCategory(categoryDto);
		logger.info("Completed request for create Category Details");
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}
	/**
	 * @apiNote This API is used to update category
	 * @param categorydto
	 * @param categoryId
	 * @return
	 */
		//update
		@PutMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categorydto, @PathVariable Long categoryId )
		{
			logger.info("Initiated request for Update the User details with categoryId:{}",categoryId);
			CategoryDto updateCategory = this.categoryService.updateCategory(categorydto, categoryId);
			logger.info("Completed request for user details with categoryId:{}",categoryId);
			return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
		/**
		 * @apiNote This API is used to delete category
		 * @param catId
		 * @return
		 */
		//delete
		@DeleteMapping("/{catId}")
		public ResponseEntity<String> deleteCategory(@PathVariable Long catId)
		{
			logger.info("Initiated request for delete a Category");
			this.categoryService.deleteCategory(catId);
			logger.info("Completed request for delete a Category");
			return new ResponseEntity<String>("DELETE SUCCESSFULLY",HttpStatus.OK);
		}
		/**
		 * @apiNote This API is used to get single category
		 * @param catId
		 * @return
		 */
		//get
		@GetMapping("/{catId}")
		public ResponseEntity<CategoryDto> getCategory(@PathVariable Long catId)
		{
			logger.info("Initiated request for Getting single user with catId:{}",catId);
			CategoryDto category = this.categoryService.getCategory(catId);
			logger.info("Completed request for Getting single user with catId:{}",catId);
			return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
		}
		/**
		 * @apiNote This API is used to get all category
		 * @return
		 */
		//getAll
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategory()
		{
			logger.info("Initiated request for Getting all Category");
			List<CategoryDto> categorys = this.categoryService.getAllCategory();
			logger.info("Completed request for Getting all Category");
			return new ResponseEntity<List<CategoryDto>>(categorys,HttpStatus.OK);
			
		}
}
