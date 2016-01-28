package um.nija123098.graphics.menu;

import um.nija123098.Ref;
import um.nija123098.graphics.hypotheticalgraphicslib.PlatformFrame;

import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * Created by Student on 1/28/2016.
 */
public class Frame extends PlatformFrame{
    public Frame() {
        super(new ThisPlatform(), Ref.PROGRAM_NAME, WindowConstants.EXIT_ON_CLOSE, false, new Dimension(600, 600));
    }
}
