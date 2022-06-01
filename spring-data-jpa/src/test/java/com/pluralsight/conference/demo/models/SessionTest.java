package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository sessionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Session session = sessionRepository.find(1L);

        assertNotNull(session);
        assertEquals(1, session.getSessionId());
    }

    @Test
    public void testList() throws Exception {
        List<Session> sessions = sessionRepository.list();

        assertNotNull(sessions);
        assertTrue(sessions.size() > 0);
    }

    /*@Test
    public void testSessionsThatHaveName() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }*/

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Session s1 = new Session();
        s1.setSessionName("Meeting 2022");
        s1.setSessionDescription("Preparation Meeting in 2022");
        s1.setSessionLength(65);
        s1 = sessionRepository.create(s1);

        entityManager.clear();

        Session s2 = sessionRepository.find(s1.getSessionId());
        assertEquals("Meeting 2022", s2.getSessionName());

        sessionRepository.delete(s2.getSessionId());
    }
}
