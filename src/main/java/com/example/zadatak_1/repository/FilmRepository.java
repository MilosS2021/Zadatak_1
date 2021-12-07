package com.example.zadatak_1.repository;


import com.example.zadatak_1.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>  {

        // all crud database methods

}
