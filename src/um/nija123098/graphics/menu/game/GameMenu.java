package um.nija123098.graphics.menu.game;

import um.nija123098.graphics.menu.SuperComponentComponent;
import um.nija123098.graphics.menu.game.bar.Bar;
import um.nija123098.graphics.menu.game.field.Field;

/**
 * Created by Student on 1/28/2016.
 */
public class GameMenu extends SuperComponentComponent {
    public Field field = new Field();
    public Bar bar = new Bar();
    public GameMenu() {
        super(0, 0);
        this.subComponents.add(this.field);
        this.subComponents.add(this.bar);
    }
}
