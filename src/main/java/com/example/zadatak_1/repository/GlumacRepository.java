package com.example.zadatak_1.repository;

import com.example.zadatak_1.model.Glumac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlumacRepository extends JpaRepository<Glumac, Long>  {

    // all crud database methods

}