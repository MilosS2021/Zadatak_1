package com.example.zadatak_1.controller;


import com.example.zadatak_1.repository.GlumacRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GlumacController {

    private final GlumacRepository glumacRepository;

    public GlumacController(GlumacRepository glumacRepository) {
        this.glumacRepository = glumacRepository;
    }

    @RequestMapping("/glumci")
    public String Glumci(Model model){

        model.addAttribute(  "glumci", glumacRepository.findAll());
        return "glumci/list";
    }
}