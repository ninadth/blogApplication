package com.bikkadit.curdopration.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CATEGORY")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long categoryId;
	
	@Column(name="TITAL")
	public String categoryTital;
	
	@Column(name="DESCRIPTION")
	public String categoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Posts> posts=new ArrayList<>();

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

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public Category(Long categoryId, String categoryTital, String categoryDescription, List<Posts> posts) {
		super();
		this.categoryId = categoryId;
		this.categoryTital = categoryTital;
		this.categoryDescription = categoryDescription;
		this.posts = posts;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTital=" + categoryTital + ", categoryDescription="
				+ categoryDescription + ", posts=" + posts + "]";
	}
	
	
}
