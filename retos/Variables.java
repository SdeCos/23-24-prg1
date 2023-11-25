import java.util.Scanner;
class Variables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double valorPi = 3.141592;
        final String SEPARADOR = "=".repeat(20);
        
        System.out.println("Punto 1\nConocidos dos números, desarrolle un programa que calcule y muestre su promedio");
        
        System.out.print("Introduce el primer número: ");
        double primerNumero = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double segundoNumero = scanner.nextDouble();
        double media = Math.floor((primerNumero + segundoNumero) / 2 * 100) / 100;
        System.out.println("La media entre los dos números es " + media);
        
        System.out.println(SEPARADOR);

        System.out.println("Punto 2\nDesarrolle programas que permitan calcular el área de");
        
        System.out.println("    2.1.Un cuadrado");
        System.out.print("        Introduce la longitud del lado del cuadrado en metros: ");
        double lado = scanner.nextDouble();
        double areaCuadrado = Math.floor(Math.pow(lado, 2) * 100) / 100;
        System.out.println("        El área del cuadrado es de " + areaCuadrado + " metros cuadrados");
        
        System.out.println("    2.2.Un Rectángulo");
        System.out.print("        Introduce la longitud de la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("        Introduce la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        double areaRectangulo = Math.floor(base * altura * 100) / 100;
        System.out.println("        El área del rectángulo es de " + areaRectangulo + " metros cuadrados");

        System.out.println("    2.2.Un Círculo");
        System.out.print("        Introduce el radio del círculo: ");
        double radio = scanner.nextDouble();
        double areaCirculo = Math.floor(valorPi * Math.pow(radio, 2) * 100) / 100;
        System.out.println("        El área del círculo es de " + areaCirculo + " metros cuadrados");

        System.out.println(SEPARADOR);

        System.out.println("Punto 3\nDesarrolle un programa que, conociendo sus notas (parcial, final, evaluación contínua y evaluación del profesor), calcule su nota final en UNEATLANTICO.");
        
        double porcentajeEvaluacion = 10;
        double porcentajeParcial = 20;
        double porcentajeFinal = 65;
        double porcentajeProfesor = 5;
        double notaAprobado = 5;
        double notaProfesorAsumida = 5;
        
        System.out.print("    Introduce la nota de la evaluación continua: ");
        double notaEvaluacion = scanner.nextDouble();
        
        System.out.print("    Introduce la nota del parcial: ");
        double notaParcial = scanner.nextDouble();

        double notaFinalMinima = Math.floor((notaAprobado - (notaEvaluacion * porcentajeEvaluacion / 100) - (notaParcial * porcentajeParcial / 100) - (notaProfesorAsumida * porcentajeProfesor / 100)) * 100 / porcentajeFinal * 100) / 100;
        System.out.println("    Sabiendo estas notas y teniendo en cuenta que la nota de evaluación del profesor es un 5, la nota mínima necesaria en el examen final para aprobar la asignatura es de " + notaFinalMinima);
        
        System.out.print("    Introduce la nota de la evaluación del profesor: ");
        double notaProfesor = scanner.nextDouble();

        System.out.print("    Introduce la nota del final: ");
        double notaFinal = scanner.nextDouble();

        double notaAsignatura = (notaEvaluacion * porcentajeEvaluacion / 100) + (notaParcial * porcentajeParcial / 100) + (notaFinal * porcentajeFinal / 100) + (notaProfesor * porcentajeProfesor / 100);
        System.out.println("La nota final de la asignatura es " + notaAsignatura);
    }    
}
