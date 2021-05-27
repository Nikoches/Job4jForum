package ru.job4j.forum.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_forum")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(username, user.getUsername()) &&
                Objects.equals(password, user.getPassword()) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password);
    }
}
