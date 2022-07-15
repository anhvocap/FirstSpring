package com.pluralsight.conference.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pluralsight.conference.demo.models.*;
import javax.persistence.*;
import java.util.List;

@Repository
public class TicketPriceRepository {
    @Autowired
    private ITicketTypeRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public TicketPrice create(TicketPrice tp) {
        entityManager.persist(tp);
        entityManager.flush();
        return tp;
    }

    public TicketPrice update(TicketPrice tp) {
        tp = entityManager.merge(tp);
        entityManager.flush();
        return tp;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public TicketPrice find(Long id) {
        return entityManager.find(TicketPrice.class, id);
    }

    public List<TicketPrice> list() {
        return entityManager.createQuery("select t from TicketPrice t").getResultList();
    }
}
