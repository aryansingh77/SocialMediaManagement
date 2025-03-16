package org.ncu.SocialMediaPostManagement.Service;

import org.ncu.SocialMediaPostManagement.Entity.Post;
import org.ncu.SocialMediaPostManagement.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public int createPost(Post post) {
        return postRepository.createPost(post);
    }

    public List<Post> getPosts(int page, int size) {
        return postRepository.getPosts(page, size);
    }

    public Post getPostById(int id) {
        return postRepository.getPostById(id);
    }

    @Transactional
    public int updatePost(int id, Post post) {
        return postRepository.updatePost(id, post);
    }

    @Transactional
    public int deletePost(int id) {
        return postRepository.deletePost(id);
    }
}


