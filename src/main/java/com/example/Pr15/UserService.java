package com.example.Pr15;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init(){
        session = sessionFactory.openSession();
    }
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Transactional
    public List<User> getUsers() {
        List<User> users = session.createQuery("from User").getResultList();
        System.out.println(users);
        return users;
    }

    public List<User> createRequest(String nameOfField) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).orderBy(builder.asc(root.get(nameOfField)));
        TypedQuery<User> query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }
}