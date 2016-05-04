package ogame.api.scrape.player.dto;

import org.simpleframework.xml.Attribute;

public class PositionXml {

    @Attribute(name = "type")
    public String type;

    @Attribute(name = "score")
    public String score;
}
