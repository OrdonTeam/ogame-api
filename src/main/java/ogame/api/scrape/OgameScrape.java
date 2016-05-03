package ogame.api.scrape;

import ogame.api.Player;
import ogame.api.PlayerRepository;
import ogame.api.scrape.dto.PlayerXml;
import ogame.api.scrape.dto.PlayersXml;
import okhttp3.OkHttpClient;
import org.springframework.boot.CommandLineRunner;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

import java.util.stream.Collectors;

public class OgameScrape implements CommandLineRunner {

    private PlayerRepository repository;

    public OgameScrape(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        new Retrofit.Builder()
                .baseUrl("https://s670-en.ogame.gameforge.com")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(OgameScrapeApi.class)
                .scrape()
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(PlayersXml playersXml) {
        System.out.println(playersXml);
        repository.save(playersXml.playerXml.stream().map(this::toPlayer).collect(Collectors.toList()));
    }


    public Player toPlayer(PlayerXml playerXml) {
        return new Player(playerXml.id, playerXml.name);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    interface OgameScrapeApi {
        @GET("/api/players.xml")
        Observable<PlayersXml> scrape();
    }
}
