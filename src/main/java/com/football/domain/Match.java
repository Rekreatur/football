package com.football.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Match {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "homeTeam")
    private String homeTeam;

    @Column(name = "guestTeam")
    private String guestTeam;

    @Column(name = "homeGoals")
    private Long homeGoals;

    @Column(name = "guestGoals")
    private Long guestGoals;

    @Column(name = "tournamentName")
    private String tournamentName;


}
