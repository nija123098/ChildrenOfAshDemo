package um.nija123098.graphics.hypotheticalgraphicslib.graphic;

import java.awt.*;
import java.util.ArrayList;

/**
 * Made by Dev on 1/17/2016
 */
public class ShapeBasedGraphic extends Graphic{
    public ArrayList<ColoredShape> coloredShapes;
    public ShapeBasedGraphic(ArrayList<ColoredShape> coloredShapes){
        this.coloredShapes = coloredShapes;
    }
    public ShapeBasedGraphic(ColoredShape coloredShape){
        this.coloredShapes = new ArrayList<ColoredShape>(1);
        this.coloredShapes.add(coloredShape);
    }
    @Override
    public void applyTo(int x, int y, Graphic graphic) {
        this.coloredShapes.addAll(graphic.getShapes());
    }
    @Override
    public Color[][] getArrayGraphic() {
        Color[][] graphic = new Color[this.xLength()][this.yLength()];
        for (int x = 0; x < graphic.length; x++) {
            for (int y = 0; y < graphic[0].length; y++) {
                for (int shape = 0; shape < this.coloredShapes.size(); shape++) {
                    if (this.coloredShapes.get(shape).shape.contains(x, y)){
                        graphic[x][y] = this.coloredShapes.get(shape).color;
                    }
                }
            }
        }
        return graphic;
    }
    @Override
    public ArrayList<ColoredShape> getShapes() {
        return this.coloredShapes;
    }
    @Override
    public int xLength() {
        int xLength = 0;
        for (ColoredShape coloredShape : this.coloredShapes){
            int x = (int) (coloredShape.shape.getBounds().getX() + coloredShape.shape.getBounds().getWidth());
            if (x > xLength){
                xLength = x;
            }
        }
        return xLength;
    }
    @Override
    public int yLength() {
        int yLength = 0;
        for (ColoredShape coloredShape : this.coloredShapes){
            int y = (int) (coloredShape.shape.getBounds().getY() + coloredShape.shape.getBounds().getHeight());
            if (y > yLength){
                yLength = y;
            }
        }
        return yLength;
    }
}
