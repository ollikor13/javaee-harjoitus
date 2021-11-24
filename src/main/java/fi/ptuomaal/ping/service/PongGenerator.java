package fi.ptuomaal.ping.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class PongGenerator {

    /**
     * Tämä luokka näyttää alustavan dataa aloituksessa
     */

    @Inject
    PongService service;

    @Inject
    DemoService demoService;

    @PostConstruct
    public void init() {
        service.generateContent();
        demoService.generateContent();

    }
}
