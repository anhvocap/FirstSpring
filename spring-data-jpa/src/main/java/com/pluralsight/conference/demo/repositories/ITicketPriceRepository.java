package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ITicketPriceRepository extends JpaRepository<TicketPrice, Long> {
    @Query("select tp from TicketPrice tp where tp.BasePrice < ?1 and tp.TicketType.includesWorkshop = true")
    List<TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);
}
