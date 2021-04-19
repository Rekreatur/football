package com.football.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Team {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "teanName")
    private String teamName;

    @Column(name = "cityName")
    private String cityName;
}
