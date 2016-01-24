package um.nija123098.graphics.hypotheticalgraphicslib;

import java.awt.*;

/**
 * Made by Dev on 1/8/2016
 */
public class PlatformThread extends Thread{
    public long timing;
    public Platform platform;
    public PlatformThread(Platform platform, long timing){
        this.platform = platform;
        this.timing = timing;
    }
    @Override
    public void run() {
        while (true){// todo correct;
            if (System.currentTimeMillis() % this.timing == 0){
                Point point = MouseInfo.getPointerInfo().getLocation();
                this.platform.componentInTick(point.x, point.y);
            }
        }
    }
}
