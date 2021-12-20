package com.example.zadatak_1.controller;

import com.example.zadatak_1.repository.FilmRepository;
import com.example.zadatak_1.repository.GlumacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoKlubController {

    @Autowired
    private final FilmRepository filmRepository;
   private final GlumacRepository glumacRepository;




    public VideoKlubController(FilmRepository filmRepository, GlumacRepository glumacRepository) {
        this.filmRepository = filmRepository;

        this.glumacRepository = glumacRepository;
    }



    @GetMapping("/index")
    public String show(Model model) {

        return "index";
    }

    @GetMapping("/filmovi/film_list")
    public String showF(Model model) {
        model.addAttribute( "filmovi",filmRepository.findAll());
        return "filmovi/film_list";
    }

    @GetMapping("/glumci/glumac_list")
    public String showG(Model model) {
       model.addAttribute(  "glumci", glumacRepository.findAll());
        return "/glumci/glumac_list";
    }
}
