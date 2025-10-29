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

    @GetMapping("/list")
    public String listHistoryAlt(Model model) {
        return listHistory(model);
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("record", historyRepository.findById(id).orElse(new History()));
        } else {
            model.addAttribute("record", new History());
        }
        return "history/form";
    }
    @PostMapping
    public String save(@ModelAttribute("record") History record) {
        historyRepository.save(record);
        return "redirect:/history";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        historyRepository.deleteById(id);
        return "redirect:/history";
    }
}
