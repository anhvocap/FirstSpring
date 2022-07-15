package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.ITagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TagTest {
    @Autowired
    private ITagRepository tagRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void test() throws Exception {
        Tag tag = tagRepository.getById(1L);

        assertNotNull(tag);
        assertEquals(1, tag.getTagId());
    }

    @Test
    public void testList() throws Exception {
        List<Tag> tags = tagRepository.findAll();

        assertNotNull(tags);
        assert(tags.size()) >= 0;
    }
}
