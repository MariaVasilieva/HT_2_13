package org.example.service;

import org.example.config.HibernateUtil;
import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PlanetCrudService {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void createPlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }

    public Optional<Planet> getPlanet(String id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Planet.class, id));
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet",Planet.class).list();
        }
    }

    public void updatePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }

    public void deletePlanet(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Planet planet = session.find(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
            }
            tx.commit();
        }
    }
}
