package com.pluralsight.conference.demo.repositories;

import org.springframework.stereotype.Repository;
import com.pluralsight.conference.demo.models.Speaker;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SpeakerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Speaker create(Speaker speaker) {
        entityManager.persist(speaker);
        entityManager.flush();
        return speaker;
    }

    public Speaker update(Speaker speaker) {
        speaker = entityManager.merge(speaker);
        entityManager.flush();
        return speaker;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public Speaker find(Long id) {
        System.out.println("id:" + id);
        return entityManager.find(Speaker.class, id);
    }

    public List<Speaker> list() {
        return entityManager.createNativeQuery("SELECT s.* from Speakers s").getResultList();
    }
}
