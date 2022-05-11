package com.stg.entity;

import java.util.Date;
import java.util.List;

public class Post {
	private int postId;
	private String description;
	private String postedBy;
	private Date postedAt;
	private List<Comment> comments;

	public Post() {
		super();
	}

	public Post(int postId, String description, String postedBy, Date postedAt) {
		super();
		this.postId = postId;
		this.description = description;
		this.postedBy = postedBy;
		this.postedAt = postedAt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

}
