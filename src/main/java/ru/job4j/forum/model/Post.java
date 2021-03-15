package ru.job4j.forum.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Post {
    private int id;
    private String name;
    private String desc;
    private Calendar created;
    private ArrayList<Message> messages = new ArrayList<>();

    public static Post of(int id, String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public static Post of(int id, String name, String desc) {
        Post post = new Post();
        post.name = name;
        post.id = id;
        post.desc = desc;
        return post;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(name, post.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}