package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.domain.User;
import ru.job4j.forum.storage.UsersStorage;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    private final UsersStorage usersStorage;

    public UserService(UsersStorage usersStorage) {
        this.usersStorage = usersStorage;
    }

    public List<User> getUserList() {
        LinkedList<User> list = new LinkedList<>();
        usersStorage.findAll().forEach(list::add);
        return list;
    }

    public void saveUser(User user) {
        usersStorage.save(user);
    }

    public void removeUser(User user) {
     usersStorage.delete(user);
    }
}
