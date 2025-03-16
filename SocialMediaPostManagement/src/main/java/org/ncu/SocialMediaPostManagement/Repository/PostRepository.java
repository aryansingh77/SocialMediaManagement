package org.ncu.SocialMediaPostManagement.Repository;

import org.ncu.SocialMediaPostManagement.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int createPost(Post post) {
        String sql = "INSERT INTO posts (title, content, user_id) VALUES (:title, :content, :userId)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", post.getTitle())
                .addValue("content", post.getContent())
                .addValue("userId", post.getUserId()); // 👈 Include user_id
        return jdbcTemplate.update(sql, params);
    }

    public List<Post> getPosts(int page, int size) {
        String sql = "SELECT * FROM posts ORDER BY created_at DESC LIMIT :size OFFSET :offset";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("size", size)
                .addValue("offset", (page - 1) * size);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Post.class));
    }

    public Post getPostById(int id) {
        String sql = "SELECT * FROM posts WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Post.class));
    }

    public int updatePost(int id, Post post) {
        String sql = "UPDATE posts SET title = :title, content = :content WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("title", post.getTitle())
                .addValue("content", post.getContent())
                .addValue("id", id);
        return jdbcTemplate.update(sql, params);
    }

    public int deletePost(int id) {
        String sql = "DELETE FROM posts WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.update(sql, params);
    }
}
