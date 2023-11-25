class JuegoHerradura {
    public static void main(String[] args) {
        
        final int PROBABILIDAD_PRIMER_TRAMO = 10;
        final int PROBABILIDAD_SEGUNDO_TRAMO = PROBABILIDAD_PRIMER_TRAMO + 12;
        final int PROBABILIDAD_TERCER_TRAMO = PROBABILIDAD_SEGUNDO_TRAMO + 78;

        final int PUNTOS_ACIERTO = 5;
        final int PUNTOS_GANADOR = 3;
        final int PUNTOS_EMPATE = 1;

        final int PUNTOS_MAXIMOS = 50;

        boolean alguienGana = false;

        int puntosNaneh = 0;
        int puntosArmand = 0;

        int tramoNaneh = 0;
        int tramoArmand = 0;
        
        int turno = 0;
        do {
            String mensaje = "Lanzamiento N.";
            turno++;
            int distanciaNaneh = (int) (Math.random() * 100);
            int distanciaArmand = (int) (Math.random() * 100);

            mensaje += turno + ": ";
            
            if (distanciaNaneh < PROBABILIDAD_PRIMER_TRAMO){
                mensaje += "Naneh:[Tramo 1]";
                puntosNaneh += PUNTOS_ACIERTO;
                tramoNaneh = 1;
            } else if (distanciaNaneh < PROBABILIDAD_SEGUNDO_TRAMO){
                mensaje += "Naneh:[Tramo 2]";
                tramoNaneh = 2;
            } else if (distanciaNaneh < PROBABILIDAD_TERCER_TRAMO){
                mensaje += "Naneh:[Tramo 3]";
                tramoNaneh = 3;
            }

            if (distanciaArmand < PROBABILIDAD_PRIMER_TRAMO){
                mensaje += " Armand:[Tramo 1]";
                puntosArmand += PUNTOS_ACIERTO;
                tramoArmand = 1;
            } else if (distanciaArmand < PROBABILIDAD_SEGUNDO_TRAMO){
                mensaje += " Armand:[Tramo 2]";
                tramoArmand = 2;
            } else if (distanciaArmand < PROBABILIDAD_TERCER_TRAMO){
                mensaje += " Armand:[Tramo 3]";
                tramoArmand = 3;
            }

            if (tramoArmand == tramoArmand){
                puntosArmand += PUNTOS_EMPATE;
                puntosNaneh += PUNTOS_EMPATE;
            } else if (tramoArmand > tramoNaneh){
                puntosArmand += PUNTOS_GANADOR;
            } else if (tramoNaneh > tramoArmand){
                puntosNaneh += PUNTOS_GANADOR;
            }

            alguienGana = puntosArmand >= PUNTOS_MAXIMOS || puntosNaneh >= PUNTOS_MAXIMOS;
            System.out.println(mensaje);
        } while (alguienGana == false);
        System.out.println("Puntos Naneh: " + puntosNaneh + " Puntos Armand:" + puntosArmand);
    }    
}
