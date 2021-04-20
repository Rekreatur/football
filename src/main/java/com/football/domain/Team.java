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

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "city_name", nullable = false)
    private String cityName;
}
