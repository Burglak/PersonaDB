package com.example.personadb.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="persona_affinity")
public class PersonaAffinity implements Serializable {
    private static final long serialVersionUID = 7L;

    @Column(name="id_persona_affinity", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="persona_id")
    private int persona_id;

    @Column(name="affinity_id")
    private int affinity_id;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "affinity_id", referencedColumnName = "id_affinity", insertable = false, updatable = false)
    private Affinity affinity;

    public Affinity getAffinity() {
        return affinity;
    }

    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaAffinity() { }

    public int getAffinity_id() {
        return affinity_id;
    }

    public void setAffinity_id(int affinity_id) {
        this.affinity_id = affinity_id;
    }

    public PersonaAffinity(int persona_id, int affinity_id, String type) {
        this.persona_id = persona_id;
        this.affinity_id = affinity_id;
        this.type = type;
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
}
