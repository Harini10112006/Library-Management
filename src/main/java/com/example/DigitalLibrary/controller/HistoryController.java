package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.repository.HistoryRepository;
import com.example.DigitalLibrary.entities.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/history")
public class HistoryController {
     @Autowired
    private HistoryRepository historyRepository;

    @GetMapping
    public String listHistory(Model model) {
        model.addAttribute("history", historyRepository.findAll());
        return "history/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("record", new History());
        return "history/form";
    }
    @PostMapping
    public String save(@ModelAttribute("record") History record) {
        historyRepository.save(record);
        return "redirect:/history";
    }
}
