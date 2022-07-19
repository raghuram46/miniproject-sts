package com.stg.service;

import java.time.LocalDateTime;
import java.util.List;

import com.stg.entity.Post;

public interface PostService {
	public abstract Post createPost(Post post);

	public abstract Post readPostByPostId(int postId);
	
	public abstract Post readPostByPostedTime(LocalDateTime postedAt);
	
	public abstract List<Post> getAllPosts();

	public abstract Post updateDescriptionById(int postId, String newDescription);

	public abstract List<Post> deletePostById(int postId);
	
	public abstract List<Post> deletePostByDate(LocalDateTime postedAt);
}
