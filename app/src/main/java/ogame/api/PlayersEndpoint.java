package ogame.api;

import ogame.api.core.dto.Player;
import ogame.api.core.players.PlayersController;
import ogame.api.core.players.SearchPlayersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersEndpoint {

    @Autowired
    SearchPlayersController searchPlayersController;

    @RequestMapping(value = "uni/{uni}/players", method = RequestMethod.GET)
    public List<Player> players(@PathVariable("uni") String uni, @RequestParam(value = "query", defaultValue = "") String query) {
        return searchPlayersController.getPlayers(uni, query);
    }
}
