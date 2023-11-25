import java.util.Scanner;
class CarreraCamello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int PROBABILIDAD_AGUJERO_1 = 60;
        final int AVANCE_AGUJERO_1 = 1;
        final int PROBABILIDAD_AGUJERO_2 = 40;
        final int AVANCE_AGUJERO_2 = 2;
        final int PROBABILIDAD_AGUJERO_3 = 30; 
        final int AVANCE_AGUJERO_3 = 4;
        final int PROBABILIDAD_AGUJERO_4 = 10;
        final int AVANCE_AGUJERO_4 = 6;
        final int MAXIMO_TURNOS = 50;
        final int FALLOS_REINICIO = 3;
        final int PROBABILIDAD_MANTENERSE = 10;
        final int TURNOS_PERDIDOS_TROPIEZO = 2;

        int turnosPerdidos = 0;
        int agujeroElegido = 0;
        int casillaCaballoJugador = 0;
        int casillaFin = 60;
        int turno = 0;
        int casillaCaballoOrdenador = 0;
        int avanceOrdenador = 0;
        int calculoTropiezo = 0;
        int fallos = 0;
        boolean tropezado = false;

        do {
            String mensajeSalida = "";
            int calculoAcierto = (int) (Math.random() * 100);
            casillaCaballoOrdenador += avanceOrdenador;
            avanceOrdenador = (int) (Math.random() * 3 + 1);
            
            if (tropezado == true && turnosPerdidos < TURNOS_PERDIDOS_TROPIEZO){
                System.out.println("El caballo se ha tropezado, quedan " + (TURNOS_PERDIDOS_TROPIEZO - turnosPerdidos) + " turnos para que se levante");
                scanner.nextLine();
                turnosPerdidos += 1;   
                calculoTropiezo = 0; 
            } else if (turnosPerdidos == TURNOS_PERDIDOS_TROPIEZO){
                tropezado = false;
            }
            
            if (tropezado == false){
                turnosPerdidos = 0;
                calculoTropiezo = (int) (Math.random() * 100);
                tropezado = calculoTropiezo > PROBABILIDAD_MANTENERSE;
            if (agujeroElegido == 1 && calculoAcierto < PROBABILIDAD_AGUJERO_1){
                casillaCaballoJugador += AVANCE_AGUJERO_1;
                mensajeSalida += " - Avanza " + AVANCE_AGUJERO_1 + " casillas - Esta en la casilla - " + casillaCaballoJugador;
                fallos = 0;
            } else if (agujeroElegido == 2 && calculoAcierto < PROBABILIDAD_AGUJERO_2){
                casillaCaballoJugador += AVANCE_AGUJERO_2;
                mensajeSalida += " - Avanza " + AVANCE_AGUJERO_2 + " casillas - Esta en la casilla - " + casillaCaballoJugador;
                fallos = 0;
            } else if (agujeroElegido == 3 && calculoAcierto < PROBABILIDAD_AGUJERO_3){
                casillaCaballoJugador += AVANCE_AGUJERO_3;
                mensajeSalida += " - Avanza " + AVANCE_AGUJERO_3 + " casillas - Esta en la casilla - " + casillaCaballoJugador;
                fallos = 0;
            } else if (agujeroElegido == 4 && calculoAcierto < PROBABILIDAD_AGUJERO_4){
                casillaCaballoJugador += AVANCE_AGUJERO_4;
                mensajeSalida += " - Avanza " + AVANCE_AGUJERO_4 + " casillas - Esta en la casilla - " + casillaCaballoJugador;
                fallos = 0;
            } else if (turno == 0) {
            } else {
                mensajeSalida += " - No avanza ninguna casilla - Esta en la casilla - " + casillaCaballoJugador;
                fallos += 1;
            }
            
            if (fallos == FALLOS_REINICIO){
                mensajeSalida += " - Has fallado 3 veces seguidas, vuelves a la casilla de inicio";
                casillaCaballoJugador = 0;
                fallos = 0;
            }

            dibujoCarrera(casillaCaballoJugador, casillaCaballoOrdenador);
            System.out.println("Turno " + turno + mensajeSalida);
            if (turno != 0){
            System.out.println("El ordenador avanza " + avanceOrdenador + " casillas  - Esta en la casilla " + casillaCaballoOrdenador);
            }
            if (casillaCaballoJugador < casillaFin){
                System.out.print("Elija un agujero: ");
                agujeroElegido = scanner.nextInt();
            }
            }
            turno += 1;

        } while (casillaCaballoJugador < casillaFin && casillaCaballoOrdenador < casillaFin && turno <= MAXIMO_TURNOS);
        String mensaje = casillaCaballoJugador > casillaCaballoOrdenador ? "El jugador gana" : "El ordenador gana";
        System.out.println("El juego ha terminado " + mensaje);
        
    }

    public static void dibujoCarrera(int casillaCaballoJugador, int casillaCaballoOrdenador) {
        final String SEPARADORES = "---+--" + "---------+".repeat(5) + "-----------+";
        final String DECENAS = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String UNIDADES = "---| " + "0123456789".repeat(6) + "0 |";
        String caballoJugador = "[J]| " + " ".repeat(casillaCaballoJugador) + ";--;'";
        String caballoOrdenador = "[O]| " + " ".repeat(casillaCaballoOrdenador) + ";--;'";
        System.out.println(SEPARADORES);
        System.out.println(DECENAS);
        System.out.println(UNIDADES);
        System.out.println(SEPARADORES);
        System.out.println(caballoJugador);
        System.out.println(SEPARADORES);
        System.out.println(caballoOrdenador);
        System.out.println(SEPARADORES);
    }
}
