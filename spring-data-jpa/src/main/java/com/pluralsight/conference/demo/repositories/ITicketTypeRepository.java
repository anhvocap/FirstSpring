package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketTypeRepository extends JpaRepository<TicketType, Long> {
    List<TicketType> findByIncludesWorkshopTrue();
}
