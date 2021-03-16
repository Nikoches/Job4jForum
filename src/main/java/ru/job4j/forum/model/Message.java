package ru.job4j.forum.model;

import java.util.Date;

public class Message {
    private int id;
    private Post post;
    private User author;
    private String message;
    private Date date;

    public Message(int id, String message, Date date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Message(int id, Post post, User author, String message, Date date) {
        this.id = id;
        this.post = post;
        this.author = author;
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
