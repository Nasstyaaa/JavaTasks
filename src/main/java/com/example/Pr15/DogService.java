package com.example.Pr15;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;
    public DogService(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public List<Dog> createRequest(String nameOfField) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Dog> dogCriteriaQuery = builder.createQuery(Dog.class);
        Root<Dog> root = dogCriteriaQuery.from(Dog.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(nameOfField)));
        TypedQuery<Dog> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public User getUserByDog(Long dogId) {
        return session.createQuery("from Dog where id = :id", Dog.class)
                .setParameter("id",dogId).getSingleResult().getUser();
    }

    @Transactional
    public List<Dog> getDogs() {
        List<Dog> dogs = session.createQuery("from Dog").getResultList();
        return dogs;
    }
}
