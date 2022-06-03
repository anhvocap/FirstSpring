package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISessionRepository extends JpaRepository<Session, Long> {
    List<Session> findBySessionNameContains(String name);
    List<Session> findBySessionLengthNot(Integer length);
    List<Session> findBySessionNameNotLike(String name);
    List<Session> findBySessionLengthLessThanEqual(Integer length);

    Session findFirstBySessionNameContains(String name);
    Long countBySessionNameContains(String name);
}
