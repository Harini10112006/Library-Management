package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.entities.User;
import com.example.DigitalLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "user/list";
    }

     @GetMapping("/form")
    public String showUserForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("user", userService.getUserById(id));
        } else {
            model.addAttribute("user", new User());
        }
        return "user/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

    
}
