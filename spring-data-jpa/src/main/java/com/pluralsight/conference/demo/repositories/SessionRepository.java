package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Session;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
        entityManager.persist(session);
        entityManager.flush();
        return session;
    }

    public Session update(Session session) {
        session = entityManager.merge(session);
        entityManager.flush();
        return session;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public Session find(Long id) {
        return entityManager.find(Session.class, id);
    }

    public List<Session> list() {
        return entityManager.createNativeQuery("SELECT * FROM Sessions").getResultList();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        //System.out.println("name:" + name);
        List<Session> ses = entityManager
                .createNativeQuery("SELECT * FROM Sessions s WHERE UPPER(s.session_name) LIKE UPPER(:name)")
                .setParameter("name", "%" + name + "%").getResultList();
        return ses;
    }
}
