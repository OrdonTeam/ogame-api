package ogame.api.core.player

class PlayerController(private val playerProvider: PlayerProvider) {

    fun getPlayer(uni: String, id: String) = playerProvider.getPlayer(uni, id)
}