package ru.job4j.forum.storage;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.domain.Message;

public interface MessageStorage extends CrudRepository<Message,Integer> {
}
