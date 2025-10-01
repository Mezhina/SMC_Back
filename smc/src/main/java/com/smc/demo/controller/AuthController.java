package com.smc.demo.controller;

import com.smc.demo.model.User;
import com.smc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout,
                       Model model) {
        if (error != null) {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
        }
        if (logout != null) {
            model.addAttribute("message", "Вы успешно вышли из системы");
        }
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {
        try {
            // Проверяем, существует ли пользователь с таким username
            if (userService.existsByUsername(user.getUsername())) {
                model.addAttribute("error", "Пользователь с таким именем уже существует");
                return "register";
            }

            // Проверяем, существует ли пользователь с таким email
            if (user.getEmail() != null && userService.existsByEmail(user.getEmail())) {
                model.addAttribute("error", "Пользователь с таким email уже существует");
                return "register";
            }

            // Сохраняем пользователя
            userService.saveUser(user);
            model.addAttribute("message", "Регистрация прошла успешно! Теперь вы можете войти в систему.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при регистрации: " + e.getMessage());
            return "register";
        }
    }
}

