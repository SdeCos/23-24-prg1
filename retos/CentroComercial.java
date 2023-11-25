import java.util.Scanner;
class CentroComercial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String SEPARADOR_DIA = "- ".repeat(30);
        final String SEPARADOR_RESUMEN = "=".repeat(45);
        
        boolean caja1Libre = true;
        boolean caja2Libre = true;
        boolean caja3Libre = true;
        boolean caja4Libre = true;
        boolean caja5Libre = true;
        
        int minutosPasados = 1;

        int packsClienteCaja1 = 0;
        int packsClienteCaja2 = 0;
        int packsClienteCaja3 = 0;
        int packsClienteCaja4 = 0;
        int packsClienteCaja5 = 0;
        
        double probabilidadLlegadaCliente = 60;
        
        final int MINIMO_PACKS_CLIENTE = 5;
        final int MAXIMO_PACKS_CLIENTE = 15;

        int itemsVendidosEnTotal = 0;

        int packsVendidosCaja1 = 0;
        int packsVendidosCaja2 = 0;
        int packsVendidosCaja3 = 0;
        int packsVendidosCaja4 = 0;
        int packsVendidosCaja5 = 0;


        int horaInicioJornada = 9;
        int horaFinJornada = 21;
        int horasTrabajo = horaFinJornada - horaInicioJornada;
        int minutosDiarios = horasTrabajo * 60;
        
        int clinetesAtendidosTotal = 0;
        int clientesEnCola = 0;
        int minutosColaVacia = 0;

        final int CLIENTES_PARA_QUINTA_CAJA = 15;
        int clientesAtendidosCaja5 = 0;
        final int MINIMO_CLIENTES_QUINTA_CAJA = 5;
        
        int cajaModificada = 0;

        int estadoCaja1 = 1;
        int estadoCaja2 = 1;
        int estadoCaja3 = 1;
        int estadoCaja4 = 1;
        int estadoCaja5 = 1;

        do{
            System.out.println("Introduce el numero de la caja que quieres cerrar (1 a 5), si le vuelves a pulsar se reabrirá, pulsar cualquier otro número no cerrará ninguna caja: ");
            cajaModificada = scanner.nextInt();
            if (cajaModificada == 1){
                estadoCaja1 += 1;
            } else if (cajaModificada == 2){
                estadoCaja2 += 1; 
            } else if (cajaModificada == 3){
                estadoCaja3 += 1;
            } else if (cajaModificada == 4){
                estadoCaja4 += 1;
            } else if (cajaModificada == 5){
                estadoCaja5 += 1;
            } else {
                System.out.println("No se ha modificado ninguna caja");
            }
            
            String llegada = "";
            double calculadoraCliente = Math.random() * 100;
            if (calculadoraCliente < probabilidadLlegadaCliente){
                clientesEnCola += 1;
                llegada += "Llega 1 persona";
            } else {
                llegada += "No llega nadie";
            }
            if (caja1Libre == false){
                if (packsClienteCaja1 > 0){
                    packsClienteCaja1 -= 1;
                } else {
                    caja1Libre = true;
                    clinetesAtendidosTotal += 1;
                    itemsVendidosEnTotal += packsVendidosCaja1;
                }
            }
    
            if (caja2Libre == false){
                if (packsClienteCaja2 > 0){
                    packsClienteCaja2 -= 1;
                } else {
                    caja2Libre = true;
                    clinetesAtendidosTotal += 1;
                    itemsVendidosEnTotal += packsVendidosCaja2;
                }
            }
    
            if (caja3Libre == false){
                if (packsClienteCaja3 > 0){
                    packsClienteCaja3 -= 1;
                } else {
                    caja3Libre = true;
                    clinetesAtendidosTotal += 1;
                    itemsVendidosEnTotal += packsVendidosCaja3;
                }
            }
    
            if (caja4Libre == false){
                if (packsClienteCaja4 > 0){
                    packsClienteCaja4 -= 1;
                } else {
                    caja4Libre = true;
                    clinetesAtendidosTotal += 1;
                    itemsVendidosEnTotal += packsVendidosCaja4;
                }
            }
            if (caja1Libre == true && clientesEnCola >= 1 && estadoCaja1 % 2 == 1){
                packsClienteCaja1 = (int) (Math.random() * (MAXIMO_PACKS_CLIENTE - MINIMO_PACKS_CLIENTE) + MINIMO_PACKS_CLIENTE);
                packsVendidosCaja1 = packsClienteCaja1;
                clientesEnCola -= 1;
                caja1Libre = false;
            } else if (caja2Libre == true && clientesEnCola >= 1 && estadoCaja2 % 2 == 1){
                packsClienteCaja2 = (int) (Math.random() * (MAXIMO_PACKS_CLIENTE - MINIMO_PACKS_CLIENTE) + MINIMO_PACKS_CLIENTE);
                packsVendidosCaja2 = packsClienteCaja2;
                clientesEnCola -= 1;
                caja2Libre = false;
            } else if (caja3Libre == true && clientesEnCola >= 1 && estadoCaja3 % 2 == 1){
                packsClienteCaja3 = (int) (Math.random() * (MAXIMO_PACKS_CLIENTE - MINIMO_PACKS_CLIENTE) + MINIMO_PACKS_CLIENTE);
                packsVendidosCaja3 = packsClienteCaja3;
                clientesEnCola -= 1;
                caja3Libre = false;
            } else if (caja4Libre == true && clientesEnCola >= 1 && estadoCaja4 % 2 == 1){
                packsClienteCaja4 = (int) (Math.random() * (MAXIMO_PACKS_CLIENTE - MINIMO_PACKS_CLIENTE) + MINIMO_PACKS_CLIENTE);
                packsVendidosCaja4 = packsClienteCaja4;
                clientesEnCola -= 1;
                caja4Libre = false;
            }


            if (clientesEnCola > CLIENTES_PARA_QUINTA_CAJA || clientesAtendidosCaja5 < MINIMO_CLIENTES_QUINTA_CAJA){
                if (caja5Libre == false){
                    if (packsClienteCaja5 > 0){
                    packsClienteCaja5 -= 1;
                    } else {
                        caja5Libre = true;
                        clinetesAtendidosTotal += 1;
                        clientesAtendidosCaja5 += 1;
                        itemsVendidosEnTotal += packsVendidosCaja5;
                    }
                }
                if (caja5Libre == true && clientesEnCola >= 1 && estadoCaja5 % 2 == 1){
                    packsClienteCaja5 = (int) (Math.random() * (MAXIMO_PACKS_CLIENTE - MINIMO_PACKS_CLIENTE) + MINIMO_PACKS_CLIENTE);
                    packsVendidosCaja5 = packsClienteCaja5;
                    clientesEnCola -= 1;
                    caja5Libre = false;
                }
            }

            if (clientesEnCola == 0){
                minutosColaVacia += 1;
            }

            System.out.println("Minuto " + minutosPasados + " - " + llegada + " - En Cola: " + clientesEnCola);
            System.out.println("Caja1:[" + packsClienteCaja1 + "] | Caja2:[" + packsClienteCaja2 + "] | Caja3:[" + packsClienteCaja3 + "] | Caja4:[" + packsClienteCaja4 + "] | Caja5:[" + packsClienteCaja5 + "]");
            System.out.println(SEPARADOR_DIA);
            // scanner.nextLine();
            minutosPasados += 1;
        }while (minutosPasados < minutosDiarios);
        System.out.println("RESUMEN");
        System.out.println(SEPARADOR_RESUMEN);
        System.out.println("Minutos con cola en cero      : " + minutosColaVacia);
        System.out.println("Personas en la cola al cierre : " + clientesEnCola);
        System.out.println("Personas atendidas en el dia  : " + clinetesAtendidosTotal);
        System.out.println("Articulos vendidos en el dia  : " + itemsVendidosEnTotal);
        System.out.println(SEPARADOR_RESUMEN);
    }    
}
