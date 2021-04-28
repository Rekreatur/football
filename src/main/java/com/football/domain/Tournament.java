package com.football.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tournament")
@Getter
@Setter
@EqualsAndHashCode
public class Tournament {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "tournament_Name", nullable = false)
  private String tournamentName;

  @Column(name = "start_year", nullable = false)
  private Integer startYear;
}
