import java.util.Scanner;
class AspiradoraConArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapa[][] = {
            {0,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,2,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,1,0,2,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,1,0,0,2,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
            {0,0,0,1,0,2,0,0,0,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,1,0,0,1,0,0,2,0,0,0,0,0,0},
            {0,2,0,2,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,2,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,3,0,0,0,2,0,0,0,0,0,0,0,0,0},
            {1,0,1,0,2,0,0,0,0,0,0,0,0,0,0,1,0,0}
        };
        int xAspiradora = 4;
        int yAspiradora = 4;

        for (int i = 0; i<=999999;i++){
        imprimeMapa(mapa, xAspiradora, yAspiradora);
        xAspiradora = numeroAleatorio(xAspiradora - 1, xAspiradora + 1);
        xAspiradora = xAspiradora < 0 ? 1 : xAspiradora;
        xAspiradora = xAspiradora > mapa.length ? mapa.length : xAspiradora;
        yAspiradora = numeroAleatorio(yAspiradora - 1, yAspiradora + 1);
        yAspiradora = yAspiradora < 0 ? 1 : yAspiradora;
        yAspiradora = yAspiradora > mapa[1].length ? mapa[1].length : yAspiradora;
        scanner.nextLine();
        limpiarPantalla();
        }

    }

    private static void imprimeMapa(int[][] mapa, int xAspiradora, int yAspiradora) {

        final int VALOR_ASPIRADORA = 5;
        
        for (int fila = 0; fila < mapa.length; fila++){
            for (int columna = 0; columna < mapa[fila].length; columna++){
                if (columna == xAspiradora && fila == yAspiradora){
                System.out.print(traduce(VALOR_ASPIRADORA));
                } else {
                System.out.print(traduce(mapa[fila][columna]));
                }
            }
            System.out.println();
        }
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
