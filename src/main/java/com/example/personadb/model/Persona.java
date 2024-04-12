package com.example.personadb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 2L;

    @Column(name = "id_persona", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "strength")
    private int strength;

    @Column(name = "magic")
    private int magic;

    @Column(name = "endurance")
    private int endurance;

    @Column(name = "agility")
    private int agility;

    @Column(name = "luck")
    private int luck;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PersonPersona> personPersonas;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PersonaAffinity> personaAffinities;

    public Persona() {
    }

    public Persona(String name, String type, int strength, int magic, int endurance, int agility, int luck, int price) {
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.magic = magic;
        this.endurance = endurance;
        this.agility = agility;
        this.luck = luck;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<PersonPersona> getPersonPersonas() {
        return personPersonas;
    }

    public void setPersonPersonas(List<PersonPersona> personPersonas) {
        this.personPersonas = personPersonas;
    }
}
