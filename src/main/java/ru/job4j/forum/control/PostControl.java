package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.domain.Post;
import ru.job4j.forum.service.ConversationService;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/post")
public class PostControl {
    @Autowired
    private ConversationService conversationService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String add(@PathVariable int id, Model model) {
        if (conversationService.getMessagesByPost(id) == null) {
            return "error";
        } else {
            model.addAttribute("messages", conversationService.getMessagesByPost(id));
            model.addAttribute("post", id);
        }
        return "post";
    }
    @GetMapping("/edit/{id}")
    public String getEditPost(@PathVariable int id, Model model) {
        Optional<Post> optionalPost = Optional.ofNullable(conversationService.getPostById(id));
        if (optionalPost.isPresent()) {
            model.addAttribute("post", optionalPost.get());
            model.addAttribute("alert", "display: none");
        }
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public RedirectView saveEditedPost(@RequestParam(value = "post_name") String post_name,
                                       @RequestParam(value = "post_desc") String post_desc,
                                       @RequestParam(value = "post_date")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                       @PathVariable int id) {
        Post editedPost = conversationService.getPostById(id);
        if (!post_name.isEmpty()) {
            editedPost.setName(post_name);
        }
        if (!post_desc.isEmpty()) {
            editedPost.setDescription(post_desc);
        }
        Optional.ofNullable(date).ifPresent(x -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            editedPost.setCreated(calendar);
        });
        return new RedirectView("/index");
    }
}
