package com.example.zadatak_1.controller;

import com.example.zadatak_1.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @RequestMapping("/film")
    public String Filmovi(Model model){

        model.addAttribute( "film",filmRepository.findAll());
        return "film";
    }
}