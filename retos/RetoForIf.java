class RetoForIf {
    public static void main(String[] args) {
        final String SEPARATOR = "=".repeat(62);
        System.out.println("Reto 1");
        System.out.println(SEPARATOR);
        int dimension = 21;

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                    i == 2 && j == 2
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 2");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                    i == 2
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 3");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                    j == 20
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 4");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i >= 8 && i <= 14    
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 5");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == 11 && j == 11    
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 6");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == 11 || j == 11    
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 7");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == j  
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 8");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == dimension + 1 - j  
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 9");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == dimension + 1 - j   || i == j 
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 10");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i > 0
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 11");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i != 11 || j != 11
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 12");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i != 11 && j != 11
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 13");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == j + 1 || i == j - 1
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 14");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == 2 || i == 20 || j == 2 || j == 20
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 15");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i > 1 && i < 6 || j > 1 && j < 6
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 16");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i != 1 && i != 21 && j != 1 && j != 21
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 17");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i == 2 && j <=20 && j >= 2 || i == 20 && j <=20 && j >= 2 || j == 20 && i <=20 && i >= 2 || j == 2 && i <=20 && i >= 2
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 18");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i <=5 && j <= 5
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
        System.out.println("Reto 19");
        System.out.println(SEPARATOR);

        for (int j = 1; j <= dimension; j = j + 1) {
            for (int i = 1; i <= dimension; i = i + 1) {

                if (
                // El código desde aqui
                i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1
                // El código hasta aquí
                ) {
                    System.out.print("(*)");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}