package ogame.api.scrape.players;

import ogame.api.scrape.players.dto.PlayersXml;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public class OgameScrape {

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
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    interface OgameScrapeApi {
        @GET("/api/players.xml")
        Observable<PlayersXml> scrape();
    }
}
