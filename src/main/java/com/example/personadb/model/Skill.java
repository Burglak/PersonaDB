package com.example.personadb.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {
    private static final long serialVersionUID = 4L;

    @Column(name = "id_skill", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lvl")
    private int lvl;

    @Column(name = "description")
    private String description;

    @Column(name = "power")
    private int power;

    @Column(name = "type")
    private String type;

    @Column(name = "cost")
    private int cost;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<PersonPersonaSkill> personPersonaSkills;


    public Skill() { }

    public Skill(String name, int lvl, String description, int power, String type, int cost) {
        this.name = name;
        this.lvl = lvl;
        this.description = description;
        this.power = power;
        this.type = type;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<PersonPersonaSkill> getPersonPersonaSkills() {
        return personPersonaSkills;
    }

    public void setPersonPersonaSkills(List<PersonPersonaSkill> personPersonaSkills) {
        this.personPersonaSkills = personPersonaSkills;
    }
}
