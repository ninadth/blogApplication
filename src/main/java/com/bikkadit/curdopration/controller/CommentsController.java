package com.bikkadit.curdopration.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.curdopration.payload.CommentsDto;
import com.bikkadit.curdopration.service.CommentsService;

@RestController
@RequestMapping("/api")
public class CommentsController {

	Logger logger=LoggerFactory.getLogger(CommentsController.class);
	
	@Autowired
	private CommentsService commentsService;
	
	/**
	 * @author Ninad
	 * @apiNote This API is used for creating a comments
	 * @param commentsdto
	 * @param postId
	 * @return
	 */
	@PostMapping("/comments/{postId}")
	public ResponseEntity<CommentsDto> createComments(@RequestBody CommentsDto commentsdto,
			@PathVariable Long postId){
		logger.info("Initiated request for create comments details");
		CommentsDto createComments = this.commentsService.createComments(commentsdto, postId);
		logger.info("Completed request for create comments details");
		return new ResponseEntity<CommentsDto>(createComments,HttpStatus.CREATED);
	}
	/**
	 * @apiNote This API is used for delete a comments
	 * @param commentsId
	 * @return
	 */
	@DeleteMapping("/{commentsId}")
	public ResponseEntity<String> deleteComments(@PathVariable Long commentsId) {
		logger.info("Initiated request for delete comments details");
		this.commentsService.deleteComments(commentsId);
		logger.info("Completed request for delete comments details");
		return new ResponseEntity<String>("Comments delete Successfully",HttpStatus.OK);
	}
	
	
	
	
}
