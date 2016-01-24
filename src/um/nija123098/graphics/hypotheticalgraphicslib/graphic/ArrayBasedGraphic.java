package um.nija123098.graphics.hypotheticalgraphicslib.graphic;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Made by Dev on 1/17/2016
 */
public class ArrayBasedGraphic extends Graphic{
    public Color[][] graphic;
    public ArrayBasedGraphic(int sizeX, int sizeY){
        this.graphic = new Color[sizeX][sizeY];
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                this.graphic[x][y] = null;
            }
        }
    }
    public ArrayBasedGraphic(Color[][] graphic){
        this.graphic = graphic;
    }
    public void applyTo(int x, int y, Graphic graphic){
        Color[][] g = graphic.getArrayGraphic();
        for (int xR = x; xR < x + g.length; xR++) {
            System.arraycopy(g[xR - x], 0, this.graphic[xR], y, x + g.length - y);
        }
    }
    @Override
    public Color[][] getArrayGraphic() {
        return this.graphic;
    }
    @Override
    public ArrayList<ColoredShape> getShapes() {
        ArrayList<ColoredShape> coloredShapes = new ArrayList<ColoredShape>(this.graphic.length * 4);
        boolean[][] covered = new boolean[this.xLength()][this.yLength()];// can shorten out of xLength()
        for (int x = 0; x < this.graphic.length; x++) {
            for (int y = 0; y < this.graphic[0].length; y++) {
                covered[x][y] = this.graphic[x][y] != null;
            }
        }
        for (int x = 0; x < this.graphic.length; x++) {
            for (int y = 0; y < this.graphic[0].length; y++) {
                if (covered[x][y]){
                    int xLength = 0, yLength = 0;
                    for (int fx = x; fx < covered.length; fx++) {
                        if (!covered[fx][y] || this.graphic[x][y] != this.graphic[fx][y]){
                            break;
                        }
                        ++xLength;
                    }
                    if (xLength > 0){
                        relative:
                        for (int ry = y; ry < covered[0].length; ry++) {
                            for (int rx = x; rx < x + xLength; rx++) {
                                if (!covered[rx][ry] || this.graphic[rx][ry] != this.graphic[rx][ry]){
                                    break relative;
                                }
                            }
                            ++yLength;
                        }
                        if (yLength > 0){
                            ColoredShape coloredShape = new ColoredShape(new Rectangle(x, y, xLength, yLength), this.graphic[x][y]);
                            coloredShapes.add(coloredShape);
                            for (int cx = (int) coloredShape.shape.getBounds().getX(); cx < (int) coloredShape.shape.getBounds().getX() + coloredShape.shape.getBounds().getHeight(); cx++) {
                                for (int cy = (int) coloredShape.shape.getBounds().getY(); cy < (int) coloredShape.shape.getBounds().getY() + coloredShape.shape.getBounds().getWidth(); cy++) {
                                    covered[x][y] = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return coloredShapes;
    }
    @Override
    public int xLength() {
        return this.graphic.length;
    }
    @Override
    public int yLength() {
        return this.graphic[0].length;
    }
}
