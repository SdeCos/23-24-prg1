import java.util.Scanner;

class ViajeDeMarco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String SEPARADOR = "=".repeat(25);
        final String SEGUNDO_SEPARADOR = "- ".repeat(25);
        final String TERCER_SEPARADOR = "*".repeat(50);

        boolean madreEncontrada = false;
        int dia = 0;
        double recorridoDiarioMarco = 0;
        double recorridoDiarioMadre = 0;
        double distanciaTotalMarco = 0;
        String tiempoMarco;
        String tiempoMadre;
        String amedioCansado = "";
        String amedioEscapa = "";
        double distanciaTotalMadre = 350;
        String mensajeMadreVista = "";

        System.out.println("DIARIO DEL VIAJE DE MARCO");
        System.out.println(SEPARADOR);
        do {

            dia++;
            double calculadoraLluvia = Math.random();
            double calculadoraCansancio = Math.random();
            double calculadoraEscape = Math.random();
            double tiempoMoviendoseMarco = Math.random() * 2 + 8;
            double velocidadMarco = Math.random() * 5 + 10;
            double tiempoMoviendoseMadre = Math.random() * 3 + 6;
            double velocidadMadre = Math.random() * 3 + 6;

            if (calculadoraCansancio > 0.75 && calculadoraEscape > 0.85) {
                amedioCansado = "¡He ido más lento porque Amedio se ha cansado!\n";
                amedioEscapa = "¡He perdido tiempo buscando a Amedio!'\n";
                velocidadMarco = velocidadMarco * 0.9;
                tiempoMoviendoseMarco = tiempoMoviendoseMarco - 2;
            } else {
                if (calculadoraCansancio > 0.75) {
                    amedioCansado = "¡He ido más lento porque Amedio se ha cansado!\n";
                    velocidadMarco = velocidadMarco * 0.9;
                } else {
                    if (calculadoraEscape > 0.85) {
                        amedioEscapa = "¡He perdido tiempo buscando a Amedio!\n";
                        tiempoMoviendoseMarco = tiempoMoviendoseMarco - 2;
                    } else {
                        amedioCansado = "";
                        amedioEscapa = "";
                    }
                }
            }
            if (calculadoraLluvia < 0.6) {
                recorridoDiarioMarco = velocidadMarco * tiempoMoviendoseMarco;
                recorridoDiarioMadre = velocidadMadre * tiempoMoviendoseMadre;
                tiempoMarco = "Ha hecho un buen día\n";
                tiempoMadre = "A mamá le ha hecho un buen día\n";
            } else {
                if (calculadoraLluvia < 0.9) {
                    recorridoDiarioMarco = (velocidadMarco * 0.75) * tiempoMoviendoseMarco;
                    recorridoDiarioMadre = (velocidadMadre * 0.75) * tiempoMoviendoseMadre;
                    tiempoMarco = "Ha llovido un poco\n";
                    tiempoMadre = "A mamá le ha llovido un poco\n";

                } else {
                    recorridoDiarioMarco = (velocidadMarco * 0.25) * tiempoMoviendoseMarco;
                    recorridoDiarioMadre = (velocidadMadre * 0.5) * tiempoMoviendoseMadre;
                    tiempoMarco = "¡Ha llovido muchísimo!\n";
                    tiempoMadre = "¡A mamá le ha llovido muchísimo!\n";
                }
            }
            distanciaTotalMadre += recorridoDiarioMadre;
            distanciaTotalMarco += recorridoDiarioMarco;
            if ((distanciaTotalMadre - distanciaTotalMarco) <= 50){
                double veMadre = Math.random() * 100;
                if (veMadre > 50){
                    mensajeMadreVista = "A Marco le dicen que han visto a su mamá, y rompe a correr!!!\n";
                    distanciaTotalMarco += 25;
                }
            }
            System.out.println("DIA " + dia);
            System.out.print(tiempoMarco);
            System.out.print(amedioEscapa);
            System.out.print(amedioCansado);
            System.out.println("Avance " + Math.floor(tiempoMoviendoseMarco * 100) / 100 + " horas a " + Math.floor(velocidadMarco * 100) / 100 + " Km/h recorriendo " + Math.floor(recorridoDiarioMarco * 100) / 100 + " Km");
            System.out.print(tiempoMadre);
            System.out.println("Mama pudo avanzar " + Math.floor(tiempoMoviendoseMadre * 100) / 100 + " horas a " + Math.floor(velocidadMadre * 100) / 100 + " Km/h recorriendo " + Math.floor(recorridoDiarioMadre * 100) / 100 + " Km");
            System.out.println("Al final del día " + dia + " la distancia entre Marco y su Madre es de " + Math.floor((distanciaTotalMadre-distanciaTotalMarco) * 100) / 100);
            System.out.print(mensajeMadreVista);
            System.out.print(SEGUNDO_SEPARADOR);
            madreEncontrada = distanciaTotalMarco >= distanciaTotalMadre;
            scanner.nextLine();
        } while (madreEncontrada == false);
        System.out.println(TERCER_SEPARADOR);
        System.out.println("Al final del día " + dia + " Marco encuentra a su madre!!!");
        System.out.println(TERCER_SEPARADOR);
    }
}