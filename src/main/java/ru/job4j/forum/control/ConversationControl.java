package ru.job4j.forum.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.ConversationService;

import java.util.Optional;

@Controller
public class ConversationControl {
    @Autowired
    private ConversationService conversationService;

    public ConversationControl() {
    }

    @GetMapping("/topic")
    public String getpost(@RequestParam(required = false, value = "topic", defaultValue = "Empty topic") int topic, Model model) {
        model.addAttribute("messages", conversationService.getMessagesByPost(topic));
        model.addAttribute("topic", topic);
        return "topic";
    }

    @GetMapping("/edit")
    public String getEditPost(@RequestParam(required = false, value = "topic", defaultValue = "Empty topic") int topic, Model model) {
        Optional<Post> optionalPost = Optional.ofNullable(conversationService.getPostById(topic));
       if(optionalPost.isPresent()) {
           model.addAttribute("post",optionalPost.get());
           model.addAttribute("alert","display: none");
       }
       return "edit";
    }
}
