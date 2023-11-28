class PruebaRandom{
    public static void main(String[] args) {
        int numero = 0;
        while (numero != 11){
            numero = numeroAleatorio(1,10);
            if (numero == 10){
                System.out.println(numero);    
            }
        }
    }
    static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo) + minimo);
    }
}