public class AspiradoraConArrayAleatoria {
    public static void main(String[] args) {
        int mapa[][] = generaMapa();
        imprimeMapa(mapa);
    }
    
    private static int[][] generaMapa(){
        int mapa[][] = new int[14][17];
        for (int fila = 0; fila < mapa.length; fila++){
            for (int columna = 0; columna < mapa[fila].length; columna++){
                mapa[fila][columna] = numeroAleatorio(0,4);
            }
        }
        return mapa;
    }

    private static void imprimeMapa(int[][] mapa) {
        for (int fila = 0; fila < mapa.length; fila++){
            for (int columna = 0; columna < mapa[fila].length; columna++){
                System.out.print(traduce(mapa[fila][columna]));
            }
            System.out.println();
        }
    }
    
    static String traduce(int casilla) {
        String[] figuras = {" . ","...","ooo","OOO","***","(0)"};
        return figuras[casilla];
    }

    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }    
}
