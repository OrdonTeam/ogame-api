package ogame.api.scrape.player.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "playerData")
public class PlayerDataXml {

    @Attribute(name = "id")
    public String id;

    @Attribute(name = "name")
    public String name;

    @Attribute(name = "noNamespaceSchemaLocation")
    public String noNamespaceSchemaLocation;

    @Attribute(name = "timestamp")
    public String timestamp;

    @Attribute(name = "serverId")
    public String serverId;

    @ElementList(name = "positions", required = false)
    public List<PositionXml> positions;

    @ElementList(name = "planets", required = false)
    public List<PlanetXml> planets;

    @Element(name = "alliance", required = false)
    public AllianceXml alliance;
}
