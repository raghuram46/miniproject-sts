package com.stg.service;

import java.time.LocalDateTime;
import java.util.List;

import com.stg.entity.Comment;

public interface CommentService {
	public abstract Comment createComment(Comment comment);

	public abstract Comment readCommentByCommentId(int commentId);

	public abstract Comment readCommentByCommentedTime(LocalDateTime commentedAt);

	public abstract List<Comment> getAllComments();

	public abstract Comment updateContentById(int commentId, String newContent);

	public abstract List<Comment> deleteCommentById(int commentId);

	public abstract List<Comment> deleteCommentByDate(LocalDateTime commentedAt);
}
