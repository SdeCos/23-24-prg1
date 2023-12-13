import java.util.Scanner;
import java.util.stream.IntStream;
class AspiradoraConArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapa[][] = {
            {0,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,2,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
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

        int xAspiradora = numeroAleatorio(0, (mapa[1].length - 1));
        int yAspiradora = numeroAleatorio(0, (mapa.length - 1));
        int suciedadAspirada = 0;
        boolean termino = false;
        int pasos = 0;

        for (pasos = 1; pasos<=999999 && !termino ; pasos++){
            int suciedadRestante = sumaMapa(mapa);
            termino = suciedadRestante == 0;
            suciedadAspirada += mapa[yAspiradora][xAspiradora] > 0 ? 1 : 0;
            imprimeMapa(mapa, xAspiradora, yAspiradora, suciedadAspirada, pasos, suciedadRestante);

            xAspiradora = numeroAleatorio(xAspiradora - 1, xAspiradora + 1);
            xAspiradora = xAspiradora < 0 ? 0 : xAspiradora;
            xAspiradora = xAspiradora > (mapa[1].length - 1) ? (mapa.length - 1) : xAspiradora;

            yAspiradora = numeroAleatorio(yAspiradora - 1, yAspiradora + 1);
            yAspiradora = yAspiradora < 0 ? 0 : yAspiradora;
            yAspiradora = yAspiradora > (mapa.length - 1) ? (mapa.length - 1) : yAspiradora;

            scanner.nextLine();
            limpiarPantalla();
        }
        System.out.println("La aspiradora ha limpiado por completo la habitacion, tardando " + pasos + " pasos");

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

    private static void imprimeMapa(int[][] mapa, int xAspiradora, int yAspiradora, int suciedadAspirada, int pasos, int suciedadRestante) {
        final int VALOR_ASPIRADORA = 5;
        System.out.println("+" + "---".repeat(mapa[1].length) + "+");
        for (int fila = 0; fila < mapa.length; fila++){
            System.out.print("|");
            for (int columna = 0; columna < mapa[fila].length; columna++){
                if (columna == xAspiradora && fila == yAspiradora){
                System.out.print(traduce(VALOR_ASPIRADORA));
                mapa[fila][columna]--;
                mapa[fila][columna] = mapa[fila][columna] < 0 ? 0 : mapa[fila][columna];
                } else {
                System.out.print(traduce(mapa[fila][columna]));
                }
            }
            System.out.println("|");
        }
        System.out.println("+" + "---".repeat(mapa[1].length) + "+");
        System.out.println("Aspiradora en " + (xAspiradora + 1) + "x, " + (yAspiradora + 1) + "y, detecta " + traduce(mapa[yAspiradora][xAspiradora]) + ", en total ha aspirado " + suciedadAspirada + " objetos, habiendo dado " + pasos + " pasos, le falta por aspirar, " + suciedadRestante + " objeto/s");
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
