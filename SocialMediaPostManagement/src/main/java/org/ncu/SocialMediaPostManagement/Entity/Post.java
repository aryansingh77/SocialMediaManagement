package org.ncu.SocialMediaPostManagement.Entity;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String content;
    private int userId;
    private LocalDateTime createdAt;

    public Post(int id, String title, String content, LocalDateTime createdAt, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Post() {
        this.createdAt = LocalDateTime.now(); 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
