package ogame.api;

import ogame.api.core.dto.Player;
import ogame.api.core.player.PlayerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerEndpoint {

    @Autowired
    PlayerController playerController;

    @RequestMapping(value = "uni/{uni}/players/{id}", method = RequestMethod.GET)
    public Player players(@PathVariable("uni") String uni, @PathVariable("id") String id) {
        return playerController.getPlayer(uni, id);
    }
}
