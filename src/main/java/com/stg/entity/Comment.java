package com.stg.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@Column(length = 50)
	private String content;
	
	@Column
	private String imageUrl;

	@Column(nullable = false)
	private String commentedBy;

	// @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = Shape.STRING)
	@Column
	private LocalDateTime commentedAt;
	
	@JsonManagedReference(value = "commentLike")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comment")
	private List<Likes> likes;

	@JoinColumn(name = "post_id", nullable = false, referencedColumnName = "postId")
	@JsonBackReference(value = "postComment")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Post post;

	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userId")
	@JsonBackReference(value = "userComment")
	@ManyToOne(cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
	private User user;

	public Comment() {
		super();
	}

	public Comment(int commentId, String content, String imageUrl, String commentedBy, LocalDateTime commentedAt) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.imageUrl = imageUrl;
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

	public LocalDateTime getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
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
