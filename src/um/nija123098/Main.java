package um.nija123098;

import basicjavautillibrary.um.nija123098.graphics.PlatformFrame;
import um.nija123098.graphics.Frame;

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
