package com.example.zadatak_1;

import com.example.zadatak_1.model.Film;
import com.example.zadatak_1.model.Glumac;
import com.example.zadatak_1.repository.FilmRepository;
import com.example.zadatak_1.repository.GlumacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class Zadatak1Application implements CommandLineRunner {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private GlumacRepository glumacRepository;


    @Override
    public void run(String...args) throws Exception {


        Film film = new Film();
        film.setNaziv("Balkanski spijun");
        film.setGodina("1982");


        Glumac glumac = new Glumac();
        glumac.setIme("Bogdan");
        glumac.setPrezime("Diklic");


        Glumac glumac1 = new Glumac();
        glumac1.setIme("Pavle");
        glumac1.setPrezime("Vujisic");


        film.getGlumac().add(glumac);
        film.getGlumac().add(glumac1);


        glumac.getFilm().add(film);
        glumac1.getFilm().add(film);


        filmRepository.save(film);


    }



    public static void main(String[] args) {
        SpringApplication.run(Zadatak1Application.class, args);
    }

}
