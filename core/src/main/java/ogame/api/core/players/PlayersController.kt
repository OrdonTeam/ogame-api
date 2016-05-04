package ogame.api.core.players

class PlayersController(private val playersProvider: PlayersProvider) {

    fun getPlayers(uni: String) = playersProvider.getPlayers(uni)
}