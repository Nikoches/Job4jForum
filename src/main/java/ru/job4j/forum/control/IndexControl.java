package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.domain.Post;
import ru.job4j.forum.service.ConversationService;
import ru.job4j.forum.service.UserService;

@Controller
public class IndexControl {
    private final UserService userService;
    private final ConversationService conversationService;

    public IndexControl(UserService userService, ConversationService conversationService) {
        this.userService = userService;
        this.conversationService = conversationService;
    }

    @GetMapping({"/index"})
    public String index(Model model) {
        model.addAttribute("posts", conversationService.getAllPosts());
        model.addAttribute("users", userService.getUserList());
        return "index";
    }

    @PostMapping({"/createpost"})
    public String createPost(@RequestParam(value = "Post_id") int postId,
                             @RequestParam(value = "Post_desc") String postDesc,
                             @RequestParam(value = "Post_name") String name) {
            conversationService.addPost(Post.of(postId,name,postDesc));
        return "redirect:/post/" + postId;
    }
}