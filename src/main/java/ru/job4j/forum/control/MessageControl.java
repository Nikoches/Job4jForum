package ru.job4j.forum.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.domain.Message;
import ru.job4j.forum.domain.Post;
import ru.job4j.forum.service.ConversationService;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class MessageControl {
    @Autowired
    private ConversationService conversationService;

    public MessageControl() {
    }

    @PostMapping("/createMessage")
    public RedirectView createMessage(@RequestParam(value = "Post_id") int postId,
                                      @RequestParam(value = "Message_body") String messageBody) {
        Message message = new Message();
        message.setMessage(messageBody);
        message.setPost(conversationService.getPostById(postId));
        conversationService.addMessage(message, postId);
        return new RedirectView("/index");
    }
}
