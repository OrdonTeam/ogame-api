package ogame.api.core.players

import ogame.api.core.dto.Player

interface PlayersProvider {
    fun getPlayers(): List<Player>
}