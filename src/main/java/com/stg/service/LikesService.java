package com.stg.service;

import java.util.List;

import com.stg.entity.Likes;

public interface LikesService {
	public abstract Likes createLike(Likes likes);

	public abstract Likes readLikesByLikeId(int likeId);

	public abstract List<Likes> getAllLikes();

	public abstract List<Likes> deleteLikesById(int likeId);
}
