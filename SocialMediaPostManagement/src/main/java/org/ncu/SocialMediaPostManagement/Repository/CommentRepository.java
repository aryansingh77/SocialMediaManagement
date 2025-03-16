package org.ncu.SocialMediaPostManagement.Repository;

import org.ncu.SocialMediaPostManagement.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int addComment(Comment comment) {
        String sql = "INSERT INTO comments (post_id, user_id, content) VALUES (:postId, :userId, :content)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("postId", comment.getPostId())
                .addValue("userId", comment.getUserId())
                .addValue("content", comment.getContent());
        return jdbcTemplate.update(sql, params);
    }

    public List<Comment> getCommentsByPostId(int postId) {
        String sql = "SELECT * FROM comments WHERE post_id = :postId ORDER BY created_at DESC";
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("postId", postId);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Comment.class));
    }
}
