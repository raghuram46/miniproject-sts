package com.stg.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;
	
	@Column
	private String likedBy;

	@Column
	private LocalDateTime likedAt;
	
	@JoinColumn(name = "comment_id", referencedColumnName = "commentId")
	@JsonBackReference(value = "commentLike")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Comment comment;

	@JoinColumn(name = "post_id", referencedColumnName = "postId")
	@JsonBackReference(value = "postLike")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Post post;

	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userId")
	@JsonBackReference(value = "userLike")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private User user;

	public Likes() {
		super();
	}

	public Likes(int likeId, LocalDateTime likedAt, String likedBy) {
		super();
		this.likeId = likeId;
		this.likedAt = likedAt;
		this.likedBy = likedBy;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public LocalDateTime getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}
	

	public String getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
