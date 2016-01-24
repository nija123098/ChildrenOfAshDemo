package um.nija123098.graphics.menu.game;


import um.nija123098.game.elements.game.Game;
import um.nija123098.graphics.hypotheticalgraphicslib.ListensKeyboard;
import um.nija123098.graphics.hypotheticalgraphicslib.ListensMouse;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.ComponentComponent;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.GraphicComponent;

import java.awt.Color;

/**
 * Made by Dev on 1/2/2016
 */
public class GameMenu extends ComponentComponent implements ListensKeyboard, ListensMouse {
    public Game game;
    public GameMenu(Game game) {
        super(0, 0, bar, dungeon);
        this.game = game;
    }
    public static ComponentComponent bar = new ComponentComponent(0, 450, new GraphicComponent(0, 0, 100, 100, new Color(255, 111, 111)));
    // the fallowing are subbed to the above
    //public static ComponentComponent miniMap = new ComponentComponent(0, 450, null);


    public static ComponentComponent dungeon = new ComponentComponent(0, 0, new GraphicComponent(5, 7, 110, 150, new Color(55, 70, 99)));
    // the fallowing are subbed to the above
    //public static ComponentComponent floorMap = new ComponentComponent(0, 450, null);// todo complicate (make work)
    //public static ComponentComponent livingMap = new ComponentComponent(0, 450, null);
    //public static ComponentComponent objectMap = new ComponentComponent(0, 450, null);
}
