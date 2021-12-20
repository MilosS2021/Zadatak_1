package com.example.zadatak_1.controller;

import com.example.zadatak_1.model.Film;
import com.example.zadatak_1.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;

@Controller
public class FilmController {

    @Autowired
    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @RequestMapping("/filmovi")
    public String FilmList(Model model){

        model.addAttribute( "filmovi",filmRepository.findAll());
        return "filmovi/film_list";
    }

    @RequestMapping("/filmovi/film_info/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("info", filmRepository.findById(Long.valueOf(id)));
        return "/filmovi/film_info";
    }

    @GetMapping("/filmovi/novi_film")
    public String showSignUpForm(Film film) {
        return "/filmovi/film_novi";
    }
    @PostMapping("/filmovi/dodaj_film")
    public String dodaj_Film(@Validated Film film, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/filmovi/film_novi";
        }

        filmRepository.save(film);
        return "redirect:/filmovi";
    }



    @GetMapping("/filmovi/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid film Id:" + id));

        model.addAttribute("film", film);
        return "/filmovi/film_izmeni";
    }
    @PostMapping("/filmovi/update/{id}")
    public String updateFilm(@PathVariable("id") long id, @Validated Film film,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            film.setId(id);
            return "/filmovi/film_izmeni";
        }

        filmRepository.save(film);
        return "redirect:/filmovi";
    }

    @GetMapping("/filmovi/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Film user = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid film Id:" + id));
        filmRepository.delete(user);
        return "redirect:/filmovi";
    }

}