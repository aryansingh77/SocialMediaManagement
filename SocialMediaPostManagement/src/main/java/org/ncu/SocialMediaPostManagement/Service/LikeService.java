package org.ncu.SocialMediaPostManagement.Service;

import org.ncu.SocialMediaPostManagement.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Transactional
    public int addLike(int postId, int userId) {
        return likeRepository.addLike(postId, userId);
    }

    public int getLikeCount(int postId) {
        return likeRepository.getLikeCount(postId);
    }
}

