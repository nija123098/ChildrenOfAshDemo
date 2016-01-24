package um.nija123098.graphics.menu;

import um.nija123098.graphics.hypotheticalgraphicslib.Platform;
import um.nija123098.graphics.hypotheticalgraphicslib.PlatformFrame;
import um.nija123098.graphics.menu.game.GameMenu;
import um.nija123098.graphics.menu.main.MainMenu;
import um.nija123098.graphics.menu.rankingsmenu.RankingsMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Made by Dev on 1/10/2016
 */
public class Frame extends PlatformFrame {// todo make the enu manipulation better
    public static RankingsMenu rankingsMenu = new RankingsMenu();
    public static GameMenu gameMenu = new GameMenu(null);
    public static MainMenu mainMenu = new MainMenu(gameMenu, rankingsMenu);
    public Frame() {
        super(new Platform(mainMenu, gameMenu, rankingsMenu), "RPGRTSRL", WindowConstants.EXIT_ON_CLOSE, false, new Dimension(600, 600));
        this.sVisible(true);
    }
}
