import java.util.Scanner;
class Adivinacion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUMERO = (int) (Math.random() * 100) + 1;
        int respuesta;
        int intentos = 0;
        boolean adivinado = false;
        String distanciaFallo = "";

        do {
            System.out.print("Introduce un número: ");
            respuesta = scanner.nextInt();
            if (respuesta == NUMERO) {
                adivinado = true;
                System.out.println("Has adivinado el número!!");
                System.out.println("Lo has hecho en " + (intentos + 1) + " intento/s");
            } else {
                if (respuesta <= (NUMERO + 5) && respuesta >= (NUMERO - 5)) {
                    distanciaFallo = "Caliente";
                } else {
                    if (respuesta <= (NUMERO + 10) && respuesta >= (NUMERO - 10)) {
                        distanciaFallo = "Tibio";
                    } else {
                        distanciaFallo = "Frio";
                    }
                }
                if (respuesta > NUMERO) {
                    System.out.println("Es menor");
                    System.out.println(distanciaFallo);
                    System.out.println("Te quedan " + (4 - intentos) + " intentos");
                } else {
                    System.out.println("Es mayor");
                    System.out.println(distanciaFallo);
                    System.out.println("Te quedan " + (4 - intentos) + " intentos");
                }
            }
            intentos += 1;
        } while (adivinado == false && intentos != 5);
        System.out.println("El número era " + NUMERO);
    }
}
