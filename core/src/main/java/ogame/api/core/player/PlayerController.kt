package ogame.api.core.player

class PlayerController(private val playerProvider: PlayerProvider) {

    fun getPlayer(id: String) = playerProvider.getPlayer(id)
}