package um.nija123098.game.elements.item;

import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.game.elements.locationed.packages.subs.ItemContactPackage;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class TestItem extends Item{
    public int life = 10;
    public TestItem(Location location) {
        super("Test", location);
    }
    @Override
    public void stompedOn(StompPackage stompPackage) {
        this.life -= 2;
    }
    @Override
    public boolean itemContacted(ItemContactPackage itemContactPackage) {
        return this.life > 5;
    }
    @Override
    public void methodContacted(ActionMethodContactPackage actionMethodContactPackage) {
        --this.life;
    }
}
