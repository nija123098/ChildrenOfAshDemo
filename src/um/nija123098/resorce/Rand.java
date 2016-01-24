package um.nija123098.resorce;

import java.util.Random;

/**
 * Made by Dev on 1/10/2016
 */
public class Rand {
    public static Random random;
    public static int getRand(int max){
        if (random == null){
            random = new Random();
        }
        return random.nextInt() % (max + 1);
    }
    public static int getRand(int min, int max){
        return getRand(max) + min;
    }
}
