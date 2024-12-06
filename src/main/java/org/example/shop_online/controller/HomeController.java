package org.example.shop_online.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @GetMapping("/")
    public RedirectView home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return new RedirectView("/index");
        }
        return new RedirectView("/login");
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/bijuterii")
    public String bijuterii() {
        return "bijuterii";
    }

    @GetMapping("/cos")
    public String cos() {
        return "cosul_meu";
    }

    @GetMapping("/cont")
    public String cont() {
        return "cont";
    }
}


