package com.example.zadatak_1.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "filmovi")
    private Set<Glumac> glumci=new HashSet<>();

    @Column(name = "Naziv")
    private String Naziv;

    @Column(name = "Godina")
    private String Godina;

    @Column(name = "Boja")
    private String Boja;





}
