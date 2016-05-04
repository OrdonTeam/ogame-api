package ogame.api.core

class PlayerController(val playerProvider: PlayerProvider) {

    fun getPlayer(id: String) = playerProvider.getPlayer(id)
}