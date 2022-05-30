package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.SpeakerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.find(1L);
        assertNotNull(speaker);
    }

    @Test
    public void testList() throws Exception {
        List<Speaker> speakers = repository.list();
        assertNotNull(speakers);
    }

    @Test
    public void testListByNativeQuery() throws Exception {
        List<Speaker> speakers = repository.listByNativeQuery();
        assertNotNull(speakers);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = repository.create(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.find(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.delete(otherSpeaker.getSpeakerId());
    }
}
