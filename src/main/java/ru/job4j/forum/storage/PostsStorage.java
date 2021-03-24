package ru.job4j.forum.storage;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.domain.Post;

public interface PostsStorage extends CrudRepository<Post,Integer> {
}
