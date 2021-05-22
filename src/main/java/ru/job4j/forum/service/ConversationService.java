package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.domain.Message;
import ru.job4j.forum.domain.Post;
import ru.job4j.forum.storage.MessageStorage;
import ru.job4j.forum.storage.PostsStorage;


import java.util.*;

@Service
public class ConversationService {
    private final PostsStorage postsStorage;
    private final MessageStorage messageStorage;

    public ConversationService(PostsStorage postsStorage, MessageStorage messageStorage) {
        this.postsStorage = postsStorage;
        this.messageStorage = messageStorage;
        //testLaunch();
    }

    public List<Post> getAllPosts() {
        List<Post> rsl = new ArrayList<>();
        postsStorage.findAll().forEach(rsl::add);
        return rsl;
    }

    public void addMessage(Message msg, int postId) {
        this.postsStorage.findById(postId).ifPresent(x -> x.getMessages().add(msg));
    }

    public void addPost(Post post) {
        this.postsStorage.save(post);
    }

    public List<Message> getMessagesByPost(int postId) {
        return getPostById(postId).getMessages();
    }

    public Post getPostById(int id) {
        return postsStorage.findById(id).orElse(null);
    }

    public boolean editPostById(int id, String name, String desc) {
        Post editedPost;
        if (!postsStorage.existsById(id)) {
            return false;
        }
        editedPost = postsStorage.findById(id).get();
        editedPost.setName(name);
        editedPost.setDescription(desc);
        return true;
    }

    private void testLaunch() {
        postsStorage.save(Post.of(1, "TestTopic", "TestDescription"));
        messageStorage.save(new Message(1, postsStorage.findById(1).get(), "testMessage", new Date()));
    }

}
