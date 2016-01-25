package um.nija123098.game.elements.locationed;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.actionmethod.ActionMethodActivationPackage;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.game.elements.locationed.packages.subs.ThrowObjectPackage;
import um.nija123098.game.elements.locationed.packages.subs.WalkContactPackage;
import um.nija123098.resorce.Rand;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class DungeonObject extends NamedObject /*implements DegreeComparable<DungeonObject>*/{
    public int direction = Rand.getRand(359);
    public Location location;
    public DungeonObject(String name, Location location){
        super(name);
        this.location = location;
    }
    public void stompedOn(StompPackage stompPackage){// um

    }
    public void thrownContact(ThrowObjectPackage throwObjectPackage){// when this is thrown and collides with that

    }
    public boolean walkedContact(WalkContactPackage walkContactPackage){// when this is walked into
        return true;
    }
    public void methodContacted(ActionMethodContactPackage actionMethodContactPackage){// when this is attacked by that
        actionMethodContactPackage.actionMethod.effect(new ActionMethodActivationPackage(actionMethodContactPackage));
    }
}
