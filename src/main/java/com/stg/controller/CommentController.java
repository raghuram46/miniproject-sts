package com.stg.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.stg.entity.Comment;
import com.stg.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/create")
	public Comment createComment(@Valid @RequestBody Comment comment) {

		return commentService.createComment(comment);
	}

	@GetMapping(value = "/read/{commentId}")
	public Comment readCommentById(@PathVariable int commentId) {

		return commentService.readCommentByCommentId(commentId);
	}

	@GetMapping(value = "/readbyDate")
	public Comment readCommentByCommentedTime(
			@DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam LocalDateTime commentedAt) {

		return commentService.readCommentByCommentedTime(commentedAt);
	}

	@GetMapping(value = "/getAllComments")
	public List<Comment> readAllCommnets() {

		return commentService.getAllComments();
	}

	@PutMapping(value = "/update/{commentId}/{newContent}")
	public Comment updateContent(@PathVariable int commentId, @PathVariable String newContent) {

		return commentService.updateContentById(commentId, newContent);
	}

	@DeleteMapping(value = "/delete/{commentId}")
	public List<Comment> deleteCommentById(@PathVariable int commentId) {

		return commentService.deleteCommentById(commentId);
	}

	@DeleteMapping(value = "/deletebydate")
	public List<Comment> deleteCommentByDateTime(
			@DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam LocalDateTime commentedAt) {

		return commentService.deleteCommentByDate(commentedAt);
	}
}
