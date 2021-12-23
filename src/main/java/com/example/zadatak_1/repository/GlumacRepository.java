package com.example.zadatak_1.repository;

import com.example.zadatak_1.model.Glumac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GlumacRepository extends JpaRepository<Glumac, Long>  {

    //Custom query
    @Query(value = "select * from glumac g where g.ime like %:keyword% or g.prezime like %:keyword%  or g.oskar like %:keyword%", nativeQuery = true)
    List<Glumac> findByKeyword(@Param("keyword") String keyword);

    // all crud database methods

}