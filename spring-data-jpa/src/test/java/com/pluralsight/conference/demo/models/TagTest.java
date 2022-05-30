package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.SpeakerRepository;
import com.pluralsight.conference.demo.repositories.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TagTest {
    @Autowired
    private TagRepository tagRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testList() throws Exception {
        List<Tag> tags = tagRepository.list();
        System.out.println("tags:" + tags);
        assertNotNull(tags);
    }
}
