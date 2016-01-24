package um.nija123098.resorce;

/**
 * Made by Dev on 12/16/2015
 */
public class Coordinate {
    public float x, y;
    public Coordinate(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Coordinate getCoord(Vec vec, float distance){
        return new Coordinate(this.x + vec.x, this.y + vec.y);
    }
}
