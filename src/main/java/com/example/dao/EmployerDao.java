package com.example.dao;

import com.example.entity.Employer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class EmployerDao {
    private static final Logger log = LoggerFactory.getLogger(EmployerDao.class);

    @PersistenceContext
    private EntityManager em;


    public void save(Employer employer) {
        log.info("Save is called: {}", employer.getId());
        if (em.find(Employer.class, employer.getId()) == null) {
            em.persist(employer);
        } else {
            em.merge(employer);
        }
        em.flush();
    }

    public Optional<Employer> find(Integer id) {
        return Optional.of(em.find(Employer.class, id));
    }
}
