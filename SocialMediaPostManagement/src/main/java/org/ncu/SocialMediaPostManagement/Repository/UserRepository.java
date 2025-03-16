package org.ncu.SocialMediaPostManagement.Repository;

import org.ncu.SocialMediaPostManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int addUser(User user) {
        String sql = "INSERT INTO users (email, password) VALUES (:email, :password)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", email);

        return jdbcTemplate.query(sql, params, (ResultSet rs) -> {
            if (rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            } else {
                return Optional.empty();
            }
        });
    }
}

