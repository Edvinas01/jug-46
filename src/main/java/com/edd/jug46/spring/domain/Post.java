package com.edd.jug46.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToMany
    private List<User> likedBy;

    public Post() {
    }

    public Post(String content, List<User> likedBy) {
        this.content = content;
        this.likedBy = likedBy;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }
}
