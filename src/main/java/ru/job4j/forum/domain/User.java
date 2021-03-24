package ru.job4j.forum.domain;

import javax.persistence.*;

@Entity
@Table(name = "users_forum")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String surname;

    public User() {
    }

    public User(String username, String surname) {
        this.username = username;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
