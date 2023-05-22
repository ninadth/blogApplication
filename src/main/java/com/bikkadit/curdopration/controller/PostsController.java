package com.bikkadit.curdopration.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bikkadit.curdopration.helper.AppConstant;
import com.bikkadit.curdopration.payload.PostResponse;
import com.bikkadit.curdopration.payload.PostsDto;
import com.bikkadit.curdopration.service.FileService;
import com.bikkadit.curdopration.service.PostsService;



@RestController
@RequestMapping("/api")
public class PostsController {

	Logger logger=LoggerFactory.getLogger(PostsController.class);
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	/**
	 * @author Ninad
	 * @apiNote This API is used to create Posts
	 * @param postdto
	 * @param userId
	 * @param categoryId
	 * @return
	 */
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostsDto> createPost(@RequestBody PostsDto postdto,@PathVariable Long userId,@PathVariable Long categoryId)
	{
		logger.info("Initiated request for create Posts Details");
		PostsDto createPost = this.postsService.createPost(postdto, categoryId, userId);
		logger.info("completed request for create Post details");
		return new ResponseEntity<PostsDto>(createPost,HttpStatus.CREATED);
		
	}
	/**
	 * @apiNote This API is used for get posts by using categoryId 
	 * @param categoryId
	 * @return
	 */
	//get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostsDto>> getPostByCategory(@PathVariable Long categoryId)
	{
		logger.info("Initiated request for create Posts Details by category");
		List<PostsDto> category = this.postsService.getPostsByCategory(categoryId);
		logger.info("Completed request for Getting all posts by category");
		return new ResponseEntity<List<PostsDto>>(category,HttpStatus.OK);
		
	}
	/**
	 * @apiNote This API is used for posts by using userId
	 * @param userId
	 * @return
	 */
	//get by user
	@GetMapping("/user/userId/posts")
	public ResponseEntity<List<PostsDto>> getPostByUser(@PathVariable Long userId)
	{
		logger.info("Initiated request for Getting all posts by user");
		List<PostsDto> category = this.postsService.getPostsByCategory(userId);
		logger.info("Completed request for Getting all posts by user");
		return new ResponseEntity<List<PostsDto>>(category,HttpStatus.OK);
		
	}
	/**
	 * @apiNote This API is used for get single posts
	 * @param postId
	 * @return
	 */
	//get single post
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostsDto> getPost(@PathVariable Long postId)
	{
		logger.info("Initiated request for Getting single posts with postId:{}",postId);
		PostsDto post = this.postsService.getPost(postId);
		logger.info("Completed request for posts details with postId:{}",postId);
		
		return new ResponseEntity<PostsDto>(post,HttpStatus.OK);
	}
	/**
	 * @apiNote This API is used for get all posts
	 * @param pageNumber
	 * @param pageSize
	 * @param sortBy
	 * @return
	 */
	//get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value="pageNumber",defaultValue = AppConstant.PAGE_NUMBER,required = false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue =AppConstant.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value="sort",defaultValue = AppConstant.SORT_BY,required = false)String sortBy)
	{
		logger.info("Initiated request for Getting all posts");
		PostResponse allPost = this.postsService.getAllPost(pageNumber,pageSize,sortBy);
		logger.info("Completed request for Getting all posts");
		return new ResponseEntity<PostResponse>(allPost,HttpStatus.OK);
		
	}
	/**
	 * @apiNote This API is used for update posts
	 * @param postdto
	 * @param postId
	 * @return
	 */
	//update post
	@PutMapping("/{postId}")
	public ResponseEntity<PostsDto> updatePosts(@RequestBody PostsDto postdto,@PathVariable Long postId)
	{
		logger.info("Initiated request for Update the User details with postId:{}",postId);
		PostsDto updatePost = this.postsService.updatePost(postdto, postId);
		logger.info("Completed request for user details with postId:{}",postId);
		return new ResponseEntity<PostsDto>(updatePost,HttpStatus.OK);
		
	}
	/**
	 * @apiNote This API is used for delete posts
	 * @param postId
	 * @return
	 */
	//delete post
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable Long postId)
	{
		logger.info("Initiated request for delete a user");
		this.postsService.deletePost(postId);
		logger.info("Completed request for delete a user");
		return new ResponseEntity<String>("delete post successfully",HttpStatus.OK);
	}
	/**
	 * @apiNote This API is used to search posts by using keyword
	 * @param keyword
	 * @return
	 */
	
	@GetMapping("posts/search/{keyword}")
	public ResponseEntity<List<PostsDto>> searchPosts(@PathVariable String keyword){
		logger.info("Initiated request for search a posts");
		List<PostsDto> searchPosts = this.postsService.searchPosts(keyword);
		logger.info("Completed request for search a posts");
		return new ResponseEntity<List<PostsDto>> (searchPosts,HttpStatus.OK);
	}

	//post image uploded
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostsDto> uploadPostImage(@RequestParam ("image") MultipartFile image,
			@PathVariable Long postId) throws IOException{
		
		String image2 = this.fileService.uploadImage(path, image);
		PostsDto postdto=this.postsService.getPost(postId);
		postdto.setImageName(image2);
		PostsDto updatePost = this.postsService.updatePost(postdto, postId);
		
		return new ResponseEntity<PostsDto>(updatePost,HttpStatus.OK);
	}
	
	@GetMapping(value="/post/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("images") String imageName,HttpServletResponse response) throws IOException {
		
		InputStream resources = this.fileService.getResources(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resources,response.getOutputStream());
	}
	
	
}
