package um.nija123098.graphics.hypotheticalgraphicslib.componaent;

import um.nija123098.graphics.hypotheticalgraphicslib.graphic.ColoredShape;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.Graphic;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.ShapeBasedGraphic;

import java.awt.*;

/**
 * Made by Dev on 12/31/2015
 */
public class GraphicComponent extends Component {
    public Graphic graphic;
    public GraphicComponent(int x, int y, Graphic graphic) {
        super(x, y);
        this.graphic = graphic;
    }
    public GraphicComponent(int x, int y, int xLength, int yLength, Color colorFill){
        this(x, y, null);
        this.graphic = new ShapeBasedGraphic(new ColoredShape(new Rectangle(x, y, xLength, yLength), colorFill));
    }
    @Override
    public void tick() {
    }
    @Override
    public void update() {
    }
    @Override
    public Graphic getGraphic() {
        return this.graphic;
    }
    @Override
    public void mouseInComponent(int x, int y) {
    }
}
