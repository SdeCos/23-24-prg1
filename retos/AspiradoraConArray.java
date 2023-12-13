import java.util.Scanner;
import java.util.stream.IntStream;
class AspiradoraConArray {
    public static final int EJE_X = 0;
    public static final int EJE_Y = 1;
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

        int mapaPruebas[][] = {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,1},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };

        int[] posicionAspiradora = {2, 2};

        int suciedadAspirada = 0;
        boolean termino = false;
        int pasos = 0;

        for (pasos = 1; pasos<=999999 && !termino ; pasos++){
            int suciedadRestante = sumaMapa(mapa);
            termino = suciedadRestante == 0;
            suciedadAspirada += mapa[posicionAspiradora[EJE_Y]][posicionAspiradora[EJE_X]] > 0 ? 1 : 0;
            imprimeMapa(mapa, posicionAspiradora, suciedadAspirada, pasos, suciedadRestante);
            mueveAspiradora(posicionAspiradora, mapa);
            scanner.nextLine();
            limpiarPantalla();
        }
        System.out.println("La aspiradora ha limpiado por completo la habitacion, tardando " + pasos + " pasos");

    }

    private static void mueveAspiradora(int[] posicionAspiradora, int[][] mapa) {
        posicionAspiradora[EJE_X] = numeroAleatorio(posicionAspiradora[EJE_X] - 1, posicionAspiradora[EJE_X] + 1);
        // posicionAspiradora[EJE_X]++;
        posicionAspiradora[EJE_X] = posicionAspiradora[EJE_X] < 0 ? (mapa[0].length - 1) : posicionAspiradora[EJE_X];
        posicionAspiradora[EJE_X] = posicionAspiradora[EJE_X] > (mapa[0].length - 1) ? 0 : posicionAspiradora[EJE_X];
        posicionAspiradora[EJE_Y] = numeroAleatorio(posicionAspiradora[EJE_Y] - 1, posicionAspiradora[EJE_Y] + 1);
        // posicionAspiradora[EJE_Y]++;
        posicionAspiradora[EJE_Y] = posicionAspiradora[EJE_Y] < 0 ? (mapa.length - 1) : posicionAspiradora[EJE_Y];
        posicionAspiradora[EJE_Y] = posicionAspiradora[EJE_Y] > (mapa.length - 1) ? 0 : posicionAspiradora[EJE_Y];
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

    private static void imprimeMapa(int[][] mapa, int[] posicionAspiradora, int suciedadAspirada, int pasos, int suciedadRestante) {
        final int VALOR_ASPIRADORA = 5;
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
        String[] figuras = {" . ","...","ooo","OOO","***","(0)"};
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
