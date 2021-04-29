package com.football.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "match")
@Getter
@Setter
@EqualsAndHashCode
public class Match {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @OneToOne
    @JoinColumn(name = "guest_team_id")
    private Team guestTeam;

    @Column(name = "home_goals")
    private Integer homeGoals;

    @Column(name = "guest_goals")
    private Integer guestGoals;

    @OneToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


}
