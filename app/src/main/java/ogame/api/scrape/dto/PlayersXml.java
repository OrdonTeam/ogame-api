package ogame.api.scrape.dto;

import ogame.api.Player;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Root(name = "players")
public class PlayersXml {

    @Attribute(name = "noNamespaceSchemaLocation")
    public String noNamespaceSchemaLocation;

    @Attribute(name = "timestamp")
    public String timestamp;

    @Attribute(name = "serverId")
    public String serverId;

    @ElementList(name = "player", inline = true)
    public List<PlayerXml> playerXml;

}
