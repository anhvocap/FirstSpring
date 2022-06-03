package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Session;
import com.pluralsight.conference.demo.models.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TagRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public TagRepository () {
    }

    public List<Tag> list() {
        List<Tag> tags = entityManager.createNativeQuery("select t.* from Tag t").getResultList();
        return tags;
    }
}
