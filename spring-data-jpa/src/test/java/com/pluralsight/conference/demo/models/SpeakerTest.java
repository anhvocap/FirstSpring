package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.ISpeakerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private ISpeakerRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getById(1L);

        assertNotNull(speaker);
        assertEquals(1, speaker.getSpeakerId());
    }

    @Test
    public void testList() throws Exception {
        List<Speaker> speakers = repository.findAll();

        assertNotNull(speakers);
        assert(speakers.size()) >= 1;
    }

    @Test
    public void testDslQueryAnd() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameAndLastName("James", "King");

        assertNotNull(speakers);
        assert(speakers.size()) >= 1;
    }

    @Test
    public void testDslQueryOr() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameOrLastName("James", "Duke");

        assertNotNull(speakers);
        assert(speakers.size()) >= 2;
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setCompany("Pluralsight");
        s.setSpeakerBio("Consulting and mentoring");
        Speaker s1 = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getOne(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.deleteById(otherSpeaker.getSpeakerId());
    }
}
