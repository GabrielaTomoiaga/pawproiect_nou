package org.example.shop_online.controller;
import org.example.shop_online.model.User;
import org.example.shop_online.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    // ruta pentru afisarea paginii de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // ruta pentru afisarea paginii de inregistrare
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    // ruta pentru procesarea datelor din formularul de inregistrare
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
