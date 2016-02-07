package um.nija123098.graphics;

import basicjavautillibrary.um.nija123098.graphics.Platform;
import um.nija123098.game.elements.game.Game;
import um.nija123098.graphics.game.GameMenu;
import um.nija123098.graphics.main.MainMenu;
import um.nija123098.graphics.past.PastMenu;

/**
 * Created by Student on 1/28/2016.
 */
public class ThisPlatform extends Platform {
    public ThisPlatform(){
        super(mainMenu, gameMenu, pastMenu);
    }
    public static Game game;
    public static MainMenu mainMenu = new MainMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static PastMenu pastMenu = new PastMenu();
}
