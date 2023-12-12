import java.util.Arrays;
import java.util.Scanner;

public class Aspiradora {
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    final String ZONA_LIMPIA = " . ";
    final String ZONA_SUCIA = "...";
    final String ZONA_MAS_SUCIA = "ooo";
    final String ZONA_MUY_SUCIA = "OOO";
    final String ZONA_SUCISIMA = "***";
    final String ASPIRADORA = "(0)";
    final String GATO = "\"^\"";
    final String SOFA = "[####]";
    final String MESA = "``";
    final int COLUMNAS = 17;
    final int FILAS = 14;

    int[] zonasSucias = new int[8];
    int[] zonasMuySucias = new int[8];

    final int CASILLAS = FILAS * COLUMNAS;

    for (int zonas = 0; zonas < 8; zonas++){
        zonasSucias[zonas] = numeroAleatorio(1, CASILLAS);
        zonasMuySucias[zonas] = numeroAleatorio(1, CASILLAS);
    }
    
    int filaAspiradora = numeroAleatorio(1, FILAS);
    int columnaAspiradora = numeroAleatorio(1, FILAS);
    
    boolean estaSucio = false;
    boolean estaMuySucio = false;

    
    while (1 == 1){
        boolean aspiradoraDibujada = false;
        for (int fila = 1; fila <= FILAS; fila ++){
            for (int columna = 1; columna <= COLUMNAS; columna++){
                int posicion = columna + COLUMNAS * (fila - 1);
                estaSucio = false;
                estaMuySucio = false;
                for (int recorreArray = 0; recorreArray < 8; recorreArray++){
                    if (zonasSucias[recorreArray] == posicion){
                        estaSucio = true;
                    } else if (zonasMuySucias[recorreArray] == posicion){
                        estaMuySucio = true;
                    }
                } 
                if (fila == filaAspiradora && columna == columnaAspiradora && !aspiradoraDibujada){
                    System.out.print(ASPIRADORA);
                    aspiradoraDibujada = true;
                    filaAspiradora = numeroAleatorio((filaAspiradora - 1), (filaAspiradora + 1));
                    filaAspiradora = filaAspiradora < 1 ? 1 : filaAspiradora;
                    filaAspiradora = filaAspiradora > FILAS ? FILAS : filaAspiradora;
                    columnaAspiradora = numeroAleatorio((columnaAspiradora - 1), (columnaAspiradora + 1));
                    columnaAspiradora = columnaAspiradora == 0 ? 1 : columnaAspiradora;
                    columnaAspiradora = columnaAspiradora > FILAS ? FILAS : columnaAspiradora;
                    } else if (estaSucio) {
                        System.out.print(ZONA_SUCIA);
                    } else if (estaMuySucio) {
                        System.out.print(ZONA_MUY_SUCIA);
                    } else {
                        System.out.print(ZONA_LIMPIA);
                    }
                
            }
            System.out.println();
        }
        scanner.nextLine();
    }
    }
    
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }

    static boolean calculoProbabilidad(int probabilidad) {
        if (numeroAleatorio(0, 100) < probabilidad){
            return true;
        } else {
            return false;
        }
    }

}
