package com.example.personadb.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="id_person", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="account_type")
    private String accountType;

    @Column(name="balance")
    private int balance;

    @Column(name="ranking")
    private int ranking;

    @Column(name="hp")
    private int hp;

    @Column(name="sp")
    private int sp;

    //cascade
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PersonPersona> personPersonas;

    //default constructor
    public Person() { }

    public Person(String login, String password, String username, String email, String accountType, int balance, int ranking, int hp, int sp) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.email = email;
        this.accountType = accountType;
        this.balance = balance;
        this.ranking = ranking;
        this.hp = hp;
        this.sp = sp;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public List<PersonPersona> getPersonPersonas() {
        return personPersonas;
    }

    public void setPersonPersonas(List<PersonPersona> personPersonas) {
        this.personPersonas = personPersonas;
    }
}