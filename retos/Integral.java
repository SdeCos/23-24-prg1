import java.util.Scanner;
public class Integral {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    double y = 0;
    double resultado = 0;
    for (double x = a; x<=b; x=x+0.001 ){
        y = 3 * Math.pow(x, 2) + 2 * x;
        resultado += y*0.001;
    }
    System.out.println(resultado);
}
}