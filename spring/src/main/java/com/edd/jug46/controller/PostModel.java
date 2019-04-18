package com.edd.jug46.controller;

import java.util.List;

public final class PostModel {

    private final long id;
    private final String content;
    private final List<String> likedBy;

    public PostModel(long id, String content, List<String> likedBy) {
        this.id = id;
        this.content = content;
        this.likedBy = likedBy;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }
}
