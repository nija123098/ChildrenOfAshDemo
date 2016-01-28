package um.nija123098.graphics.menu;

import um.nija123098.game.elements.game.Game;
import um.nija123098.graphics.hypotheticalgraphicslib.Platform;
import um.nija123098.graphics.menu.game.GameMenu;
import um.nija123098.graphics.menu.main.MainMenu;
import um.nija123098.graphics.menu.past.PastMenu;

/**
 * Created by Student on 1/28/2016.
 */
public class ThisPlatform extends Platform{
    public ThisPlatform(){
        super(mainMenu, gameMenu, pastMenu);
    }
    public static Game game;
    public static MainMenu mainMenu = new MainMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static PastMenu pastMenu = new PastMenu();
}
