class PruebaRandom{
    public static void main(String[] args) {
        int numero = 0;
        while (numero != 15){
            numero = numeroAleatorio(1,4);
            if (numero == 4){
                System.out.println(numero);    
            }
        }
    }
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo) + minimo);
    }
}