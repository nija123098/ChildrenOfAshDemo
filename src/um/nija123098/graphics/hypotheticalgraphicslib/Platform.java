package um.nija123098.graphics.hypotheticalgraphicslib;

import um.nija123098.graphics.hypotheticalgraphicslib.componaent.Component;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.Graphic;
import um.nija123098.graphics.hypotheticalgraphicslib.graphic.GraphicOriented;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Made by Dev on 12/30/2015
 */
public class Platform implements GraphicOriented, ListensMouse, ListensKeyboard{
    public ArrayList<Component> components;
    public Platform(Component...components){
        this.components = new ArrayList<>(components.length);
        Collections.addAll(this.components, components);
        components[0].active(true);
        components[0].visible(true);
    }
    public int xLength(){
        int size = 0;//  0:x, 1:y
        for (Component component : this.components){
            if (component.visible()){
                int tSize = component.xLength();
                if (tSize > size){
                    size = tSize;
                }
            }
        }
        return size;
    }
    public int yLength(){
        int size = 0;//  0:x, 1:y
        for (Component component : this.components){
            if (component.visible()){
                int tSize = component.yLength();
                if (tSize > size){
                    size = tSize;
                }
            }
        }
        return size;
    }
    @Override
    public Graphic getGraphic(){
        Graphic graphic = this.components.get(0).getGraphic().clone();
        for (int i = 0; i < this.components.size(); i++) {
            graphic.applyTo(this.components.get(i).getRelativeX(), this.components.get(i).getRelativeY(), this.components.get(i).getGraphic());
        }
        return graphic;
        /*Color[][] graphic = new Color[this.xLength()][this.yLength()];
        for (Component component : this.components){
            if (component.visible()){
                Graphic componentGraphic = component.getGraphic();
                for (int x = 0; x < componentGraphic.graphic.length; x++) {
                    for (int y = 0; y < componentGraphic.graphic[0].length; y++) {
                        if (componentGraphic.graphic[x][y] != null && component.getRelativeY() + x > -1 && component.getRelativeY() + y > -1 && component.getRelativeY() + x < graphic.length && component.getRelativeY() + y < graphic[0].length){
                            graphic[component.getRelativeY() + x][component.getRelativeY() + y] = componentGraphic.graphic[x][y];
                        }
                    }
                }
            }
        }
        return new Graphic(graphic);*/
    }
    public void componentInTick(int x, int y){
        for (Component component : this.components){
            if (component.componentLocated(x, y)){
                component.mouseInComponent(x, y);
            }
        }
    }
    public void tick(){
        this.components.forEach(Component::tick);
    }
    public void update(){
        for (Component component : this.components){
            if (component.active()){
                component.update();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensKeyboard){
                ((ListensKeyboard) component).keyTyped(e);
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensKeyboard){
                ((ListensKeyboard) component).keyPressed(e);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensKeyboard){
                ((ListensKeyboard) component).keyReleased(e);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensMouse && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mouseClicked(e);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensMouse && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mousePressed(e);
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensMouse && component.componentLocated(e.getPoint())){
                ((ListensMouse) component).mouseReleased(e);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensMouse){
                ((ListensMouse) component).mouseEntered(e);
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (Component component : this.components){
            if (component instanceof ListensMouse){
                ((ListensMouse) component).mouseExited(e);
            }
        }
    }
}
