package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByDescriptionContains(String name);
}
