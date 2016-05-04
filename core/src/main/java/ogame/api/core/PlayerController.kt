package ogame.api.core

class PlayerController(private val playerProvider: PlayerProvider) {

    fun getPlayer(id: String) = playerProvider.getPlayer(id)
}