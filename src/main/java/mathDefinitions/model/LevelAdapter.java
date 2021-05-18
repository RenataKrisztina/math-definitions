package mathDefinitions.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LevelAdapter extends XmlAdapter<String, Level> {
    @Override
    public Level unmarshal(String s) throws Exception {
        return null;    //????????
    }

    @Override
    public String marshal(Level level) throws Exception {
        return level.toString();
    }
}
