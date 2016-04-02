package um.nija123098.graphics.game.field;

import basicjavautillibrary.um.nija123098.graphics.componaent.FunctionalComponent;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 2/7/2016
 */
public class ObjectComponent extends FunctionalComponent{
    public DungeonObject object;
    public ObjectComponent(DungeonObject object) {
        super((int) object.getLocation().location.getX(), (int) object.getLocation().location.getY(), (int) object.getShape().getLength(), (int) object.getShape().getWidth());
        this.object = object;
    }
    @Override
    public void update(){
        this.relativeX = (int) this.object.getLocation().location.getX();
        this.relativeY = (int) this.object.getLocation().location.getY();
    }
}
