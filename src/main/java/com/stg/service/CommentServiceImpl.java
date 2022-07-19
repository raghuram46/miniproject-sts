package com.stg.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Comment;
import com.stg.exception.CustomException;
import com.stg.repository.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public Comment createComment(Comment comment) throws CustomException {
		Optional<Comment> optional = commentRepo.findById(comment.getCommentId());

		if (optional.isPresent()) {
			throw new CustomException("Comment already exists");
		}

		LocalDateTime datetime1 = LocalDateTime.now();
		comment.setCommentedAt(datetime1);

		return commentRepo.save(comment);
	}

	@Override
	public Comment readCommentByCommentId(int commentId) throws CustomException {
		Optional<Comment> optional = commentRepo.findById(commentId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No comment with the given commentId");
		}

	}

	@Override
	public Comment readCommentByCommentedTime(LocalDateTime commentedAt)throws CustomException {
		Optional<Comment> optional = commentRepo.findByCommentedAt(commentedAt);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No comment at the given comment time");
		}
	}

	@Override
	public List<Comment> getAllComments() throws CustomException {

		return commentRepo.findAll();
	}

	@Override
	public Comment updateContentById(int commentId, String newContent) throws CustomException {
		Comment tempComment = null;
		Optional<Comment> optional = commentRepo.findById(commentId);

		if (optional.isPresent()) {
			tempComment = optional.get();
			tempComment.setContent(newContent);
		} else {
			throw new CustomException("Enter valid commentId to update content");
		}

		return commentRepo.save(tempComment);
	}

	@Override
	public List<Comment> deleteCommentById(int commentId) throws CustomException {
		Optional<Comment> optional = commentRepo.findById(commentId);

		if (optional.isPresent()) {
			commentRepo.deleteById(commentId);
		} else {
			throw new CustomException("Enter valid commentId to delete comment");
		}

		return commentRepo.findAll();
	}

	@Override
	public List<Comment> deleteCommentByDate(LocalDateTime commentedAt) throws CustomException {
		Optional<Comment> optional = commentRepo.findByCommentedAt(commentedAt);

		if (optional.isPresent()) {
			commentRepo.delete(optional.get());
		} else {
			throw new CustomException("Enter valid comment datetime to delete comment");
		}

		return commentRepo.findAll();
	}

}
