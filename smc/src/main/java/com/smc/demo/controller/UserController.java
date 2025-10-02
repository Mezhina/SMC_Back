package com.smc.demo.controller;

import com.smc.demo.model.User;
import com.smc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model, Authentication authentication) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        
        if (authentication != null && authentication.isAuthenticated()) {
            User currentUser = (User) authentication.getPrincipal();
            model.addAttribute("currentUser", currentUser);
        }
        
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/users")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
