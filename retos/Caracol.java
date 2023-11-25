import java.util.Scanner;
class Caracol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int alturaSalida = 0;
        double profundidad = Math.random() * 10 + 10;
        boolean estaFuera = false;
        boolean estaVivo = true;
        boolean cocheAparcado = false;
        int dia = 0;
        int ascensoMaximo = 4;
        int ascensoMinimo = 1;
        String mensajeMuerte = "";

        final double PROBABILIDAD_COCHE = 35;
        final double PROBABILIDAD_LLUVIA_MEDIA = 10;
        final double PROBABILIDAD_LLUVIA_FUERTE = 5;
        String mensajeTiempo = "";
        final int REDUCCION_PROFUNDIDAD_LLUVIA_FUERTE = 5;
        final int REDUCCION_PROFUNDIDAD_LLUVIA_MEDIA = 2;

        int profundidadMaxima = 20;

        double ascensoDiario;   
        double descensoNoche;
        double calculoTiempo;
        double ascensoAproximado;
        double descensoAproximado;
        double profundidadAproximada;
        double calculoCoche;

        do {
            ascensoDiario = (Math.random() * (ascensoMaximo - ascensoMinimo)) + ascensoMinimo;
            descensoNoche = Math.random() * 2;
            calculoTiempo = Math.random() * 100;
            ascensoAproximado = Math.floor(ascensoDiario * 100) / 100;
            descensoAproximado = Math.floor(descensoNoche * 100) / 100;
            profundidadAproximada = Math.floor(profundidad * 100) / 100;
            calculoCoche = Math.random() * 100;

            dia += 1;
            if (dia == 10) {
                ascensoMaximo = 3;
            }

            if (dia == 20) {
                ascensoMaximo = 2;
            }

            if (dia == 50) {
                estaVivo = false;
                mensajeMuerte = "\nMurió el día " + dia + " a una profundidad de " + profundidadAproximada + "\n";
            }

            if (calculoCoche >= PROBABILIDAD_COCHE) {
                cocheAparcado = false;
            } else {
                cocheAparcado = true;
                descensoNoche += 2;
                descensoAproximado += 2;
            }

            if (calculoTiempo < PROBABILIDAD_LLUVIA_FUERTE) {
                mensajeTiempo = "Hoy ha llovido mucho\n";
                profundidadMaxima -= REDUCCION_PROFUNDIDAD_LLUVIA_FUERTE;
            } else {
                if (calculoTiempo < PROBABILIDAD_LLUVIA_MEDIA) {
                    mensajeTiempo = "Hoy ha llovido levemente\n";
                    profundidadMaxima -= REDUCCION_PROFUNDIDAD_LLUVIA_MEDIA;
                } else {
                    mensajeTiempo = "Hoy ha hecho un buen día\n";
                }
            }

            profundidad = profundidad - ascensoDiario + descensoNoche;
            if (profundidad >= profundidadMaxima) {
                profundidad = profundidadMaxima - 1;
                profundidadAproximada = profundidadMaxima - 1;
            }
            System.out.print(mensajeTiempo);
            System.out.println("Día [" + dia + "] / Sube: [" + ascensoAproximado + "] / Baja: [" + descensoAproximado
                    + "] / Altura al final del día: [" + profundidadAproximada + "]");
            dibujoPozo((int) profundidadAproximada, cocheAparcado, profundidadMaxima);
            System.out.print(mensajeMuerte);
            scanner.nextLine();
            if (profundidadAproximada <= alturaSalida) {
                estaFuera = true;
                System.out.println("El caracol salió del pozo el día " + dia);
            }
        } while (estaFuera == false && estaVivo == true);
    }

    public static void dibujoPozo(int profundidad, boolean cocheAparcado, int profundidadMaxima) {
        final String BORDE = "[__]";
        final String PARED = "[]";
        final String FONDO = " :. ";
        final String CARACOL = "       _@)_/'       ";
        final String AGUA = "~~~~";
        final String COCHE = "      O-=-O     ";
        int nivel = 0;
        if (cocheAparcado == true) {
            System.out.println(BORDE + COCHE + BORDE);
        } else {
            System.out.println(BORDE + " ".repeat(16) + BORDE);
        }

        while (nivel <= profundidadMaxima) {
            if (nivel == profundidad) {
                System.out.println(PARED + CARACOL + PARED + "_ __ " + nivel);
            } else {
                System.out.println(PARED + FONDO.repeat(5) + PARED + "_ __ " + nivel);
            }
            nivel += 1;
        }
        while (nivel > profundidadMaxima && nivel <= 20) {
            System.out.println(PARED + AGUA.repeat(5) + PARED + "_ __ " + nivel);
            nivel += 1;
        }
        System.out.println(PARED.repeat(12));
    }
}
