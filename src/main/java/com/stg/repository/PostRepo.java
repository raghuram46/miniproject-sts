package com.stg.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	Optional<Post> findByPostedAt(LocalDateTime postedAt);

}
