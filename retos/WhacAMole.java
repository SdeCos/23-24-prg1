import java.util.Scanner;
class WhacAMole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String SEPARADOR = "=".repeat(30);
        int turno = 0;
        int aciertos = 0;
        int casillaGolpeada;
        int casillaMonigote;
        int turnos = 15;
        String mensaje;
        final int NUMERO_DE_AGUJEROS = 16;

        do{
            casillaMonigote = (int) (Math.random() * (NUMERO_DE_AGUJEROS) + 1);
            turno += 1;

            System.out.print("Golpe (entre 1 y 16): ");
            casillaGolpeada = scanner.nextInt();

            System.out.println("Golpe en [" + casillaGolpeada + "] / Monigote en [" + casillaMonigote + "]");

            System.out.println(" +-----------------------------------+");
            dibujoMaquina(casillaMonigote, casillaGolpeada, NUMERO_DE_AGUJEROS);
            System.out.println(" +-----------------------------------+");

            if (casillaGolpeada == casillaMonigote){
                aciertos += 1;
                mensaje = "[ACIERTO]";
            } else {
                mensaje = "[FALLO]";
            }
            
            System.out.println("Turno:[" + turno + "] / Aciertos:[" + aciertos + "]");
            System.out.println(mensaje);
            System.out.println(SEPARADOR);
        
        }while (turno < turnos);
    }

    public static void dibujoMaquina(int casillaMonigote, int casillaGolpeada, final int NUMERO_DE_AGUJEROS) {
        
        final String AGUJERO = " (  ) ";
        final String AGUJERO_CON_MONIGOTE = " ('') ";
        final String AGUJERO_GOLPEADO = " [[]] ";
        final String AGUJERO_CON_MONIGOTE_GOLPEADO = " [**] ";
        for (int coordenada = 1;  coordenada <= (NUMERO_DE_AGUJEROS); coordenada ++) {
            System.out.print(" | ");
                if (coordenada == casillaGolpeada && coordenada == casillaMonigote){
                        System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);
                    }else if (coordenada == casillaGolpeada) {
                    System.out.print(AGUJERO_GOLPEADO);
                    } else if (coordenada == casillaMonigote){
                        System.out.print(AGUJERO_CON_MONIGOTE);
                    } else {
                        System.out.print(AGUJERO);
                    }

                if (coordenada % 4 == 0) {
                    System.out.println(" |");
                }

        }
    }
}
