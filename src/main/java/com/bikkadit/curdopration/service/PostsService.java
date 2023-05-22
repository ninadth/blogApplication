package com.bikkadit.curdopration.service;

import java.util.List;

import com.bikkadit.curdopration.payload.PostResponse;
import com.bikkadit.curdopration.payload.PostsDto;

public interface PostsService {

	//create
	public PostsDto createPost(PostsDto postdto,Long categoryId,Long userId);
	
	//update
	public PostsDto updatePost(PostsDto postdto,Long postId);
	
	//delete
	public void deletePost(Long postId);
	
	//get
	public PostsDto getPost(Long postId);
	
	//getAll
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
	
	//get list of post by category
	public List<PostsDto> getPostsByCategory(Long categoryId);
	
	//get list of post by user
	public List<PostsDto> getPostsByUser(Long userId);
	
	//search posts 
	public List<PostsDto> searchPosts(String keyword); 
}
