import java.util.Scanner;

class GuerreroVsVampiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vidaGuerrero = 150;
        int vidaVampiro = 60;

        final double DAÑO_ARMA_1 = 7;
        final double DAÑO_ARMA_2 = 15;
        final double DAÑO_ARMA_3 = 30;
        final double REDUCCION_DAÑO_DEFENSA = 5;

        final double PORCENTAJE_ACIERTO_ARMA_1 = 50;
        final double PORCENTAJE_ACIERTO_ARMA_2 = 25;
        final double PORCENTAJE_ACIERTO_ARMA_3 = 12;
        final double PORCENTAJE_ACIERTO_DEFENSA = 80;

        final double PORCENTAJE_ACIERTO_ATAQUE_1 = 90;
        final double PORCENTAJE_ACIERTO_ATAQUE_2 = 60;
        final double PORCENTAJE_ACIERTO_ATAQUE_3 = 40;
        
        final int TURNOS_PEDIDOS_POCION = 3;
        int turnosPocion = 0;

        boolean guerreroMuerto = false;
        boolean vampiroMuerto = false;
        boolean tomandosePocion = false;

        int eleccionAtaqueGuerrero = 0;
        int eleccionAtaqueVampiro = 0;
        int vidaGuerreroDebil = 30;
        int vidaVampiroDebil = 20;
    
        do {
            double dañoAtaque1 = 5;
            double dañoAtaque2 = 10;
            double dañoAtaque3 = 20;
            String informacionGuerrero = "";
            String informacionVampiro = "";
            double calculoAccionGuerrero = Math.random() * 100;
            double calculoGolpeVampiro = Math.random() * 100;
            
            
             if (tomandosePocion == true) {
                    if (turnosPocion < TURNOS_PEDIDOS_POCION){
                        turnosPocion ++;
                    } else if (turnosPocion == TURNOS_PEDIDOS_POCION){
                        vidaGuerrero = 150;
                        tomandosePocion = false;
                        turnosPocion = 0;
                    }
                } 
                if (vidaGuerrero >= vidaGuerreroDebil && tomandosePocion == false) {
                System.out.println("Vida guerrero: [" + vidaGuerrero + "] Vida Vampiro: [" + vidaVampiro + "]");
                System.out.println("""
                    +-----------------------------------------------------------------------------------+
                    |  Acción                            Daño                  Probabilidad Acierto     |
                    |    (1)                              7                            50%              |
                    |    (2)                              15                           25%              |
                    |    (3)                              30                           12%              |
                    |    (4) Defensa (Reduce el daño del vampiro en 5 puntos)          80%              |
                    |    (5) Poción (Inhabilita durante 3 turnos, si sobrevive, regenera toda la vida)  |
                    +-----------------------------------------------------------------------------------+""");
                    System.out.print("Elige el ataque a realizar: ");
                    eleccionAtaqueGuerrero = scanner.nextInt();
                    if (eleccionAtaqueGuerrero == 1 && calculoAccionGuerrero < PORCENTAJE_ACIERTO_ARMA_1) {
                        vidaVampiro -= DAÑO_ARMA_1;
                        informacionGuerrero = "El ataque del guerrero acertó, quitandole " + DAÑO_ARMA_1 + " puntos de vida al vampiro";
                    } else if (eleccionAtaqueGuerrero == 2 && calculoAccionGuerrero < PORCENTAJE_ACIERTO_ARMA_2) {
                        vidaVampiro -= DAÑO_ARMA_2;
                        informacionGuerrero = "El ataque del guerrero acertó, quitandole " + DAÑO_ARMA_2 + " puntos de vida al vampiro";
                    } else if (eleccionAtaqueGuerrero == 3 && calculoAccionGuerrero < PORCENTAJE_ACIERTO_ARMA_3) {
                        vidaVampiro -= DAÑO_ARMA_3;
                        informacionGuerrero = "El ataque del guerrero acertó, quitandole " + DAÑO_ARMA_3 + " puntos de vida al vampiro";
                    } else if (eleccionAtaqueGuerrero == 4 && calculoAccionGuerrero < PORCENTAJE_ACIERTO_DEFENSA) {
                        dañoAtaque1 = dañoAtaque1 - 5;
                        dañoAtaque2 = dañoAtaque2 - 5;
                        dañoAtaque3 = dañoAtaque3 - 5;
                        informacionGuerrero = "El guerrero se ha defendido, reduciendo el daño del vampiro en " + REDUCCION_DAÑO_DEFENSA + " puntos";
                    } else if (eleccionAtaqueGuerrero == 5){
                        tomandosePocion = true;
                        informacionGuerrero = "El guerrero se ha tomado una pocion, quedara inhabilitado durante " + TURNOS_PEDIDOS_POCION + " turnos";
                    }
                    else {
                        informacionGuerrero = "La acción del guerrero falló";
                    }
    
                } else if (tomandosePocion == true){
                    informacionGuerrero = "El guerrero se está tomando la poción, le quedan " + (TURNOS_PEDIDOS_POCION - turnosPocion) + " turnos para acabar";
                } else {
                    informacionGuerrero = "El guerrero está debil, se ha desmallado, recuerará 2 puntos de vida por turno";
                    vidaGuerrero += 2;
                }
                
                if (vidaVampiro >= vidaVampiroDebil) {
                    eleccionAtaqueVampiro = (int) (Math.random() * 3 + 1);
                    
                    if (eleccionAtaqueVampiro == 1 && calculoGolpeVampiro < PORCENTAJE_ACIERTO_ATAQUE_1) {
                        vidaGuerrero -= dañoAtaque1;
                        informacionVampiro = "El ataque del vampiro acertó, quitandole " + dañoAtaque1 + " puntos de vida al guerrero";
                    } else if (eleccionAtaqueVampiro == 2 && calculoGolpeVampiro < PORCENTAJE_ACIERTO_ATAQUE_2) {
                        vidaGuerrero -= dañoAtaque2;
                        informacionVampiro = "El ataque del vampiro acertó, quitandole " + dañoAtaque2 + " puntos de vida al guerrero";
                    } else if (eleccionAtaqueVampiro == 3 && calculoGolpeVampiro < PORCENTAJE_ACIERTO_ATAQUE_3) {
                        vidaGuerrero -= dañoAtaque3;
                        informacionVampiro = "El ataque del vampiro acertó, quitandole " + dañoAtaque3 + " puntos de vida al guerrero";
                    } else {
                        informacionVampiro = "El ataque del vampiro falló";
                    }
                } else {
                    informacionVampiro = "El vampiro está debil, se ha desmallado, recuperará 2 puntos de vida por turno";
                    vidaVampiro += 2;
                }

                System.out.println(informacionGuerrero + "\n" + informacionVampiro);
                scanner.nextLine();
                guerreroMuerto = vidaGuerrero <= 0;
                vampiroMuerto = vidaVampiro <= 0;
                
            } while (guerreroMuerto == false && vampiroMuerto == false);
            System.out.println(guerreroMuerto == true ? "El vampiro ganó la pelea" : "El gerrero ganó la pelea");
            
        }
    }
    