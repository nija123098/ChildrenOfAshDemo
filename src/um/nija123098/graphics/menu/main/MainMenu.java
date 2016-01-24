package um.nija123098.graphics.menu.main;

import um.nija123098.graphics.hypotheticalgraphicslib.ListensMouse;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.ComponentComponent;
import um.nija123098.graphics.hypotheticalgraphicslib.componaent.GraphicComponent;
import um.nija123098.graphics.menu.game.GameMenu;
import um.nija123098.graphics.menu.game.ToGameButton;
import um.nija123098.graphics.menu.rankingsmenu.RankingsMenu;
import um.nija123098.graphics.menu.rankingsmenu.ToRankingsButton;

import java.awt.*;

/**
 * Made by Dev on 1/1/2016
 */
public class MainMenu extends ComponentComponent implements ListensMouse {
    public MainMenu(GameMenu gameMenu, RankingsMenu rankingsMenu) {
        super(150, 100, gameLogo,
                new ComponentComponent(50, 150, new GraphicComponent(0, 0, 200, 50, new Color(255, 0, 255)), new ToGameButton(0, 0, 200, 50, null, gameMenu)),
                new ComponentComponent(50, 250, new GraphicComponent(0, 0, 200, 50, new Color(255, 0, 255)), new ToRankingsButton(0, 0, 200, 50, null, rankingsMenu)));
        ((ToGameButton) ((ComponentComponent) this.subComponents.get(1)).subComponents.get(1)).mainMenu = this;
        ((ToRankingsButton) ((ComponentComponent) this.subComponents.get(2)).subComponents.get(1)).mainMenu = this;
    }
    /*@Override
    public void visible(boolean visible){
        super.visible(visible);
        for (Component component : this.subComponents){
            component.visible(visible);
        }
        for (Component component : ((ComponentComponent) this.subComponents.get(1)).subComponents){
            component.visible(visible);
        }
        for (Component component : ((ComponentComponent) this.subComponents.get(2)).subComponents){
            component.visible(visible);
        }
    }
    @Override
    public void active(boolean active){
        super.active(active);
        for (Component component : this.subComponents){
            component.active(active);
        }
        for (Component component : ((ComponentComponent) this.subComponents.get(1)).subComponents){
            component.active(active);
        }
        for (Component component : ((ComponentComponent) this.subComponents.get(2)).subComponents){
            component.active(active);
        }
    }//*/
    public static GraphicComponent gameLogo = new GraphicComponent(0, 0, 300, 100, new Color(0, 144, 255));
}
