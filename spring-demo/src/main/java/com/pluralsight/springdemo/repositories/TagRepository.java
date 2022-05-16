package com.pluralsight.springdemo.repositories;

import com.pluralsight.springdemo.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "SELECT * FROM Tags WHERE tag_id = tag_id", nativeQuery = true)
    Tag findItem(@Param("tag_id") long tag_id);
}
