package com.stg.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Post;
import com.stg.service.PostService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Post createPost(@Valid @RequestBody Post post) {
		return postService.createPost(post);
	}

	@GetMapping(value = "/getbyid/{postId}")
	public Post readPostById(@PathVariable int postId) {

		return postService.readPostByPostId(postId);
	}

	@GetMapping(value = "/getbydate")
	public Post readPostByDate(@DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam LocalDateTime postedAt) {

		return postService.readPostByPostedTime(postedAt);
	}

	@GetMapping(value = "/getAllPosts")
	public List<Post> readAllPosts() {

		return postService.getAllPosts();
	}

	@PutMapping(value = "/update/{postId}/{description}")
	public Post updateDescription(@PathVariable int postId, @PathVariable String description) {

		return postService.updateDescriptionById(postId, description);
	}

	@DeleteMapping(value = "/deletebyId/{postId}")
	public List<Post> deletePost(@PathVariable int postId) {

		return postService.deletePostById(postId);
	}

	@DeleteMapping(value = "/deletebydate")
	public List<Post> deletePost(@DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam LocalDateTime postedAt) {

		return postService.deletePostByDate(postedAt);
	}

}
