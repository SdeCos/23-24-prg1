import java.util.Scanner;

import javax.sound.midi.Soundbank;
class ExamenAutomaticoPresonalizado {
    public static void main(String[] args) {    
        Scanner scanner = new Scanner(System.in);
       
        int opcionMenu = 0;
        int dificultad = 0;
        
        final int VOLVER_AL_MENU = 0;
        final int CONFIGURACION = 1;
        final int EJECUCION = 2;
        final int SALIR = 3;
        
        final int NO_CONFIGURADO = 0;
        final int FACIL = 1;
        final int MEDIO = 2;
        final int DIFICIL = 3;

        String mensajeDificultad = "";

        while (!(opcionMenu == SALIR)){
            while (!(opcionMenu == CONFIGURACION) && !(opcionMenu == EJECUCION) && !(opcionMenu == SALIR)){
                limpiarPantalla();
                System.out.print(mensajeDificultad + """
                        +----MENU  PRINCIPAL----+
                        | 1. Configuracion      |
                        | 2. Ejecutar Test      |
                        | 3. Salir del programa |
                        +-----------------------+
                        Elige la acción que deseas realizar: """);
                    opcionMenu = scanner.nextInt();
                }

                limpiarPantalla();
              
                if (opcionMenu == CONFIGURACION){
                    dificultad = NO_CONFIGURADO;
                    while (!(dificultad == FACIL) && !(dificultad == MEDIO) && !(dificultad == DIFICIL)){
                    System.out.print("""
                            +--NIVEL DE DIFICULTAD--+
                            | 1. Facil              |
                            | 2. Medio              |
                            | 3. Dificil            |
                            +-----------------------+
                            Elige la acción que deseas realizar: """);
                    dificultad = scanner.nextInt();
                    mensajeDificultad = "";
                }
                opcionMenu = VOLVER_AL_MENU;
              
                } else if (opcionMenu == EJECUCION && dificultad == NO_CONFIGURADO){
                    mensajeDificultad = "Antes de empezar el test hay que configurar el nivel de dificultad\n";
                    opcionMenu = VOLVER_AL_MENU;
                } else if (opcionMenu != SALIR){
                    juego(dificultad);
                    System.out.println("Pulsa cualquier número para continuar");
                    scanner.nextInt();
                    opcionMenu = VOLVER_AL_MENU;
                }
    }           
}

    private static void juego(int dificultad) {
        Scanner scanner = new Scanner(System.in);
  
        final int FACIL = 1;
        final int MEDIO = 2;
        final int DIFICIL = 3;

        final int NUMERO_PREGUNTAS = 5;

        final int FACTOR_MINIMO_FACIL = 1;
        final int FACTOR_MINIMO_MEDIO = 1;
        final int FACTOR_MINIMO_DIFICIL = 4;
        final int FACTOR_MAXIMO_FACIL = 6;
        final int FACTOR_MAXIMO_MEDIO = 10;
        final int FACTOR_MAXIMO_DIFICIL = 10;
        
        final int PUNTOS_ACIERTO = 2;
        final double PUNTOS_FALLO = -0.5;

        int respuesta;
        double puntos = 0;
        
        int preguntasHechas = 0;
        while (preguntasHechas < NUMERO_PREGUNTAS){
            int primerFactor = numeroAleatorio(1, 10);
            if (dificultad == FACIL){
                int segundoFactor = numeroAleatorio(FACTOR_MINIMO_FACIL, FACTOR_MAXIMO_FACIL);
                System.out.print(primerFactor + " x " + segundoFactor + " = ");
                respuesta = scanner.nextInt();
                if (respuesta == (primerFactor * segundoFactor)){
                    puntos += PUNTOS_ACIERTO;
                } else {
                    puntos += PUNTOS_FALLO;
                }
            } else if (dificultad == MEDIO){
                int segundoFactor = numeroAleatorio(FACTOR_MINIMO_MEDIO, FACTOR_MAXIMO_MEDIO);
                System.out.print(primerFactor + " x " + segundoFactor + " = ");
                respuesta = scanner.nextInt();
                if (respuesta == (primerFactor * segundoFactor)){
                    puntos += PUNTOS_ACIERTO;
                } else {
                    puntos += PUNTOS_FALLO;
                }
            } else if (dificultad == DIFICIL){
                int segundoFactor = numeroAleatorio(FACTOR_MINIMO_DIFICIL, FACTOR_MAXIMO_DIFICIL);
                System.out.print(primerFactor + " x " + segundoFactor + " = ");
                respuesta = scanner.nextInt();
                if (respuesta == (primerFactor * segundoFactor)){
                    puntos += PUNTOS_ACIERTO;
                } else {
                    puntos += PUNTOS_FALLO;
                }
            }
            preguntasHechas++;
        }
        String nota = puntos >= 5 ? "aprobado" : "suspendido";
        System.out.println("Has obtenido " + puntos + " puntos, has " + nota);
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static int numeroAleatorio (int minimo, int maximo){
        return (int) (Math.random() * (maximo + 1 - minimo) + minimo);
    }
}