package juegoCraps;

/**
 * ModelCraps aplica las reglas de craps.
 * estado = 1 Gana natural.
 * estado = 2 Perdio por Craps.
 * estado = 3 establecio punto.
 * estado = 4 Gano por punto.
 * estado = 5 Perdio por punto.
 * @autor = Luisa Cardenas
 * @version = v.1.0.0 date 6/12/2021
 */
public class ModelCraps {
    private Dado dado1, dado2;
    private int tiro, punto, estado, flag;
    private String estadoToString;
    private int[] caras;

    /**
     * Clase constructor
     */
    public ModelCraps(){
        dado1 = new Dado();
        dado2 = new Dado();
        caras = new int[2];
        flag = 0;
    }

    /**
     * Este metodo establece el valor del tiro, al valor de cada cara del dado.
     */
    public void calcularTiro(){
        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        tiro = caras[0]+caras[1];
    }

    /**
     * Establece el estado del juego, de acuerdo a lo que este en la variable estado
     * estado = 1 Gana natural.
     * estado = 2 Perdio por Craps.
     * estado = 3 establecio punto.
     * estado = 4 Gano por punto.
     * estado = 5 Perdio por punto.
     */
    public void determinarJuego(){
        if (flag==0){
            if(tiro==7 || tiro==11){
                estado = 1;
            }else{
                if(tiro==2 || tiro==3 || tiro==12){
                    estado = 2;
                }else{
                    estado = 3;
                    punto = tiro;
                    flag=1;
                }
            }
        }else{
            //ronda punto
        }
    }

    /**
     * Establece el estado del juego de acuerdo al valor del atributo estado.
     * estado = 4 Gana por punto.
     * estado = 2 Pierde por punto.
     */
    private void rondaPunto(){
        if(tiro==punto){
            estado = 4;
            flag = 0;
        }
        if(tiro==7){
            estado=5;
            flag=0;
        }
    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * Establece el mensaje del juego de acuerdo al valor que esta en el atributo estado
     * @return mensaje para la clase vista.
     */
    public String getEstadoToString() {
        switch(estado){
            case 1: estadoToString="Sacaste natural, ¡¡has ganado!!";
                    break;
            case 2: estadoToString="Sacaste Craps, ¡¡has perdido!!";
                    break;
            case 3: estadoToString="Estableciste punto en " +punto+
                                    " Debes seguir lanzando!!" +
                                    "\npero si sacas 7 antes que " +punto+ " perderas";
                    break;
            case 4: estadoToString="Volviste a sacar " +punto+ " ¡¡has ganado!!";
                    break;
            case 5: estadoToString="Sacaste 7, antes que " +punto+ "¡¡has perdido!!";
                    break;
        }
        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}
