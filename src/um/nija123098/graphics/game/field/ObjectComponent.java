package um.nija123098.graphics.game.field;

import basicjavautillibrary.um.nija123098.graphics.componaent.FunctionalComponent;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 2/7/2016
 */
public class ObjectComponent extends FunctionalComponent{
    public DungeonObject object;
    public ObjectComponent(DungeonObject object) {
        super((int) object.location.location.getX(), (int) object.location.location.getY(), (int) object.structure.shape.getLength(), (int) object.structure.shape.getWidth());
        this.object = object;
    }
    @Override
    public void update(){
        this.relativeX = (int) object.location.location.getX();
        this.relativeY = (int) object.location.location.getY();
    }
}
