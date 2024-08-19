package util;

import java.util.Random;

/**
 * @author GPT
 */
public class Dado {
    private static final Random RANDOM = new Random();

    // public static int lancarD20() {
    //     return RANDOM.nextInt(20) + 1;
    // }
    // public static int lancarD6() {
    //     return RANDOM.nextInt(6) + 1;
    // }
    public static int lancarDado(int faces) {
        return RANDOM.nextInt(faces) + 1;
    }
}
