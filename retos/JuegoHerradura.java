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
            turno++;
            int distanciaNaneh = (int) (Math.random() * 100);
            int distanciaArmand = (int) (Math.random() * 100);

            tramoNaneh = obtenerTramo(distanciaNaneh, PROBABILIDAD_PRIMER_TRAMO, PROBABILIDAD_SEGUNDO_TRAMO, PROBABILIDAD_TERCER_TRAMO);
            tramoArmand = obtenerTramo(distanciaArmand, PROBABILIDAD_PRIMER_TRAMO, PROBABILIDAD_SEGUNDO_TRAMO, PROBABILIDAD_TERCER_TRAMO);

            if (tramoNaneh == 1) puntosNaneh += PUNTOS_ACIERTO;
            if (tramoArmand == 1) puntosArmand += PUNTOS_ACIERTO;

            if (tramoArmand == tramoNaneh){
                puntosArmand += PUNTOS_EMPATE;
                puntosNaneh += PUNTOS_EMPATE;
            } else if (tramoArmand > tramoNaneh){
                puntosArmand += PUNTOS_GANADOR;
            } else if (tramoNaneh > tramoArmand){
                puntosNaneh += PUNTOS_GANADOR;
            }

            System.out.println("Lanzamiento N." + turno + ": Naneh:[Tramo " + tramoNaneh + "] Armand:[Tramo " + tramoArmand + "]");

            alguienGana = puntosArmand >= PUNTOS_MAXIMOS || puntosNaneh >= PUNTOS_MAXIMOS;

        } while (alguienGana == false);
        System.out.println("Puntos Naneh: " + puntosNaneh + " Puntos Armand:" + puntosArmand);
    }

    private static int obtenerTramo(int distancia, int p1, int p2, int p3) {
        if (distancia < p1) return 1;
        if (distancia < p2) return 2;
        if (distancia < p3) return 3;
        return 0; 
    }    
}
