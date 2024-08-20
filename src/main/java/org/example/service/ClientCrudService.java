package org.example.service;

import org.example.config.HibernateUtil;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Optional;

import java.util.List;


public class ClientCrudService {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void createClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    public Optional<Client> getClient(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Client.class, id));
        }
    }

    public List<Client> getAllClients() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client",Client.class).list();
        }
    }

    public void updateClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }

    public void deleteClient(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Client client = session.find(Client.class, id);
            if (client != null) {
                session.remove(client);
            }
            tx.commit();
        }
    }
}
