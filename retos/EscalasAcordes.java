import java.util.Scanner;

class EscalasAcordes {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        System.out.print("Ingrese la nota a trabajar:");

        for (int nota = 0; nota < notas.length; nota++){
            System.out.print(" " + (nota + 1) + ":" + notas[nota] + " ");
        }

        System.out.println();
        int notaElegida = (scanner.nextInt() - 1);

        System.out.println("Has elegido la nota " + notas[notaElegida]);
        

        System.out.print("La escala de " + notas[notaElegida] + " Mayor es: ");

        int avanceEscalaMayor[] = {0, 2, 4, 5, 7, 9, 11, 12};
        String[] escalaMayor = new String[8];

        for (int posicionEscala = 0; posicionEscala <= avanceEscalaMayor.length - 1; posicionEscala++){
            escalaMayor[posicionEscala] = notas[(notaElegida + avanceEscalaMayor[posicionEscala])%12];
            System.out.print("[" + escalaMayor[posicionEscala] + "] ");
        }


        int avanceAcorde[] = {0, 2, 4};
        System.out.print("\nEl acorde de " + notas[notaElegida] + " Mayor está conformado por: ");
        for (int posicionesAcorde = 0; posicionesAcorde <= avanceAcorde.length - 1; posicionesAcorde++){
            System.out.print("[" + escalaMayor[avanceAcorde[posicionesAcorde]] + "] ");
        }
    }
}
