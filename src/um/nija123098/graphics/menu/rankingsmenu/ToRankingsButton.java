package um.nija123098.graphics.menu.rankingsmenu;

import um.nija123098.graphics.hypotheticalgraphicslib.ListensMouse;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.FunctionalComponent;
import um.nija123098.graphics.menu.main.MainMenu;

import java.awt.event.MouseEvent;

/**
 * Made by Dev on 1/9/2016
 */
public class ToRankingsButton extends FunctionalComponent implements ListensMouse {
    public MainMenu mainMenu;
    public RankingsMenu rankingsMenu;

    public ToRankingsButton(int x, int y, int xLength, int yLength, MainMenu mainMenu, RankingsMenu rankingsMenu) {
        super(x, y, xLength, yLength);
        this.mainMenu = mainMenu;
        this.rankingsMenu = rankingsMenu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.mainMenu.visible(false);
        this.mainMenu.active(false);
        this.rankingsMenu.active(true);
        this.rankingsMenu.visible(true);
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
