import java.util.Scanner;
class ParcialSaul {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        final int DIAS_SEMANA = 7;

        int dia = 1;
        int hora = 0;
        
        int consumoHora = 0;
        int consumoDia1 = 0;
        int consumoDia2 = 0;
        int consumoDia3 = 0;
        int consumoDia4 = 0;
        int consumoDia5 = 0;
        int consumoDia6 = 0;
        int consumoDia7 = 0;
        int consumoTotal = 0;
        boolean semanaFinalizada = false;

        int plantaMantenimiento = 0;
        int columnaRayo = 0;
        final int PROBABILIDAD_MANTENIMIENTO = 5;
        final int PROBABILIDAD_RAYO = 20;

        do{
            if (calculoProbabilidad(PROBABILIDAD_RAYO) == 1 && columnaRayo == 0){
                columnaRayo = numeroAleatorio(1, 7);
            } else if (hora == 0){
                columnaRayo = 0;
            }
            limpiarPantalla();
            impresionTecho();
            consumoHora = edificio(plantaMantenimiento, columnaRayo);
            impresionBajos();
            
            if (dia == 1){            
                consumoDia1 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 2){
                consumoDia2 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 3){
                consumoDia3 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 4){
                consumoDia4 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 5){
                consumoDia5 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 6){
                consumoDia6 += consumoHora;
                consumoTotal += consumoHora;
            } else if (dia == 7){
                consumoDia7 += consumoHora;
                consumoTotal += consumoHora;
            }
            
            System.out.println("Dia " + dia + " - " + hora + ":00h Consumo hora: " + consumoHora);
            System.out.println("CONSUMOS: D1:" + consumoDia1 + " | D2:" + consumoDia2 + " | D3:" + consumoDia3 + " | D4:" + consumoDia4 + " | D5:" + consumoDia5 + " | D6:" + consumoDia6 + " | D7:" + consumoDia7);
            
            hora++;

            if (hora == 24){
                hora = 0;
                dia++;
                if (calculoProbabilidad(PROBABILIDAD_MANTENIMIENTO) == 1){
                    plantaMantenimiento = numeroAleatorio(1, 7);
                }   
            }

            semanaFinalizada = dia == (DIAS_SEMANA + 1);
            scanner.nextLine();

        }while(!semanaFinalizada);

        int media = consumoTotal / DIAS_SEMANA;

        System.out.println("Media de consumo semanal: " + media);

    }

    static int edificio(int plantaMantenimiento, int columnaRayo) {

        final String LUZ_ENCENDIDA = ":[*]:";
        final String LUZ_APAGADA = ":[º]:";
        final String VENTANA_CERRADA = ":[ ]:";
        final String COLUMNA_CENTRAL = "[    ]";
        final String MANTENIMIENTO = ":[#]:";
        final String RAYO = ":[X]:";

        final int TOTAL_PLANTAS = 7;
        final int HABITACIONES_POR_PLANTA = 6;
        final int NUMERO_COLUMNAS_CENTALES = 1;
        final int UBICACION_COLUMNA_CENTAL = 4;

        final int ENCENDIDA = 1;
        final int ABIERTA = 1;

        final int PROBABILIDAD_LUZ_ENCENDIDA = 60;
        final int PROBABILIDAD_VENTANA_ABIERTA = 70;

        int consumoHora = 0;

        String queImprimir = "";

        for (int fila = 1; fila <= TOTAL_PLANTAS; fila++) {
            for (int columna = 1; columna <= (HABITACIONES_POR_PLANTA + NUMERO_COLUMNAS_CENTALES); columna++) {
                int estadoLuz = calculoProbabilidad(PROBABILIDAD_LUZ_ENCENDIDA);
                int estadoVentana = calculoProbabilidad(PROBABILIDAD_VENTANA_ABIERTA);

                if (columna == UBICACION_COLUMNA_CENTAL){
                    queImprimir = COLUMNA_CENTRAL;
                } else if (fila == plantaMantenimiento){
                    queImprimir = MANTENIMIENTO;
                } else if (columna == columnaRayo){
                    queImprimir = RAYO;
                } else if (estadoLuz == ENCENDIDA){
                    queImprimir = estadoVentana == ABIERTA ? LUZ_ENCENDIDA : VENTANA_CERRADA;
                    consumoHora += 1;
                } else {
                    queImprimir = estadoVentana == ABIERTA ? LUZ_APAGADA : VENTANA_CERRADA;
                }
                System.out.print(queImprimir);
            }
            System.out.println(" - P" + (TOTAL_PLANTAS - fila + 1));
        }

        return consumoHora;
    }


    static int calculoProbabilidad(int probabilidad) {
        if (numeroAleatorio(0, 100) < probabilidad){
            return 1;
        } else {
            return 0;
        }
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }

    static void pausa(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }


    static void impresionTecho() {
        final String TIP = "     ".repeat(3) + "__/\\__";
        final String HEADER = "|####|";
        final String ANTENNA = "  |  ";
        final String ROOF = "=".repeat(36);

        System.out.println(TIP);
        System.out.println(ANTENNA.repeat(3) + HEADER + ANTENNA.repeat(3));
        System.out.println(ROOF);
    }

    static void impresionBajos() {
        System.out.println("""
                :[       ]::::|      |::::[       ]:
                ------------------------------------
                     ==========================
                   ==============================
                 ==================================
                """);
    }
}