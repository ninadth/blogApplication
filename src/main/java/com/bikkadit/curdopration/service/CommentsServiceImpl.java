package com.bikkadit.curdopration.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.curdopration.dao.CommentsRepository;
import com.bikkadit.curdopration.dao.PostsRepository;
import com.bikkadit.curdopration.exceptionhandling.PostNotFoundException;
import com.bikkadit.curdopration.model.Comments;
import com.bikkadit.curdopration.model.Posts;
import com.bikkadit.curdopration.payload.CommentsDto;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private PostsRepository postsRepo;
	
	@Autowired
	private CommentsRepository commentsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public CommentsDto createComments(CommentsDto commentsdto,Long postId) {
		// TODO Auto-generated method stub
		Posts posts = this.postsRepo.findById(postId).orElseThrow(()->new PostNotFoundException("Posts", "postId", postId));
		Comments comments = this.mapper.map(commentsdto, Comments.class);
		comments.setPost(posts);
		Comments saveComments = this.commentsRepo.save(comments);
		
		return this.mapper.map(saveComments,CommentsDto.class);
	}

	@Override
	public void deleteComments(Long commentsId) {
		// TODO Auto-generated method stub
  Comments comments = this.commentsRepo.findById(commentsId).orElseThrow(()->new PostNotFoundException("Comments","commentsId", commentsId));
  this.commentsRepo.delete(comments);
	}

}
