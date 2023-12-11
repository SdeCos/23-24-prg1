public class Aspiradora {
    public static void main(String[] args) {
    final String ZONA_LIMPIA = " . ";
    final String ZONA_SUCIA = "...";
    final String ZONA_MAS_SUCIA = "ooo";
    final String ZONA_MUY_SUCIA = "OOO";
    final String ZONA_SUCISIMA = "***";
    final String ASPIRADORA = "(0)";
    final String GATO = "\"^\"";
    final String SOFA = "[####]";
    final String MESA = "``";

        for (int filas = 1; filas <= 14; filas ++){
            for (int columnas = 1; columnas <= 17; columnas++){
                System.out.print(ZONA_LIMPIA);
            }
            System.out.println();
        }
    }
}
