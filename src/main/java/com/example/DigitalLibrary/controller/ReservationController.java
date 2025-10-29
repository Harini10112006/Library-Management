package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.entities.Reservation;
import com.example.DigitalLibrary.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")

public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public String listReservations(Model model){
        model.addAttribute("reservations",reservationRepository.findAll());
        return "reservation/list";
    }

     @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/form";
    }  

    @PostMapping
    public String saveReservation (@ModelAttribute("reservation") Reservation reservation){
        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }
    
    @GetMapping("/delete/{id}")
    public String savrReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
        return "redirect:/reservations";
    }
    
}
