package ogame.api.scrape.players

import ogame.api.scrape.players.dto.PlayersXml
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import rx.Observable

class OgameScrape {

    val api = Retrofit.Builder()
            .baseUrl("https://s670-en.ogame.gameforge.com")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(Api::class.java)

    fun getPlayers() = api.getPlayers().toBlocking().first()

    interface Api {
        @GET("/api/players.xml")
        fun getPlayers(): Observable<PlayersXml>
    }
}
