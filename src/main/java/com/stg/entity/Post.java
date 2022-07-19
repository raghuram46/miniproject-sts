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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@NotEmpty(message = "Enter description")
	@Column(length = 100)
	private String description;
	
	@Column
	private String imageUrl;

	private String postedBy;

	// @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = Shape.STRING)
	@Column
	private LocalDateTime postedAt;

	@JsonManagedReference(value = "postComment")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	private List<Comment> comments;

	@JsonManagedReference(value = "postLike")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	private List<Likes> likes;

	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userId")
	@JsonBackReference(value = "userPost")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private User user;

	public Post() {
		super();
	}


	public Post(int postId, @NotEmpty(message = "Enter description") String description, String imageUrl,
			String postedBy, LocalDateTime postedAt) {
		super();
		this.postId = postId;
		this.description = description;
		this.imageUrl = imageUrl;
		this.postedBy = postedBy;
		this.postedAt = postedAt;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public LocalDateTime getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
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

	

}
