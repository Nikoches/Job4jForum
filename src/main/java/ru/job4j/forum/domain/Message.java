package ru.job4j.forum.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name="post")
    private Post post;
    @Transient
    private User author;
    private String message;
    private Date date;

    public Message(int id, String message, Date date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Message(int id, Post post, String message, Date date) {
        this.id = id;
        this.post = post;
        this.message = message;
        this.date = date;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
