package com.edd.jug46.controller;

import java.util.List;

public final class UserModel {

    private final long id;

    private final String username;
    private final String picture;

    private final List<PostModel> posts;

    public UserModel(long id, String username, String picture, List<PostModel> posts) {
        this.id = id;
        this.username = username;
        this.picture = picture;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public List<PostModel> getPosts() {
        return posts;
    }
}
