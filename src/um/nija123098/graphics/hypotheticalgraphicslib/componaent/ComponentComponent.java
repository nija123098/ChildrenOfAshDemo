package um.nija123098.graphics.hypotheticalgraphicslib.componaent;

import um.nija123098.graphics.hypotheticalgraphicslib.ListensKeyboard;
import um.nija123098.graphics.hypotheticalgraphicslib.ListensMouse;
import um.nija123098.graphics.hypotheticalgraphicslib.exception.NonContainmentException;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.Graphic;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Made by Dev on 12/31/2015
 */
public class ComponentComponent extends Component implements ListensKeyboard, ListensMouse{
    public ArrayList<Component> subComponents;
    public ComponentComponent(int x, int y, Component...subComponents) {
        super(x, y);
        if (subComponents == null || subComponents.length == 0){
            throw new NonContainmentException();
        }
        this.subComponents = new ArrayList<Component>(subComponents.length);
        Collections.addAll(this.subComponents, subComponents);
        for (Component component : this.subComponents){
            component.higherComponent = this;
        }
    }
    public void tick(){
        this.subComponents.forEach(Component::tick);
    }
    public void update(){
        for (Component component : this.subComponents){
            if (component.active()){
                component.update();
            }
        }
    }
    @Override
    public void active(boolean active){
        super.active(active);
        for (Component component : this.subComponents){
            component.active(active);
        }
    }
    @Override
    public void visible(boolean visible){
        super.visible(visible);
        for (Component component : this.subComponents){
            component.visible(visible);
        }
    }
    @Override
    public int xLength(){
        int size = 0;//  0:x, 1:y
        for (Component component : this.subComponents){
            if (component.visible()){
                int tSize = component.getRelativeX() + component.xLength();
                if (tSize > size){
                    size = tSize;
                }
            }
        }
        return size;
    }
    @Override
    public int yLength(){
        int size = 0;//  0:x, 1:y
        for (Component component : this.subComponents){
            if (component.visible()){
                int tSize = component.getRelativeY() + component.yLength();
                if (tSize > size){
                    size = tSize;
                }
            }
        }
        return size;
    }
    @Override
    public Graphic getGraphic() {
        Graphic graphic = this.subComponents.get(0).getGraphic().clone();
        for (int i = 0; i < this.subComponents.size(); i++) {
            graphic.applyTo(this.subComponents.get(i).getRelativeX(), this.subComponents.get(i).getRelativeY(), this.subComponents.get(i).getGraphic());
        }
        return graphic;
        /*Color[][] graphic = new Color[this.xLength()][this.yLength()];
        for (Component component : this.subComponents){
            if (component.visible()){
                Graphic componentGraphic = component.getGraphic();
                if (componentGraphic != null){
                    for (int x = 0; x < componentGraphic.xLength(); x++) {
                        for (int y = 0; y < componentGraphic.yLength(); y++) {
                            if (componentGraphic.getArrayGraphic()[x][y] != null && component.getRelativeY() + x > -1 && component.getRelativeY() + y > -1 && component.getRelativeY() + x < graphic.length && component.getRelativeY() + y < graphic[0].length){
                                graphic[component.getRelativeX() + x][component.getRelativeY() + y] = componentGraphic.getArrayGraphic()[x][y];
                            }
                        }
                    }
                }
            }
        }
        return new Graphic(graphic);*/
    }
    @Override
    public void mouseInComponent(int x, int y) {
        for (Component component : this.subComponents){
            if (component.componentLocated(x, y)){
                component.mouseInComponent(x, y);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensKeyboard && component.active()){
                ((ListensKeyboard) component).keyTyped(e);
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensKeyboard && component.active()){
                ((ListensKeyboard) component).keyPressed(e);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensKeyboard && component.active()){
                ((ListensKeyboard) component).keyReleased(e);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensMouse && component.active() && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mouseClicked(e);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensMouse && component.active() && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mousePressed(e);
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensMouse && component.active() && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mouseReleased(e);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensMouse && component.active()/* && component.componentLocated(e.getPoint())*/){
                ((ListensMouse) component).mouseEntered(e);
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (Component component : this.subComponents){
            if (component instanceof ListensMouse && component.active()/* && component.componentLocated(e.getPoint())*/){
                ((ListensMouse) component).mouseExited(e);
            }
        }
    }
    /*@Override
    public void mouseInComponent(int x, int y) {
        for (Component subComponent : this.subComponents){
            if (subComponent.componentLocated(x, y)){
                subComponent.mouseInComponent(x, y);
            }
        }
    }//*/
}
