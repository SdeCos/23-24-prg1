import java.util.Scanner;
public class Laberinto {
    
	private static int posicionXPersonaje, posicionYPersonaje;

	public static void main(String[] args){
			
		int[][] unMapa = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,2,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1},
			{1,2,2,2,0,3,3,3,0,1,0,1,1,0,0,0,0,0,1,0,1},
			{1,0,2,2,0,3,3,3,0,1,0,0,0,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0,1},
			{1,1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,1,1,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1},
			{1,0,1,1,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,1},
			{1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1},
			{1,0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1},
			{1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,1,0,1},
			{1,0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0,1},
			{1,1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,1,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,0,1,0,1},
			{1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1},
			{1,0,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1}
			};
		posicionXPersonaje=17; 
		posicionYPersonaje=21;

		do {
            
			imprimeMapa(unMapa);
		} while (procesaMovimiento(unMapa) && personajeDentro());
		if (!personajeDentro()){
			limpiarPantalla();
			System.out.println("Has escapado del laberinto");
		}
	}

	public static boolean personajeDentro() {
		if (posicionXPersonaje == 17 && posicionYPersonaje == 22) {return false;} else {return true;}
	}

	private static boolean procesaMovimiento(int[][] elMapa){

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		
		inputUsuario = entrada.nextLine();
		if (inputUsuario.equalsIgnoreCase("a") && elMapa[posicionYPersonaje][posicionXPersonaje-1]%2==0) {posicionXPersonaje=posicionXPersonaje-1;} else 
		if (inputUsuario.equalsIgnoreCase("d") && elMapa[posicionYPersonaje][posicionXPersonaje+1]%2==0) {posicionXPersonaje=posicionXPersonaje+1;} else 
		if (inputUsuario.equalsIgnoreCase("w") && elMapa[posicionYPersonaje-1][posicionXPersonaje]%2==0) {posicionYPersonaje=posicionYPersonaje-1;} else 
		if (inputUsuario.equalsIgnoreCase("s") && elMapa[posicionYPersonaje+1][posicionXPersonaje]%2==0) {posicionYPersonaje=posicionYPersonaje+1;} else 
		if (inputUsuario.equalsIgnoreCase("f")) { return false;}

		return true;
	}
	
	private static void imprimePersonaje(){
		System.out.print("\\O/");
	}

	private static void imprimeBordeHorizontal(int laLongitud){

		System.out.print("+");
		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println("+");		
	}
	
	private static void imprimeMapa(int[][] mapaPorImprimir){
		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		for (int i=0; i<mapaPorImprimir.length; i=i+1){
            System.out.print("|");
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
				if (puedoVer(i,j,999)) {
					if (i==posicionYPersonaje && j==posicionXPersonaje) {
						imprimePersonaje();
					} else {
						imprimeElemento(mapaPorImprimir[i][j]);
					}
				} else {
					System.out.print("   ");
				}
			}
            System.out.println("|");
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		System.out.println("Personaje en X:["+posicionXPersonaje+"] Y:["+posicionYPersonaje+"]");
	}

	private static boolean puedoVer(int i, int j, int alcanceVision) {

		return Math.pow(posicionXPersonaje-j,2)+Math.pow(posicionYPersonaje-i,2)<=Math.pow(alcanceVision,2);

	}

	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {" . ","[#]", "o.*","~ ~"};

		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

	static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
