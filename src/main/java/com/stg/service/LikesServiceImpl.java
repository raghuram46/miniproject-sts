package com.stg.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Likes;
import com.stg.exception.CustomException;
import com.stg.repository.LikesRepo;

@Service
public class LikesServiceImpl implements LikesService {
	
	@Autowired
	private LikesRepo likesRepo;

	@Override
	public Likes createLike(Likes likes) throws CustomException {
		Optional<Likes> optional = likesRepo.findById(likes.getLikeId());

		if (optional.isPresent()) {
			throw new CustomException("Like already exists");
		}

		LocalDateTime datetime1 = LocalDateTime.now();
		likes.setLikedAt(datetime1);

		return likesRepo.save(likes);
	}

	@Override
	public Likes readLikesByLikeId(int likeId) throws CustomException {
		Optional<Likes> optional = likesRepo.findById(likeId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new CustomException("No like with the given likeId");
		}
	}

	@Override
	public List<Likes> getAllLikes() throws CustomException {
		return likesRepo.findAll();
	}

	@Override
	public List<Likes> deleteLikesById(int likeId) throws CustomException {
		Optional<Likes> optional = likesRepo.findById(likeId);

		if (optional.isPresent()) {
			likesRepo.deleteById(likeId);
		} else {
			throw new CustomException("Enter valid likeId to delete Like");
		}

		return likesRepo.findAll();
	}

}
