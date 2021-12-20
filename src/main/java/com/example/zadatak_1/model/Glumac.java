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
    private Set<Film> film=new HashSet<>();

    @Column(name = "Ime")
    private String ime;

    @Column(name = "Prezime")
    private String prezime;

    @Column(name = "Datum_rodjenja")
    private String datumrodjenja;


    @Column(name = "Mesto")
    private String mesto;

    @Column(name = "Oskar")
    private String oskar;


}
