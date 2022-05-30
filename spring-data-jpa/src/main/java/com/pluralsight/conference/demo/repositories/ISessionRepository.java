package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessionRepository extends JpaRepository<Session, Long> {
}
