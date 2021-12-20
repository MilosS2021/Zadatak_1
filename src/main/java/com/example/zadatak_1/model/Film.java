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

    @ManyToMany(mappedBy = "film",  cascade = { CascadeType.ALL })
    private Set<Glumac> glumac=new HashSet<>();

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "godina")
    private String godina;

    @Column(name = "boja")
    private String boja;





}
