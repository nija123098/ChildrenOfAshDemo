package um.nija123098.graphics.hypotheticalgraphicslib.graphic;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Made by Dev on 12/30/2015
 */
public abstract class Graphic implements Cloneable{
    public Graphic(){

    }
    public abstract void applyTo(int x, int y, Graphic graphic);
    public abstract Color[][] getArrayGraphic();
    public abstract ArrayList<ColoredShape> getShapes();
    public abstract int xLength();
    public abstract int yLength();
    @Override
    public Graphic clone(){
        try {
            return (Graphic) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    /*public void yFlip(){
        for(int i = 0; i < this.graphic.length / 2; i++){
            Color[] temp = this.graphic[i];
            this.graphic[i] = this.graphic[this.graphic.length - i - 1];
            this.graphic[this.graphic.length - i - 1] = temp;
        }
    }
    public void xFlip(){
        for (int x = 0; x < this.graphic.length; x++) {
            for(int i = 0; i < this.graphic.length / 2; i++){
                Color temp = this.graphic[x][i];
                this.graphic[i] = this.graphic[this.graphic.length - i - 1];
                this.graphic[x][this.graphic.length - i - 1] = temp;
            }
        }
    }
    public void yxFlip(){
        this.xFlip();
        this.yFlip();
    }//*/
}
