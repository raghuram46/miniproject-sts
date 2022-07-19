package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Likes;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Integer> {

}
