package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;


import java.util.*;

@Service
public class ConversationService {
    private final HashMap<Integer, Post> posts = new HashMap<>();

    public ConversationService() {
        testLaunch();

    }

    public Collection<Post> getAllPosts() {
        return posts.values();
    }

    public void addMessage(Message msg, int postId) {
        this.posts.get(postId).getMessages().add(msg);
    }

    public List<Message> getMessagesByPost(int postId) {
        return posts.get(postId).getMessages();
    }

    public Post getPostById(int id) {
        return posts.get(id);
    }

    private void testLaunch() {
        this.posts.put(1, Post.of(1, "TestTopic", "TestDescription"));
        this.posts.get(1).getMessages().add(new Message(1, "TestMessage", new Date()));
    }

    public boolean editPostById(int id, String name, String desc) {
        Post editedPost = null;
        if (posts.get(id) == null) {
            return false;
        }
        editedPost.setName(name);
        editedPost.setDesc(desc);
        return true;
    }
}
