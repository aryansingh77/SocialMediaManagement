package org.ncu.SocialMediaPostManagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ncu.SocialMediaPostManagement.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@Tag(name = "Like Management", description = "APIs for managing likes on posts")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/{postId}/{userId}")
    @Operation(summary = "Like a post")
    public ResponseEntity<String> addLike(@PathVariable int postId, @PathVariable int userId) {
        int result = likeService.addLike(postId, userId);
        return ResponseEntity.ok(result > 0 ? "Post liked" : "Error liking post");
    }

    @GetMapping("/{postId}")
    @Operation(summary = "Get like count")
    public ResponseEntity<Integer> getLikeCount(@PathVariable int postId) {
        return ResponseEntity.ok(likeService.getLikeCount(postId));
    }
}

