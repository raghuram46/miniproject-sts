package com.stg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Likes;
import com.stg.service.LikesService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "likes")
public class LikesController {
	@Autowired
	private LikesService likesService;
	
	@PostMapping(value = "/create")
	public Likes createLike(@Valid @RequestBody Likes likes) {

		return likesService.createLike(likes);
	}

	@GetMapping(value = "/read/{likeId}")
	public Likes readLikeById(@PathVariable int likeId) {

		return likesService.readLikesByLikeId(likeId);
	}
	

	@GetMapping(value = "/getAllLikes")
	public List<Likes> readAllLikes() {

		return likesService.getAllLikes();
	}

	@DeleteMapping(value = "/delete/{likeId}")
	public List<Likes> deleteLikesById(@PathVariable int likeId) {

		return likesService.deleteLikesById(likeId);
	}

}
