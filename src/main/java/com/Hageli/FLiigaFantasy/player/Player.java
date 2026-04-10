package com.Hageli.FLiigaFantasy.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {
    @Id
    @Column(name="id", unique=true)
    private Integer id;
    private String name;
    private String nationality;
    private String position;
    private String teamName;
    private Integer age;
    // private Integer games;
    private Integer assists;
    private Integer goals;
    private Integer points;
    private Integer jersey_number;

    public Player () {

    }

    public Player(Integer jersey_number, Integer points, Integer goals, Integer assists, Integer age, String position, String nationality, String name, Integer id, String teamName) {
        this.jersey_number = jersey_number;
        this.points = points;
        this.goals = goals;
        this.assists = assists;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.name = name;
        this.id = id;
        this.teamName = teamName;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getAssists() {
        return assists;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getGoals() {
        return goals;
    }

    public Integer getPoints() {
        return points;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getJersey_number() {
        return jersey_number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setJersey_number(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }
}
