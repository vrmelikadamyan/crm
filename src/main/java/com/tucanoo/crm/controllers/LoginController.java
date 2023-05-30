package com.tucanoo.crm.controllers;

import com.tucanoo.crm.data.entities.Customer;
import com.tucanoo.crm.data.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final CustomerRepository customerRepository;

    @GetMapping("/login")
    public String signIn(Model model) {
        return "login";
    }

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        User userInfo = (User) authentication.getPrincipal();
        Customer byUsername = customerRepository.findByUsername(userInfo.getUsername());
        model.addAttribute("fullNameUser", byUsername.getFullName());

        return "index";
    }
}
