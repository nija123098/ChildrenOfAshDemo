package um.nija123098.game;

import um.nija123098.game.elements.game.Game;

/**
 * Made by Dev on 12/10/2015
 */
public class GameMain {
    public static boolean run = true;
    public static void loop(Game game){
        while (run){
            game.player.tick();
            game.dungeon.tick();
        }
    }
}
