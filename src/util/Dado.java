package util;

import java.util.Random;

/**
 * @author GPT
 */
public class Dado {
    private static final Random RANDOM = new Random();

    public static int lancarDado() {
        return RANDOM.nextInt(20) + 1;
    }
}
