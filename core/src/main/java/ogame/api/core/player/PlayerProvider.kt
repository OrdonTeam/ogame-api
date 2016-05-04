package ogame.api.core.player

import ogame.api.core.dto.Player

interface PlayerProvider {
    fun getPlayer(id: String): Player
}