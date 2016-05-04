package ogame.api.scrape.player.dto;

import org.simpleframework.xml.Attribute;

public class PlanetXml {

    @Attribute(name = "id")
    public String id;

    @Attribute(name = "name")
    public String name;

    @Attribute(name = "coords")
    public String coords;
}
