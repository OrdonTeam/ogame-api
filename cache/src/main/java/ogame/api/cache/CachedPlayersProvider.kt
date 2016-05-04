package ogame.api.cache

import ogame.api.core.dto.Player
import ogame.api.core.players.PlayersProvider
import java.util.*

class CachedPlayersProvider(private val playersProvider: PlayersProvider) : PlayersProvider {

    val map = HashMap<String, List<Player>>()

    override fun getPlayers(uni: String) = map.getOrPut(uni, { playersProvider.getPlayers(uni) })
}