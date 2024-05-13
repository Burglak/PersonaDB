package com.example.personadb;

import com.example.personadb.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Database {
    private SessionFactory sessionFactory;
    private static Session session;
    private static Person person;

    public Database(){
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Affinity.class);
        cfg.addAnnotatedClass(Persona.class);
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(PersonaAffinity.class);
        cfg.addAnnotatedClass(PersonPersona.class);
        cfg.addAnnotatedClass(PersonPersonaSkill.class);
        cfg.addAnnotatedClass(Skill.class);

        sessionFactory = cfg.buildSessionFactory();

        session = sessionFactory.openSession();

    }

    private void closeSession() {
        session.close();
    }

    private void closeSessionFactory() {
        sessionFactory.close();
    }

    public static boolean registerPerson(Person person) {
        List<Person> personList = session.createQuery("FROM Person WHERE login = '" + person.getLogin() + "'").list();
        if(personList.size() > 0){
            return false;
        }
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        return true;
    }

    public static void updatePerson(Person person){
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
    }

    public static boolean loginPerson(Person person) {
        session.beginTransaction();
        List<Person> persons = session.createQuery("FROM Person WHERE login = '" + person.getLogin() + "' AND password = '" + person.getPassword() + "'").list();
        session.getTransaction().commit();
        if (persons.size() > 0) {
            person = persons.get(0);
            Database.person = person;
            return true;
        }
        return false;
    }

    public static Person getPerson(){
        return person;
    }
}
