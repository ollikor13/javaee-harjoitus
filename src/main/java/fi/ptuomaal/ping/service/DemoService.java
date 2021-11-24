package fi.ptuomaal.ping.service;

import fi.ptuomaal.ping.entity.DemoEntity;
import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.repository.DemoRepositiory;
import fi.ptuomaal.ping.repository.PongRepository;

import javax.inject.Inject;
import java.util.List;

public class DemoService {

    @Inject
    DemoRepositiory repository;

    public List<DemoEntity> getDemoEntitiesByName(String name) {
        return repository.findByName(name);
    }

    public void generateContent() {
        if ( repository.getAll().isEmpty() ) {
            repository.create("Demo1");
            repository.create("Demo2");
            repository.create("Demo3");
        }
    }

    public List<DemoEntity> getAllEntities(){
        return  repository.getAll();
    }
}
