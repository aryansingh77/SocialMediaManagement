package org.ncu.SocialMediaPostManagement.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int addLike(int postId, int userId) {
        String sql = "INSERT INTO likes (post_id, user_id) VALUES (:postId, :userId)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("postId", postId)
                .addValue("userId", userId);
        return jdbcTemplate.update(sql, params);
    }

    public int getLikeCount(int postId) {
        String sql = "SELECT COUNT(*) FROM likes WHERE post_id = :postId";
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("postId", postId);
        return jdbcTemplate.queryForObject(sql, params, Integer.class);
    }
}

