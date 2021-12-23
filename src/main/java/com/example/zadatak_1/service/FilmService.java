package com.example.zadatak_1.service;

import java.util.List;

import com.example.zadatak_1.model.Film;
import com.example.zadatak_1.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    private FilmRepository repository;


    public List<Film> getAllFilms(){
        List<Film> list =  (List<Film>)repository.findAll();
        return list;
    }

    public List<Film> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}