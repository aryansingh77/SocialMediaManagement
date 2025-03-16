package org.ncu.SocialMediaPostManagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ncu.SocialMediaPostManagement.Entity.Comment;
import org.ncu.SocialMediaPostManagement.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comment Management", description = "APIs for managing comments on posts")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    @Operation(summary = "Add a new comment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        int result = commentService.addComment(comment);
        return ResponseEntity.ok(result > 0 ? "Comment added" : "Error adding comment");
    }

    @GetMapping("/post/{postId}")
    @Operation(summary = "Get comments for a post")
    public ResponseEntity<List<Comment>> getComments(@PathVariable int postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

}
