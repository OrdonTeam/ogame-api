package ogame.api.scrape.players

import ogame.api.core.dto.Player
import ogame.api.core.players.PlayersProvider
import ogame.api.scrape.players.dto.PlayersXml
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import rx.Observable

class ScrapingPlayersProvider : PlayersProvider {

    override fun getPlayers(uni: String) = Retrofit.Builder()
            .baseUrl("https://$uni.ogame.gameforge.com")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(Api::class.java).getPlayers().map(function).toBlocking().first()

    private val function: (PlayersXml) -> List<Player> = { players ->
        players.players.map { Player(it.id, it.name) }
    }

    interface Api {
        @GET("/api/players.xml")
        fun getPlayers(): Observable<PlayersXml>
    }
}
