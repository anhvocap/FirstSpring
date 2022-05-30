package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Session session = repository.find(1L);
        assertNotNull(session);
    }

    @Test
    public void testList() throws Exception {
        List<Session> sessions = repository.list();
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testListByNativeQuery() throws Exception {
        List<Session> sessions = repository.listByNativeQuery();
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testSessionsThatHaveName() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Session s = new Session();
    }
}
