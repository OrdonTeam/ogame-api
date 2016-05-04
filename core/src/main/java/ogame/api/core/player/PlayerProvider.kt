package ogame.api.core.player

import ogame.api.core.dto.Player

interface PlayerProvider {
    fun getPlayer(uni: String, id: String): Player
}