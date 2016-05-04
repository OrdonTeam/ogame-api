package ogame.api.scrape.players.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "players")
public class PlayersXml {

    @Attribute(name = "noNamespaceSchemaLocation")
    public String noNamespaceSchemaLocation;

    @Attribute(name = "timestamp")
    public String timestamp;

    @Attribute(name = "serverId")
    public String serverId;

    @ElementList(name = "player", inline = true)
    public List<PlayerXml> players;

}
