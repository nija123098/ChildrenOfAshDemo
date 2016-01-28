package um.nija123098.graphics.menu.game.bar;

import um.nija123098.graphics.menu.SuperComponentComponent;

/**
 * Created by Student on 1/28/2016.
 */
public class Bar extends SuperComponentComponent {
    public UserDisplay userDisplay = new UserDisplay();
    public ItemBar itemBar = new ItemBar();
    public MiniMap miniMap = new MiniMap();
    public ActionMethodBar actionMethodBar = new ActionMethodBar();
    public Bar() {
        super(400, 0/*, todo*/);
        this.subComponents.add(this.userDisplay);
        this.subComponents.add(this.itemBar);
        this.subComponents.add(this.miniMap);
        this.subComponents.add(this.actionMethodBar);
    }
}
