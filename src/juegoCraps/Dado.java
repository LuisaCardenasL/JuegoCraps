package juegoCraps;

import java.util.Random;

/**
 * Class Dado genera un número random entre 1 y 6
 * @autor Luisa Cardenas
 * @Version v.1.0.0 date 5/12/2021
 */
public class Dado {
    private int cara;

    /**
     * Este metodo genera un numero random para el valor de la cara
     * @return numero entre (1,6)
     */
    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
