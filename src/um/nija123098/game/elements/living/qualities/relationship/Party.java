package um.nija123098.game.elements.living.qualities.relationship;

import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Created by Student on 2/17/2016.
 */
interface Party {
    boolean isFaction();
    boolean isMember(DungeonObject object);
    boolean isRepresentative(DungeonObject object);
}
