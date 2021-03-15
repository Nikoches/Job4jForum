package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;


@Controller
public class RegistrationControl {
    private final UserService userService;
    public RegistrationControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/rg"})
    public String registraionGet(Model model) {
        return "registration";
    }

    @PostMapping("/rg")
    public RedirectView registrationPost(@RequestParam(value = "username") String username, @RequestParam(value = "surname") String surname) {
        userService.addUser(
                new User(username, surname));
        return new RedirectView("/index");
    }
}