package ogame.api.core

interface PlayerProvider {
    fun getPlayer(id: String): Player
}