package um.nija123098;

import um.nija123098.graphics.hypotheticalgraphicslib.PlatformFrame;
import um.nija123098.graphics.menu.Frame;

public class Main {
    public static void main(String[] args) {
	// write your code here, duh
        PlatformFrame platformFrame = new Frame();
        //*
        while (true){
            platformFrame.tick();
            platformFrame.update();
        }
    }
}
