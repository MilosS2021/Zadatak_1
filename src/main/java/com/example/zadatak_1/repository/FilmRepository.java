package com.example.zadatak_1.repository;


import com.example.zadatak_1.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long>  {

        // all crud database methods


    //Custom query
    @Query(value = "select * from film f where f.naziv like %:keyword% or f.godina like %:keyword%  or f.boja like %:keyword%", nativeQuery = true)
    List<Film> findByKeyword(@Param("keyword") String keyword);
}
