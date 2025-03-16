
package org.ncu.SocialMediaPostManagement.Service;

import org.ncu.SocialMediaPostManagement.Entity.Comment;
import org.ncu.SocialMediaPostManagement.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public int addComment(Comment comment) {
        return commentRepository.addComment(comment);
    }

    public List<Comment> getCommentsByPostId(int postId) {
        return commentRepository.getCommentsByPostId(postId);
    }
}