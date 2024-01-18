public class MetodosEstaticos {
    public static void main(String[] args) {
        limpiarPantalla();
        System.out.println("===Pruebas de los métodos estáticos===");
        System.out.println("Numero aleatorio: " + numeroAleatorio(0, 100));
        pausa(5);
        System.out.println("Calculo probabilidad: " + (calculoProbabilidad(50) == true ? "Verdadero" : "Falso"));
    }

// NUMERO ALEATORIO
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }

// PROBABILIDAD
    static boolean calculoProbabilidad(int probabilidad) {
        if (numeroAleatorio(0, 100) < probabilidad){
            return true;
        } else {
            return false;
        }
    }

// LIMPIAR PANTALLA
    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

// PAUSA
    static void pausa(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }
}