package com.example.zadatak_1.controller;


import com.example.zadatak_1.model.Glumac;
import com.example.zadatak_1.repository.GlumacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GlumacController {

    @Autowired
    private final GlumacRepository glumacRepository;

    public GlumacController(GlumacRepository glumacRepository) {
        this.glumacRepository = glumacRepository;
    }

    @RequestMapping("/glumci")
    public String Glumac_List(Model model){

        model.addAttribute(  "glumci", glumacRepository.findAll());
        return "glumci/glumac_list";
    }


    @RequestMapping("/glumci/glumac_info/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("info", glumacRepository.findById(Long.valueOf(id)));
        return "/glumci/glumac_info";
    }

    @GetMapping("/glumci/novi_glumac")
    public String showSignUpForm(Glumac glumac) {
        return "/glumci/glumac_novi";
    }
    @PostMapping("/glumci/dodaj_glumca")
    public String dodaj_Glumca(@Validated Glumac glumac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/glumci/glumac_novi";
        }

        glumacRepository.save(glumac);
        return "redirect:/glumci";
    }



    @GetMapping("/glumci/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Glumac glumac = glumacRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid glumac Id:" + id));

        model.addAttribute("glumac", glumac);
        return "/glumci/glumac_izmeni";
    }
    @PostMapping("/glumci/update/{id}")
    public String updateFilm(@PathVariable("id") long id, @Validated Glumac glumac,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            glumac.setId(id);
            return "/glumci/glumac_izmeni";
        }

        glumacRepository.save(glumac);
        return "redirect:/glumci";
    }

    @GetMapping("/glumci/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Glumac glumac = glumacRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid glumac Id:" + id));
        glumacRepository.delete(glumac);
        return "redirect:/glumci";
    }
}