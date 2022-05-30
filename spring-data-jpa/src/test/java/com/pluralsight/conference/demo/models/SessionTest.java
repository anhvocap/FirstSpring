package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SessionTest {
    @Autowired
    private ISessionRepository sessionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Session session = sessionRepository.getById(1L);

        assertNotNull(session);
        assertEquals(1, session.getSessionId());
    }

    @Test
    public void testList() throws Exception {
        List<Session> sessions = sessionRepository.findAll();

        assertNotNull(sessions);
        assertTrue(sessions.size() > 0);
    }

    /*@Test
    public void testListByNativeQuery() throws Exception {
        List<Session> sessions = sessionRepository.listByNativeQuery();

        assertTrue(sessions.size() > 0);
    }*/

    /*@Test
    public void testSessionsThatHaveName() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }*/

}
