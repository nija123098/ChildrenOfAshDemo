package um.nija123098.game.elements.game;

import um.nija123098.game.elements.dungeon.Dungeon;
import um.nija123098.game.elements.living.Player;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Game{
    public Player player;
    public Dungeon dungeon;
    public Game(Dungeon dungeon, Player player){
        this.dungeon = dungeon;
        this.player = player;
    }
    @TestComponent
    public Game(){
        this.dungeon = new Dungeon();
        this.player = new Player(this.dungeon.levels.get(0).getSpawn());
    }

}
