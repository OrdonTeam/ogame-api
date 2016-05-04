package ogame.api;

import ogame.api.core.PlayerController;
import ogame.api.scrape.player.ScrapingPlayerProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public PlayerController playerController() {
        return new PlayerController(new ScrapingPlayerProvider());
    }
}
