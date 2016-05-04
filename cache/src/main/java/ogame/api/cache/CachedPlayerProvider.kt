package ogame.api.cache

import ogame.api.core.dto.Player
import ogame.api.core.player.PlayerProvider
import ogame.api.core.players.PlayersProvider
import java.util.*

class CachedPlayerProvider(private val playerProvider: PlayerProvider) : PlayerProvider {

    val map = HashMap<Pair<String, String>, Player>()

    override fun getPlayer(uni: String, id: String) = map.getOrPut(uni to id, { playerProvider.getPlayer(uni, id) })
}