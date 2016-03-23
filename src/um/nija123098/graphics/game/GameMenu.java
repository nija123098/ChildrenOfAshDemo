package um.nija123098.graphics.game;

import um.nija123098.game.elements.game.Game;
import um.nija123098.graphics.SuperComponentComponent;
import um.nija123098.graphics.game.field.Field;

/**
 * Created by Student on 1/28/2016.
 */
public class GameMenu extends SuperComponentComponent {
    public Game game;
    public Field field;
    //public Bar bar = new Bar();
    public GameMenu(Game game) {
        super(0, 0);
        this.game = game;
        this.field = new Field(game);
        this.subComponents.add(this.field);
        //this.subComponents.add(this.bar);
    }
}
