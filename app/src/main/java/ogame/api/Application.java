package ogame.api;

import ogame.api.cache.CachedPlayerProvider;
import ogame.api.cache.CachedPlayersProvider;
import ogame.api.core.player.PlayerController;
import ogame.api.core.players.PlayersController;
import ogame.api.core.players.SearchPlayersController;
import ogame.api.scrape.player.ScrapingPlayerProvider;
import ogame.api.scrape.players.ScrapingPlayersProvider;
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
        return new PlayerController(new CachedPlayerProvider(new ScrapingPlayerProvider()));
    }

    @Bean
    public PlayersController playersController() {
        return new PlayersController(new CachedPlayersProvider(new ScrapingPlayersProvider()));
    }

    @Bean
    public SearchPlayersController searchPlayersController(PlayersController playersController) {
        return new SearchPlayersController(playersController);
    }
}
