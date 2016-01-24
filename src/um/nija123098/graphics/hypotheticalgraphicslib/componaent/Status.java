package um.nija123098.graphics.hypotheticalgraphicslib.componaent;

/**
 * Made by Dev on 1/17/2016
 */
public class Status {
    public boolean visible, active;
    public Status(boolean visible, boolean active){
        this.visible = visible;
        this.active = active;
    }
    public Status(){
        this(false, false);
    }
}
