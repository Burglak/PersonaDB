package com.example.personadb.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "affinity")
public class Affinity implements Serializable{
    private static final long serialVersionUID = 3L;

    @Column(name = "id_affinity", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "affinity", cascade = CascadeType.ALL)
    private List<PersonaAffinity> personaAffinities;
    public Affinity(){ }
    public Affinity(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
