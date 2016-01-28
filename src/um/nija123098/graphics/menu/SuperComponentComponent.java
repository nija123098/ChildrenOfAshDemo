package um.nija123098.graphics.menu;

import um.nija123098.graphics.hypotheticalgraphicslib.componaent.Component;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.ComponentComponent;

/**
 * Created by Student on 1/28/2016.
 */
public class SuperComponentComponent extends ComponentComponent{
    public SuperComponentComponent(int x, int y, Component... subComponents) {
        super(x, y, subComponents);
    }
    @Override
    public void visible(boolean visible){
        for (Component component : this.subComponents) {
            component.visible(true);
        }
    }
    @Override
    public void active(boolean active){
        for (Component component : this.subComponents) {
            component.active(active);
        }
    }
}
