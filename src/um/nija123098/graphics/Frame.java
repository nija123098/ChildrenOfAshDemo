package um.nija123098.graphics;

import basicjavautillibrary.um.nija123098.graphics.PlatformFrame;
import um.nija123098.Ref;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Student on 1/28/2016.
 */
public class Frame extends PlatformFrame {
    public Frame() {
        super(new ThisPlatform(), Ref.PROGRAM_NAME, WindowConstants.EXIT_ON_CLOSE, false, new Dimension(600, 600));
    }
}
