package com.stg.entity;

import java.util.Date;

public class Comment {
	private int commentId;
	private String content;
	private String commentedBy;
	private Date commentedAt;

	public Comment() {
		super();
	}

	public Comment(int commentId, String content, String commentedBy, Date commentedAt) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.commentedBy = commentedBy;
		this.commentedAt = commentedAt;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Date getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
	}

}
