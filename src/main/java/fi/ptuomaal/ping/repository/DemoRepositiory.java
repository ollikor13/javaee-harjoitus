package fi.ptuomaal.ping.repository;

import fi.ptuomaal.ping.entity.DemoEntity;
import fi.ptuomaal.ping.entity.Pong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class DemoRepositiory {
    @PersistenceContext(unitName="ping")
    EntityManager entityManager;

    public List<DemoEntity> findByName(String name) {
        List<DemoEntity> results = entityManager.createNamedQuery(DemoEntity.NAMED_QUERY_FIND_BY_NAME).setParameter("name", name).getResultList();
        return results;
    }

    public List<DemoEntity> getAll() {
        List<DemoEntity> results = entityManager.createNamedQuery(Pong.NAMED_QUERY_GET_ALL).getResultList();

        return results;
    }

    public DemoEntity create(String name) {
        DemoEntity p = new DemoEntity();
        p.setName(name);
        entityManager.persist(p);
        return p;
    }



}

