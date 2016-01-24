package um.nija123098.graphics.menu.game;

import um.nija123098.graphics.hypotheticalgraphicslib.ListensMouse;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.FunctionalComponent;
import um.nija123098.graphics.menu.main.MainMenu;

import java.awt.event.MouseEvent;

/**
 * Made by Dev on 1/2/2016
 */
public class ToGameButton extends FunctionalComponent implements ListensMouse {
    public MainMenu mainMenu;
    public GameMenu gameMenu;
    public ToGameButton(int x, int y, int xLength, int yLength, MainMenu mainMenu, GameMenu gameMenu) {
        super(x, y, xLength, yLength);
        this.mainMenu = mainMenu;
        this.gameMenu = gameMenu;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.mainMenu.visible(false);
        this.mainMenu.active(false);
        this.gameMenu.active(true);
        this.gameMenu.visible(true);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
