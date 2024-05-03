
import java.util.Scanner;

import javax.swing.SpinnerDateModel;
public class Jano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String[] sintomas = {"Fiebre", "Escalofrios", "Tos", "Respidacion corta", "Dificultad para respirar", "Fatiga", "Dolor muscular o del cuerpo", "Dolor de cabeza", "Perdida del olfato o gusto", "Dolor de garganta", "Congestión nasal", "Vomito", "Diarrea"};
        System.out.println("Tienes algunos de los siguientes sintomas? 0=No / Otro=Si");
        for (int i=0;i<sintomas.length;i++){
            System.out.println(sintomas[i]);
        }
        
        String salida0 = "Quédese an casa hasta que mejoren los síntomas, usualmente después de 24 horas sin fiebre y sin uso de medicamentos para reducir fiebre.";
        String salida1 = "1. Quédese en casa hasta que los síntomas hayan mejorade de acuerdo con la política de cuidado infantil existente, usualmente 24 horas sin fiebre y sin usar medicamentos para reducir fiebre. \n 2. Luego use el arbol de decisiona para contacto cercano y cuarentena para determinar cuando se permite regreasr al trabajo o al cuidado infantil";
        String salida2 = "Regresar en o después de 6 días a partir del comienzo de síntomas, si los sintomas han mejorado y han pasado más de 24 horas sin fiebre y sin el uso de medicamentos para reducir fiebre. \n Desde día 6 al 10 debe usar una mascarilla que se ajuste perfectamente sobre boca y nariz mientras se está en interiores y cuando está con otras personas en lugares abiertons. Si esta exento del uso de mascarilla se requiere que vuelva el día 11.";
        String salida3 = "Regresar en o después de 11 días a partir del comienzo de los síntomas has mejorado y han pasado 24 horas sin fiebre o sin el uso de medicamentos para reducir fiebre.";
        String salida4 = "Permitir el regreso a la escuela o trabajo";
        
        opcion = scanner.nextInt();
        if(opcion == 0){
            System.out.println("Hasta la proxima!");
        } else {
            System.out.println("¿Hay una condición cronica preexistente documentada que explica los sintomas? 0=No / Otro=Si");
            opcion = scanner.nextInt();
            if (opcion == 0){
                System.out.println("Resultado de la prueba COVID tomada después del comienzo de sintomas? 0=Negativo / Otro=Positivo o prueba no realizada");
                opcion = scanner.nextInt();
                if (opcion == 0){
                    System.out.println("¿Que tipo de prueba se daministro? 0=Molecular / 1=Antígenos");
                    opcion = scanner.nextInt();
                    if (opcion == 0){
                        System.out.println("¿Fue la persona identificada con contacto cercano los ultimos 14 dias? 0=No / Otro=Si");
                        opcion = scanner.nextInt();
                        if (opcion==0){
                            System.out.println(salida0);
                        } else {
                            System.out.println(salida1);
                        }
                    } else {
                        System.out.println("¿Salió negativa la prueba molecular de seguimiento (tomada dentro de 48 horas)? 0=No / Otro=Si");
                        opcion = scanner.nextInt();
                        if (opcion == 0){
                            System.out.println("¿Puede la persona proporcionar evidencia de un diagnóstico negativo, de una muestra recolectada en el día 5 o más tarde? 0=No / Otro=Si");
                            if (opcion == 0){
                                System.out.println(salida3);
                            } else {
                                System.out.println(salida2);
                            }
                        }
                    }
                } else {
                    System.out.println("¿La persona puede y esta dispuesta a usar mascarilla los días 6-10? 0=No / Otro=Si");
                    if (opcion == 0){
                        System.out.println(salida3);
                    } else {
                        System.out.println("¿Puede la persona proporcionar evidencia de un diagnóstico negativo, de una muestra recolectada en el día 5 o más tarde? 0=No / Otro=Si");
                        if (opcion == 0){
                            System.out.println(salida3);
                        } else{
                            System.out.println(salida2);
                        }
                    }
                }
            } else{
                System.out.println("¿Fue la persona identificada como contacto cercano los últimos 14 dias? 0=No / Otro=Si");
            }
        }
    }
}
