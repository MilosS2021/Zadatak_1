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
@Table(name = "glumac")

public class Glumac {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name="film_glumac",joinColumns = @JoinColumn(name="glumac_id"),inverseJoinColumns = @JoinColumn(name="film_id"))
    private Set<Film> filmovi=new HashSet<>();

    @Column(name = "Ime")
    private String Ime;

    @Column(name = "Prezime")
    private String Prezime;

    @Column(name = "Datum_rodjenja")
    private String Datumrodjenja;


    @Column(name = "Mesto")
    private String Mesto;

    @Column(name = "Oskar")
    private String Oskar;


}
