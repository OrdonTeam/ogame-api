package ogame.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public Iterable<Player> players() {
        return playerRepository.findAll();
    }
}
