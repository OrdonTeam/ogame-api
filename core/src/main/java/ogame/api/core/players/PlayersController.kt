package ogame.api.core.players

class PlayersController(private val playersProvider: PlayersProvider) {

    fun getPlayers() = playersProvider.getPlayers()
}