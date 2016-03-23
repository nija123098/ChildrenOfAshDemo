package um.nija123098.graphics.game.field;

import basicjavautillibrary.um.nija123098.math.geometry.Point;
import um.nija123098.game.elements.game.Game;
import um.nija123098.graphics.SuperComponentComponent;

/**
 * Created by Student on 1/28/2016.
 */
public class Field extends SuperComponentComponent {
    public Game game;
    public Point viewPoint;
    public Field(Game game) {
        super(0, 0);
        this.game = game;
    }
    @Override
    public void tick(){
        super.tick();
    }
}
