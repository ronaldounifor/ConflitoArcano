package util;

import java.util.Random;

/**
 * @author GPT
 */
public class Dado {
    private final Random RANDOM = new Random();
    private static Dado dado;

    private Dado() {}

    public int lancarDado(int faces) {
        return RANDOM.nextInt(faces) + 1;
    }

    public static synchronized Dado getInstancia() {
        if(dado != null)
            dado = new Dado();

        return dado;
    }

}
