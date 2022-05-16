package com.pluralsight.springdemo.repositories;

import com.pluralsight.springdemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
