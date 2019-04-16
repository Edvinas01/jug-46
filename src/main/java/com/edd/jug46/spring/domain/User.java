package com.edd.jug46.spring.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String picture;

    @OneToMany
    @Cascade(value = CascadeType.ALL)
    private List<Post> posts;

    public User() {
    }

    public User(String username, String picture, List<Post> posts) {
        this.username = username;
        this.picture = picture;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
