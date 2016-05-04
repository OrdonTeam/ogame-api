package ogame.api.scrape.player

import ogame.api.core.dto.Player
import ogame.api.core.player.PlayerProvider
import ogame.api.scrape.player.dto.PlayerDataXml
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

class ScrapingPlayerProvider : PlayerProvider {

    override fun getPlayer(uni: String, id: String): Player {
        return Retrofit.Builder()
                .baseUrl("https://$uni.ogame.gameforge.com")
                .client(OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(Api::class.java)
                .getPlayer(id).map(toPlayer).toBlocking().first()
    }

    val toPlayer: (PlayerDataXml) -> Player = { Player(it.id, it.name) }

    interface Api {
        @GET("/api/playerData.xml")
        fun getPlayer(@Query("id") id: String): Observable<PlayerDataXml>
    }
}