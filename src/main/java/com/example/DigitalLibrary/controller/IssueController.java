package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.entities.Issue;
import com.example.DigitalLibrary.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

     @GetMapping
    public String listIssues(Model model) {
        model.addAttribute("issues", issueRepository.findAll());
        return "issue/list";
    }

    @GetMapping("/list")
    public String listIssuesAlt(Model model) {
        return listIssues(model);
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("issue", issueRepository.findById(id).orElse(new Issue()));
        } else {
            model.addAttribute("issue", new Issue());
        }
        return "issue/form";
    }

    @PostMapping
    public String saveIssue(@ModelAttribute("issue") Issue issue) {
        issueRepository.save(issue);
        return "redirect:/issues";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteIssue(@PathVariable Long id){
        issueRepository.deleteById(id);
        return "redirect:/issues";
    }
    
}
