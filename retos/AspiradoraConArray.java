import java.util.Scanner;
import java.util.stream.IntStream;
class AspiradoraConArray {
    public static final int EJE_X = 0;
    public static final int EJE_Y = 1;
    public static final int ASPIRADORA = 0;
    public static final int GATO = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int mapa[][] = {
            {0,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0},
            {0,1,1,1,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0},
            {0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,2,0},
            {0,1,1,1,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0},
            {0,0,0,1,0,2,0,0,0,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,1,0,0,1,0,0,2,0,0,0,0,0,0,0},
            {0,2,0,2,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,2,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,3,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {1,0,1,0,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0}
        };

        int mapaPrueba[][] = {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,1},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };
        int[][] posicionObjeto = {
            {2, 2},
            {4, 4}
        };

        int suciedadAspirada = 0;
        boolean termino = false;
        boolean bateriaAgotada = false;
        int pasos = 1;

        int capacidadBateria = (mapa.length * mapa[0].length) * 5;
        System.out.println(capacidadBateria);
        do{
            int suciedadRestante = sumaMapa(mapa);
            termino = suciedadRestante == 0;
            bateriaAgotada = pasos == capacidadBateria;
            suciedadAspirada += mapa[posicionObjeto[ASPIRADORA][EJE_Y]][posicionObjeto[ASPIRADORA][EJE_X]] > 0 ? 1 : 0;
            imprimeMapa(mapa, posicionObjeto[ASPIRADORA], suciedadAspirada, pasos, suciedadRestante, posicionObjeto[GATO]);
            mueveObjeto(posicionObjeto[ASPIRADORA], mapa);
            mueveObjeto(posicionObjeto[GATO], mapa);
            scanner.nextLine();
            limpiarPantalla();
            pasos++;
        }while (!bateriaAgotada && !termino);
        if (bateriaAgotada){
            System.out.println("La batería se agotó tras " + pasos + " pasos");
        } else if (termino){
            System.out.println("Terminó de limpiar la habitación tras " + pasos + " pasos");
        }

    }

    private static void mueveObjeto(int[] posicionObjeto, int[][] mapa) {
        posicionObjeto[EJE_X] = numeroAleatorio(posicionObjeto[EJE_X] - 1, posicionObjeto[EJE_X] + 1);
        // posicionAspiradora[EJE_X]++;
        posicionObjeto[EJE_X] = posicionObjeto[EJE_X] < 0 ? (mapa[0].length - 1) : posicionObjeto[EJE_X];
        posicionObjeto[EJE_X] = posicionObjeto[EJE_X] > (mapa[0].length - 1) ? 0 : posicionObjeto[EJE_X];
        posicionObjeto[EJE_Y] = numeroAleatorio(posicionObjeto[EJE_Y] - 1, posicionObjeto[EJE_Y] + 1);
        // posicionAspiradora[EJE_Y]++;
        posicionObjeto[EJE_Y] = posicionObjeto[EJE_Y] < 0 ? (mapa.length - 1) : posicionObjeto[EJE_Y];
        posicionObjeto[EJE_Y] = posicionObjeto[EJE_Y] > (mapa.length - 1) ? 0 : posicionObjeto[EJE_Y];
    }

    private static int sumaMapa(int[][] mapa) {
    int suma = 0;
    for (int fila = 0; fila < mapa.length; fila++){
        for (int columna = 0; columna < mapa[fila].length; columna++){
            suma += mapa[fila][columna];
        }
    }
    return suma;
    }

    private static void imprimeMapa(int[][] mapa, int[] posicionAspiradora, int suciedadAspirada, int pasos, int suciedadRestante, int[] posicionGato) {
        final int VALOR_ASPIRADORA = 5;
        final int VALOR_GATO = 6;
        int queDetecta = 0;
        System.out.println("+" + "---".repeat(mapa[1].length) + "+");
        for (int fila = 0; fila < mapa.length; fila++){
            System.out.print("|");
            for (int columna = 0; columna < mapa[fila].length; columna++){
                if (columna == posicionAspiradora[EJE_X] && fila == posicionAspiradora[EJE_Y]){
                System.out.print(traduce(VALOR_ASPIRADORA));
                queDetecta = mapa[fila][columna];
                mapa[fila][columna]--;
                mapa[fila][columna] = mapa[fila][columna] < 0 ? 0 : mapa[fila][columna];
                } else if (columna == posicionGato[EJE_X] && fila == posicionGato[EJE_Y]){
                System.out.print(traduce(VALOR_GATO));
                mapa[fila][columna]++;
                mapa[fila][columna] = mapa[fila][columna] > 4 ? 4 : mapa[fila][columna];
                } else {
                System.out.print(traduce(mapa[fila][columna]));
                }
            }
            System.out.println("|");
        }
        System.out.println("+" + "---".repeat(mapa[1].length) + "+");
        System.out.println("Aspiradora en " + (posicionAspiradora[EJE_X] + 1) + "x, " + (posicionAspiradora[EJE_Y] + 1) + "y, detecta " + traduce(queDetecta) + ", en total ha aspirado " + suciedadAspirada + " objetos, habiendo dado " + pasos + " pasos, le falta por aspirar, " + suciedadRestante + " objeto/s");
    }

    static String traduce(int casilla) {
        String[] figuras = {" . ","...","ooo","OOO","***","(0)", "\"^\""};
        return figuras[casilla];
    }
    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void pausa(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }
}
