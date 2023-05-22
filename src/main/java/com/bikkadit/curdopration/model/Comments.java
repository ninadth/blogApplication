package com.bikkadit.curdopration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="COMMENTS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
	private String content;
	
	@ManyToOne
	private Posts post;

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

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	public Comments(Long commentId, String content, Posts post) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.post = post;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", content=" + content + ", post=" + post + "]";
	}
	
	
}
