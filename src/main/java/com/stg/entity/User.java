package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(length = 20)
	@NotBlank(message = "Enter username")
	private String userName;

	@Size(min = 5, max = 20, message = "length of the password must be between 5 and 20")
	@NotEmpty(message = "Enter password")
	private String password;

	@Email(message = "Enter valid Email")
	private String email;

	@Min(value = 18)
	private int age;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String profilePic;

	public enum GenderType {
		MALE, FEMALE
	}

	@Column
	private GenderType gender;

	@JsonManagedReference(value = "userLike")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Likes> likes;

	@JsonManagedReference(value = "userComment")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Comment> comments;

	@JsonManagedReference(value = "userPost")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Post> posts;

	public User() {
		super();
	}

	public User(int userId, @NotBlank(message = "Enter username") String userName,
			@Size(min = 5, max = 20, message = "length of the password must be between 5 and 20") @NotEmpty(message = "Enter password") String password,
			@Email(message = "Enter valid Email") String email, @Min(18) int age, String profilePic,
			GenderType gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
		this.profilePic = profilePic;
		this.gender = gender;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}
	
	

}
