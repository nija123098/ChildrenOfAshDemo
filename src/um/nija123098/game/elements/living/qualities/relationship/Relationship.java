package um.nija123098.game.elements.living.qualities.relationship;

/**
 * Made by Dev on 2/13/2016
 */
public class Relationship {
    public int favor;// todo, and, ya know, figure out
    public Party them;
    public Relationship(Party them){
        this.them = them;
    }
    public int getFavor(){
        return this.favor;
    }
    /*
     * v/ So, they have to be between 2 parties
     *
     * v/ And they have to be one sided, so a
     * party can like the other, but not
     * necessarily vice versa
     *
     * v/ And favor range
     *
     * And access levels for npc to other relationships
     */
}
