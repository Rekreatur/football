package com.football.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
public class Tournament {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tournamentName")
    private String tournamentName;

    @Column(name = "year")
    @Size(min = 4, max = 4)
    private Integer year;
}
