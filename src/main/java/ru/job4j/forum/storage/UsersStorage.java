package ru.job4j.forum.storage;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.domain.User;

public interface UsersStorage extends CrudRepository<User, Integer> {
}
