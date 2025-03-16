package org.ncu.SocialMediaPostManagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.ncu.SocialMediaPostManagement.Entity.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ncu.SocialMediaPostManagement.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Tag(name = "Post API", description = "Endpoints for managing posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    @Operation(summary = "Create a new post")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        int result = postService.createPost(post);
        return ResponseEntity.ok(result > 0 ? "Post created" : "Error creating post");
    }

    @GetMapping
    @Operation(summary = "Get paginated posts")
    public ResponseEntity<List<Post>> getPosts(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(postService.getPosts(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get post by ID")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a post")
    public ResponseEntity<String> updatePost(@PathVariable int id, @RequestBody Post post) {
        int result = postService.updatePost(id, post);
        return ResponseEntity.ok(result > 0 ? "Post updated" : "Error updating post");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a post")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        int result = postService.deletePost(id);
        return ResponseEntity.ok(result > 0 ? "Post deleted" : "Error deleting post");
    }
}
