package um.nija123098.graphics.hypotheticalgraphicslib.componaent;

import um.nija123098.graphics.hypotheticalgraphicslib.graphic.Graphic;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.GraphicOriented;

import java.awt.*;

/**
 * Made by Dev on 12/30/2015
 */
public abstract class Component implements GraphicOriented {
    public Component higherComponent;
    private int relativeX, relativeY;
    private Status status;
    public Component(int relativeX, int relativeY){
        this.status = new Status();
        this.relativeX = relativeX;
        this.relativeY = relativeY;
    }
    public int getRealX(){
        return this.higherComponent != null ? this.relativeX + this.higherComponent.getRealX() : this.relativeX;
    }
    public int getRelativeX(){
        return this.relativeX;
    }
    public int getRealY(){
        return this.higherComponent != null ? this.relativeY + this.higherComponent.getRealY() : this.relativeY;
    }
    public int getRelativeY(){
        return this.relativeY;
    }
    public void visible(boolean visible){
        this.status.visible = visible;
    }
    public boolean visible(){
        return this.active() && this.status.visible;
    }
    public void active(boolean active){
        this.status.active = active;
    }
    public boolean active(){
        return this.status.active;
    }
    public boolean componentLocated(Point point){
        return this.componentLocated(point.x, point.y);
    }
    public boolean componentLocated(int x, int y){
        return this.getRealX() <= x && this.xLength() + this.getRealX() >= x && this.getRealY() <= y && this.yLength() + this.getRealY() >= y;
    }
    public int xLength(){
        Graphic graphic = this.getGraphic();
        if (graphic != null){
            return graphic.yLength();
        }
        return 0;
    }
    public int yLength(){
        Graphic graphic = this.getGraphic();
        if (graphic != null){
            return graphic.yLength();
        }
        return 0;
    }
    public abstract void tick();
    public abstract void update();
    public abstract Graphic getGraphic();
    public abstract void mouseInComponent(int x, int y);
}
