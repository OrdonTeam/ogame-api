package ogame.api.core.players

import ogame.api.core.players.PlayersController

class SearchPlayersController(private val playersController: PlayersController) {

    fun getPlayers(uni: String, query: String) = playersController.getPlayers(uni).filter { it.name.contains(query, true) }
}