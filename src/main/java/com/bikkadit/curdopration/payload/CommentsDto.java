package com.bikkadit.curdopration.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentsDto {

	private Long commentId;
	
	private String content;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentsDto(Long commentId, String content) {
		super();
		this.commentId = commentId;
		this.content = content;
	}

	public CommentsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommentsDto [commentId=" + commentId + ", content=" + content + "]";
	}
	
	
}
