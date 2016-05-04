package ogame.api;

import ogame.api.core.Player;
import ogame.api.core.PlayerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerEndpoint {

    @Autowired
    PlayerController playerController;

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
    public Player players(@PathVariable("id") String id) {
        return playerController.getPlayer(id);
    }
}
