package um.nija123098.graphics.hypotheticalgraphicslib.componaent;

import um.nija123098.graphics.hypotheticalgraphicslib.graphic.Graphic;

/**
 * Made by Dev on 1/1/2016
 */
public class FunctionalComponent extends Component {
    public int xLength, yLength;
    public FunctionalComponent(int x, int y, int xLength, int yLength) {
        super(x, y);
        this.xLength = xLength;
        this.yLength = yLength;
    }
    @Override
    public int xLength(){
        return this.xLength;
    }
    @Override
    public int yLength(){
        return this.yLength;
    }
    @Override
    public void tick() {

    }
    @Override
    public void update() {
    }
    @Override
    public Graphic getGraphic() {
        return null;
    }
    @Override
    public void mouseInComponent(int x, int y) {

    }
}
