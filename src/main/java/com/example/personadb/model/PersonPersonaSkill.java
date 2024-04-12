package com.example.personadb.model;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_persona_skill")
public class PersonPersonaSkill implements Serializable{
    private static final long serialVersionUID = 6L;

    @Column(name="id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="person_persona_id")
    private int personPersonaId;

    @Column(name="skill_id")
    private int skillId;

    @ManyToOne
    @JoinColumn(name = "person_persona_id", referencedColumnName = "id_person_persona", insertable = false, updatable = false)
    private PersonPersona personPersona;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id_skill", insertable = false, updatable = false)
    private Skill skill;

    public PersonPersonaSkill() { }

    public PersonPersonaSkill(int personPersonaId, int skillId) {
        this.personPersonaId = personPersonaId;
        this.skillId = skillId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonPersonaId() {
        return personPersonaId;
    }

    public void setPersonPersonaId(int personPersonaId) {
        this.personPersonaId = personPersonaId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public PersonPersona getPersonPersona() {
        return personPersona;
    }

    public void setPersonPersona(PersonPersona personPersona) {
        this.personPersona = personPersona;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
