package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketPriceRepository extends JpaRepository<TicketPrice, Long> {
}
