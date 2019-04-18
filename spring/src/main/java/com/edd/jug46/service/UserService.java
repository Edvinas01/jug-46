package com.edd.jug46.service;

import com.edd.jug46.domain.Post;
import com.edd.jug46.configuration.UserGenerator;
import com.edd.jug46.domain.User;
import com.edd.jug46.domain.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private final UserRepository users;
    private final UserGenerator generator;

    public UserService(UserRepository users, UserGenerator generator) {
        this.users = users;
        this.generator = generator;
    }

    @PostConstruct
    public void seed() {
        var pete = new User(
            "Pete",
            "https://i.pinimg.com/originals/fa/ef/5f/faef5f7dde3e93d8080d92e9c943288c.jpg",
            List.of(
                new Post("Cookies are nice", List.of()),
                new Post("Foo", List.of())
            )
        );

        var carl = new User(
            "Carl",
            "https://i.ytimg.com/vi/V7-nlIPTZKQ/maxresdefault.jpg",
            List.of(
                new Post("Bar", List.of(pete))
            )
        );

        users.save(pete);
        users.save(carl);

        generator.generate();
    }

    public List<User> getUsers() {
        return users.findAll();
    }
}
