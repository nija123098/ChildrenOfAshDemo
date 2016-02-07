package um.nija123098.game.elements.structure;

import basicjavautillibrary.um.nija123098.math.geometry.Shape;
import um.nija123098.game.elements.Setting;
import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 1/31/2016
 */
public class Structure implements Tickable{
    public double temp;
    public double hardness;
    public double temper;// tolerance to heat
    public Shape shape;// does not use the location function, simply the general shape
    public DungeonObject object;
    public Structure(double temp, double hardness, double temper, Shape shape){
        this.temp = temp;
        this.hardness = hardness;
        this.temper = temper;
        this.shape = shape;
    }
    @Setting// should be half the desired vale because of double exchange of both object going to the other
    public static final int CONVECTION_CONSTANT = 5;
    @Override
    public void tick() {
        @Setting
        ArrayList<DungeonObject> objects = object.location.getNearObjects(5f, true);
        for (DungeonObject dungeonObject : objects){
            float factor = (float) Math.pow(this.object.location.getDistance(dungeonObject.location), -1);
            dungeonObject.structure.addTemp(this.temp / CONVECTION_CONSTANT * factor);
            this.addTemp(this.temp / CONVECTION_CONSTANT * factor);
        }
    }
    public void addTemp(double heat){
        this.temp += heat;
    }
}
