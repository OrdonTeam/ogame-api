package ogame.api.scrape.dto;

import ogame.api.Player;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "player")
public class PlayerXml {

    @Attribute(name = "id")
    public String id;

    @Attribute(name = "name")
    public String name;

    @Attribute(name = "status", required = false)
    public String status;

    @Attribute(name = "alliance", required = false)
    public String alliance;
}
