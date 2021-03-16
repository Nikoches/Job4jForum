package ru.job4j.forum.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.ConversationService;

import java.util.Calendar;
import java.util.Date;
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
        if (optionalPost.isPresent()) {
            model.addAttribute("post", optionalPost.get());
            model.addAttribute("alert", "display: none");
        }
        return "edit";
    }

    @PostMapping("/edit")
    public RedirectView saveEditedPost(@RequestParam(value = "post_name") String post_name,
                                       @RequestParam(value = "post_desc") String post_desc,
                                       @RequestParam(value = "post_date")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                       @RequestParam(value = "post_id") int id) {
        Post editedPost = conversationService.getPostById(id);
        if (!post_name.isEmpty()) {
            editedPost.setName(post_name);
        }
        if (!post_desc.isEmpty()) {
            editedPost.setDesc(post_desc);
        }
        Optional.ofNullable(date).ifPresent(x -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            editedPost.setCreated(calendar);
        });
        return new RedirectView("/index");
    }
}
