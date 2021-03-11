package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.ConversationService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class IndexControl {
    private final PostService posts;
    private final UserService userService;
    private final ConversationService conversationService;
    public IndexControl(PostService posts, UserService userService, ConversationService conversationService) {
        this.posts = posts;
        this.userService = userService;
        this.conversationService = conversationService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", conversationService.getAllTopics());
        model.addAttribute("users", userService.getUserList());
        return "index";
    }
}