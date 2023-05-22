package com.bikkadit.curdopration.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    public Long categoryId;
    @NotBlank
    @Size(min=4,message="minimum 4 word are allow")
	public String categoryTital;
    
    @NotBlank
    @Size(min=10,message="minimum 10 word are allow")
	public String categoryDescription;
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTital() {
		return categoryTital;
	}
	public void setCategoryTital(String categoryTital) {
		this.categoryTital = categoryTital;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public CategoryDto(Long categoryId, String categoryTital, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTital = categoryTital;
		this.categoryDescription = categoryDescription;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryTital=" + categoryTital + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
	
}
