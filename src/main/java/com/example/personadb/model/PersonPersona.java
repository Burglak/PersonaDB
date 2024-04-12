package com.example.personadb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person_persona")
public class PersonPersona implements Serializable {
    private static final long serialVersionUID = 5L;

    @Column(name = "id_person_persona", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "persona_id")
    private int persona_id;

    @Column(name = "person_id")
    private int person_id;

    @Column(name = "persona_lvl")
    private int persona_lvl;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id_person", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private Persona persona;


    @OneToMany(mappedBy = "personPersona", cascade = CascadeType.ALL)
    private List<PersonPersonaSkill> personPersonaSkills;

    public PersonPersona() { }

    public PersonPersona(int persona_id, int person_id, int persona_lvl) {
        this.persona_id = persona_id;
        this.person_id = person_id;
        this.persona_lvl = persona_lvl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getPersona_lvl() {
        return persona_lvl;
    }

    public void setPersona_lvl(int persona_lvl) {
        this.persona_lvl = persona_lvl;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<PersonPersonaSkill> getPersonPersonaSkills() {
        return personPersonaSkills;
    }

    public void setPersonPersonaSkills(List<PersonPersonaSkill> personPersonaSkills) {
        this.personPersonaSkills = personPersonaSkills;
    }
}
