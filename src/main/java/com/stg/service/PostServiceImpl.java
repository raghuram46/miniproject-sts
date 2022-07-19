package com.stg.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Post;
import com.stg.exception.CustomException;
import com.stg.repository.PostRepo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;

	@Override
	public Post createPost(Post post) throws CustomException {
		Optional<Post> optional = postRepo.findById(post.getPostId());

		if (optional.isPresent()) {
			throw new CustomException("Post already exists with the given postId");
		}

		LocalDateTime datetime1 = LocalDateTime.now();
		post.setPostedAt(datetime1);

		return postRepo.save(post);
	}

	@Override
	public Post readPostByPostId(int postId) throws CustomException {
		Optional<Post> optional = postRepo.findById(postId);
		System.out.println(optional.get().getPostedAt());

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No post with the given postId");
		}

	}

	@Override
	public Post readPostByPostedTime(LocalDateTime postedAt) throws CustomException {
		Optional<Post> optional = postRepo.findByPostedAt(postedAt);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No post at the given post time");
		}

	}

	@Override
	public List<Post> getAllPosts() throws CustomException {

		return postRepo.findAll();
	}

	@Override
	public Post updateDescriptionById(int postId, String newDescription) throws CustomException {
		Post tempPost = null;
		Optional<Post> optional = postRepo.findById(postId);

		if (optional.isPresent()) {
			tempPost = optional.get();
			tempPost.setDescription(newDescription);
		} else {
			throw new CustomException("Enter Valid PostId to update");
		}

		return postRepo.save(tempPost);
	}

	@Override
	public List<Post> deletePostById(int postId) throws CustomException {
		Optional<Post> optional = postRepo.findById(postId);

		if (optional.isPresent()) {
			postRepo.deleteById(postId);
		} else {
			throw new CustomException("Enter Valid PostId to delete");
		}

		return postRepo.findAll();
	}

	@Override
	public List<Post> deletePostByDate(LocalDateTime postedAt) throws CustomException {
		Optional<Post> optional = postRepo.findByPostedAt(postedAt);

		if (optional.isPresent()) {
			postRepo.delete(optional.get());
		} else {
			throw new CustomException("Enter Valid posted time to delete");
		}

		return postRepo.findAll();
	}

}
