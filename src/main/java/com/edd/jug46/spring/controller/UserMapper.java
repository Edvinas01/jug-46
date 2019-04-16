package com.edd.jug46.spring.controller;

import com.edd.jug46.spring.domain.Post;
import com.edd.jug46.spring.domain.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class UserMapper {

    private UserMapper() {
    }

    public static List<UserModel> map(Collection<User> users) {
        return users
            .stream()
            .map(UserMapper::map)
            .collect(Collectors.toList());
    }

    private static PostModel map(Post post) {
        return new PostModel(
            post.getId(),
            post.getContent(),
            post
                .getLikedBy()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList())
        );
    }

    private static UserModel map(User user) {
        return new UserModel(
            user.getId(),
            user.getUsername(),
            user.getPicture(),
            user
                .getPosts()
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList())
        );
    }
}
