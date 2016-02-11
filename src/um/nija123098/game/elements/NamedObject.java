package um.nija123098.game.elements;

/**
 * Made by Dev on 12/26/2015
 */
public class NamedObject extends TrackedObject{
    public String name;
    private final String TRUE_NAME;
    public NamedObject(String name){
        this.TRUE_NAME = name;
        this.name = name;
    }
    public boolean isType(NamedObject namedObject){
        return this.TRUE_NAME.equals(namedObject.TRUE_NAME);
    }
}
