package ogame.api.scrape.player.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class AllianceXml {

    @Attribute(name = "id")
    public String id;

    @Element(name = "name")
    public String name;

    @Element(name = "tag")
    public String tag;
}
