package com.stg.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

	Optional<Comment> findByCommentedAt(LocalDateTime commentedAt);

}
