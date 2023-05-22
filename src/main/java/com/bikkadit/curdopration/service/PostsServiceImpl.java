package com.bikkadit.curdopration.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bikkadit.curdopration.dao.CategoryRepository;
import com.bikkadit.curdopration.dao.PostsRepository;
import com.bikkadit.curdopration.dao.UserRepository;
import com.bikkadit.curdopration.exceptionhandling.CategoryNotFoundException;
import com.bikkadit.curdopration.exceptionhandling.PostNotFoundException;
import com.bikkadit.curdopration.exceptionhandling.UserNotFoundException;
import com.bikkadit.curdopration.model.Category;
import com.bikkadit.curdopration.model.Posts;
import com.bikkadit.curdopration.model.User;
import com.bikkadit.curdopration.payload.PostResponse;
import com.bikkadit.curdopration.payload.PostsDto;

@Service
public class PostsServiceImpl implements PostsService {

	@Autowired
	private PostsRepository postsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	
	@Override
	public PostsDto createPost(PostsDto postdto, Long categoryId, Long userId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category","categoryId", categoryId));
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User","userId", userId));
		
		Posts map = this.mapper.map(postdto,Posts.class);
		map.setImageName("default.png");
		map.setAddDate(new Date());
		map.setCategory(category);
		map.setUser(user);
		
		Posts posts = this.postsRepo.save(map);
		
		return this.mapper.map(posts,PostsDto.class);
	}

	@Override
	public PostsDto updatePost(PostsDto postdto, Long postId) {
		// TODO Auto-generated method stub
		Posts post = this.postsRepo.findById(postId).orElseThrow(()->new PostNotFoundException("Posts","postId", postId));
		post.setTital(postdto.getTital());
		post.setContent(postdto.getContent());
		post.setImageName(postdto.getImageName());
		
		Posts posts = this.postsRepo.save(post);
		
		return this.mapper.map(posts,PostsDto.class);
	}

	@Override
	public void deletePost(Long postId) {
		// TODO Auto-generated method stub
	 Posts post = this.postsRepo.findById(postId).orElseThrow(()->new PostNotFoundException("Posts","postId", postId));
	 this.postsRepo.delete(post);
	}

	@Override
	public PostsDto getPost(Long postId) {
		// TODO Auto-generated method stub
		Posts post = this.postsRepo.findById(postId).orElseThrow(()->new PostNotFoundException("Posts", "postId", postId));
		return this.mapper.map(post,PostsDto.class);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy) {
		// TODO Auto-generated method stub
		//int pageSize=5;
		//int pageNumber=1;
		
		Pageable p= PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).ascending());
		
         Page<Posts> pagePost = this.postsRepo.findAll(p);
         List<Posts> allPosts = pagePost.getContent();
		
		List<PostsDto> collect = allPosts.stream().map((post)->this.mapper.map(post,PostsDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		
		postResponse.setContent(collect);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPage(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public List<PostsDto> getPostsByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category", "categoryId", categoryId));
		
		     List<Posts> category2 = this.postsRepo.findByCategory(category);
		     
		     List<PostsDto> collect = category2.stream().map((posts)->this.mapper.map(posts,PostsDto.class)).collect(Collectors.toList());
		     
		return collect;
	}

	@Override
	public List<PostsDto> getPostsByUser(Long userId) {
		// TODO Auto-generated method stub
		  User user = this.userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User", "userId", userId));
		
	 List<Posts> user2 = this.postsRepo.findByUser(user);
	     
	     List<PostsDto> collect = user2.stream().map((posts)->this.mapper.map(posts,PostsDto.class)).collect(Collectors.toList());
	     
	return collect;
	}

	@Override
	public List<PostsDto> searchPosts(String keyword) {
		List<Posts> findByTitalContaning = this.postsRepo.searchByTitl("%"+keyword+"%");
		List<PostsDto> collect = findByTitalContaning.stream().map((posts)->this.mapper.map(posts,PostsDto.class)).collect(Collectors.toList());
		
		return collect;
	}

}
