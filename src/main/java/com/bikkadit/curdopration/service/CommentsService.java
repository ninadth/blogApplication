package com.bikkadit.curdopration.service;

import com.bikkadit.curdopration.payload.CommentsDto;

public interface CommentsService {

	public CommentsDto createComments(CommentsDto commentsdto,Long postId);
	
	public void deleteComments(Long commentsId);
}
