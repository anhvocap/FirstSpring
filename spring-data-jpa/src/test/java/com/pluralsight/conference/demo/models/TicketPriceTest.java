package com.pluralsight.conference.demo.models;

import com.pluralsight.conference.demo.repositories.ITicketPriceRepository;
import com.pluralsight.conference.demo.repositories.PricingCategoryRepository;
import com.pluralsight.conference.demo.repositories.TicketTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TicketPriceTest {
    @Autowired
    private ITicketPriceRepository tpRepository;

    @Autowired
    private PricingCategoryRepository pcRepository;

    @Autowired
    private TicketTypeRepository ttRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        TicketPrice ticket = tpRepository.getById(1L);
        assertNotNull(ticket);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        TicketPrice tp = new TicketPrice();
        tp.setBasePrice(BigDecimal.valueOf(200, 2));

        tp.setPricingCategory(pcRepository.find("E"));

        tp.setTicketType(ttRepository.find("C"));

        tp = tpRepository.saveAndFlush(tp);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        TicketPrice otherTp = tpRepository.getById(tp.getTicketPriceId());
        assertEquals(BigDecimal.valueOf(200, 2).floatValue(), otherTp.getBasePrice().floatValue());

        tpRepository.deleteById(otherTp.getTicketPriceId());
    }
}
