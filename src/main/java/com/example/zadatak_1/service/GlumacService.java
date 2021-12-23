package com.example.zadatak_1.service;

import com.example.zadatak_1.model.Glumac;
import com.example.zadatak_1.repository.GlumacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GlumacService {

    @Autowired
    private GlumacRepository repository;


    public List<Glumac> getAllGlumac(){
        List<Glumac> list =  (List<Glumac>)repository.findAll();
        return list;
    }

    public List<Glumac> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}
