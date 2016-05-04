package ogame.api;

import ogame.api.core.dto.Player;
import ogame.api.core.players.PlayersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayersEndpoint {

    @Autowired
    PlayersController playersController;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> players() {
        return playersController.getPlayers();
    }
}
