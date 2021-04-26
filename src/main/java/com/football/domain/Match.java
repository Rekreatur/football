package com.football.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "match")
@Data
public class Match {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  @JoinColumn(name = "home_Team")
  private Team homeTeam;

  @OneToOne
  @JoinColumn(name = "guest_Team")
  private Team guestTeam;

  @Column(name = "home_Goals")
  private Integer homeGoals;

  @Column(name = "guest_Goals")
  private Integer guestGoals;

  @OneToOne
  @JoinColumn(name = "tournament")
  private Tournament tournament;


}
