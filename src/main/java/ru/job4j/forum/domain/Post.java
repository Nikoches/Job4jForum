package ru.job4j.forum.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Calendar created;
    @OneToMany(mappedBy = "id",fetch = FetchType.EAGER)
    private List<Message> messages = new ArrayList<>();

    public Post() {

    }

    public static Post of(int id, String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public static Post of(int id, String name, String desc) {
        Post post = new Post();
        post.name = name;
        post.id = id;
        post.description = desc;
        return post;
    }

    public List<Message> getMessages() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return Objects.hash(id, name, description, created);
    }
}