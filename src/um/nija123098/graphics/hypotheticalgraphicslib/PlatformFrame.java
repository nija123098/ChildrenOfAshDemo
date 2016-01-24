package um.nija123098.graphics.hypotheticalgraphicslib;

import um.nija123098.graphics.hypotheticalgraphicslib.graphic.ColoredShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Made by Dev on 12/31/2015
 */
public class PlatformFrame extends JComponent implements KeyListener, MouseListener{
    public PlatformThread platformThread;
    public Platform platform;
    public JFrame jFrame;
    public PlatformFrame(Platform platform, String name, int closeOperation, boolean resizeable, Dimension preferredSize){
        this.platform = platform;
        this.jFrame = new JFrame(name);
        this.jFrame.add(this);
        this.jFrame.setResizable(resizeable);
        this.setPreferredSize(preferredSize);
        this.jFrame.pack();
        this.jFrame.setDefaultCloseOperation(closeOperation);
        this.jFrame.setLocationRelativeTo(null);//  todo make a constructor parameter
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.platformThread = new PlatformThread(this.platform, 1);
    }
    /**
     * @param visible boolean, sets window visible
     */
    public void sVisible(boolean visible){
        this.jFrame.setVisible(visible);
    }
    @Override
    protected void paintComponent(Graphics g){
        ArrayList<ColoredShape> cs = platform.getGraphic().getShapes();
        for (int shape = 0; shape < cs.size(); shape++) {
            g.setColor(cs.get(shape).color);
            ((Graphics2D) g).fill(cs.get(shape).shape);
        }
    }
    /**
     * called by main loop
     */
    public void tick(){
        this.platform.tick();
        this.update();
    }
    /**
     * graphical update, never used as a tick
     */
    public void update(){
        this.platform.update();
        this.repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        this.platform.keyTyped(e);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        this.platform.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        this.platform.keyReleased(e);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.platform.mouseClicked(e);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        this.platform.mousePressed(e);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        this.platform.mouseReleased(e);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        this.platform.mouseEntered(e);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        this.platform.mouseExited(e);
    }
}
