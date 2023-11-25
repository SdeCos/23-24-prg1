import java.util.Scanner;
class MicroRetosIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String SEPARADOR = "=".repeat(20);

        System.out.println(
                "Punto 1\nEscriba un programa que simule el lanzamiento de una moneda y nos diga al ejecutarse si ha salido cara o cruz.");

        double simuladorMoneda = Math.random();

        if (simuladorMoneda >= 50) {
            System.out.println("Ha salido cara");
        } else {
            System.out.println("Ha salido cruz");
        }

        System.out.println(SEPARADOR);

        System.out.println(
                "Punto 2\nEscriba un programa que pregunte dos números al usuario y realice la división de dos números, siempre y cuando el usuario no pida dividir por cero.");
        System.out.print("Introduce el dividendo: ");
        double dividendo = scanner.nextDouble();
        System.out.print("Introduce el divisor: ");
        double divisor = scanner.nextDouble();
        if (divisor == 0) {
            System.out.println("No se puede dividir por cero");
        } else {
            double resultado = dividendo / divisor;
            System.out.println("El resultado de la división es: " + resultado);
        }

        System.out.println(SEPARADOR);

        System.out.println(
                "Punto 3\nEscriba un programa que pregunte al usuario los coeficientes y calcule las raíces de una ecuación de segundo grado ax^2 + bx + c = 0.");
        System.out.println("Introduce el valor que multiplica a x^2");
        double a = scanner.nextDouble();
        System.out.println("Introduce el valor que multiplica a x");
        double b = scanner.nextDouble();
        System.out.println("Introduce el valor que no multiplica a ninguna x");
        double c = scanner.nextDouble();
        double parteRaiz = Math.pow(b, 2) - 4 * a * c;
        if (parteRaiz < 0) {
            System.out.println("La ecuación no tiene solución real");
        } else {
            double primeraSolucion = (-b + Math.sqrt(parteRaiz)) / 2 * a;
            double segundaSolucion = (-b - Math.sqrt(parteRaiz)) / 2 * a;
            System.out
                    .println("Las soluciones de la ecuación son:\nx1 = " + primeraSolucion + "\nx2 = " + segundaSolucion);
        }
    }
}
