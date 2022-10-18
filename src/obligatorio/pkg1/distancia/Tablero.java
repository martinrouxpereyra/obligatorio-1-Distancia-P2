package obligatorio.pkg1.distancia;

public class Tablero {

    private String[][] tablero = new String[6][6];
    private int[][] matrizPos = {{6, 5, 4, 4, 5, 6}, {5, 3, 2, 2, 3, 5}, {4, 2, 1, 1, 2, 4}, {4, 2, 1, 1, 2, 4}, {5, 3, 2, 2, 3, 5}, {6, 5, 4, 4, 5, 6}};
    private String clave;

    public int getCantidadFichasInicialesRojas() {

        if (clave == "S") {
            return 18;
        }
        if (clave == "P1") {
            return 2;
        }
        if (clave == "P2") {
            return 1;
        }
        return 0;
    }

    public int getCantidadFichasInicialesAzules() {
        if (clave == "S") {
            return 18;
        }
        if (clave == "P1") {
            return 3;
        }
        if (clave == "P2") {
            return 2;
        }
        return 0;
    }

    public Tablero(String unaClave) {
        this.clave = unaClave;

        if (clave == "S") {
            this.tablero = this.tableroStandar();
        }
        if (clave == "P1") {
            this.tablero = this.tableroPrecargado1();
        }
        if (clave == "P2") {
            this.tablero = this.tableroPrecargado2();
        }
    }

    public String[][] tableroStandar() {

        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";

        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                if (y == 0 || y % 2 == 0) {

                    tablero[x][y] = A;
                } else {
                    tablero[x][y] = R;
                }
            }
        }

        return tablero;
    }

    public String[][] tableroPrecargado1() {

        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";

        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                if (x == 0 && y == 0) {
                    tablero[x][y] = R;
                } else {
                    if (x == 2 && y == 2) {
                        tablero[x][y] = A;
                    } else {
                        if (x == 3 && y == 5) {
                            tablero[x][y] = A;
                        } else {
                            if (x == 4 && y == 1) {
                                tablero[x][y] = A;
                            } else {
                                if (x == 5 && y == 3) {
                                    tablero[x][y] = R;
                                } else {
                                    tablero[x][y] = " ";
                                }
                            }
                        }
                    }
                }
            }
        }
        return tablero;
    }

    public String[][] tableroPrecargado2() {

        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";

        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                if (x == 0 && y == 0) {
                    tablero[x][y] = R;

                } else {
                    if (x == 5 && y == 4) {
                        tablero[x][y] = A;
                    } else {
                        if (x == 5 && y == 5) {
                            tablero[x][y] = R;
                        } else {
                            tablero[x][y] = " ";
                        }
                    }
                }
            }
        }
        return tablero;
    }

    public static void mostrarTableroJuego(String[][] unTablero) {

        String[] letras = {" A ", " B ", " C ", " D ", " E ", " F "};
        int cont = 0;
        mostrarNumHorizontales();

        System.out.println("   +-+-+-+-+-+-+");

        for (int x = 0; x < unTablero.length; x++) {

            for (int y = 0; y < unTablero[x].length; y++) {

                if (y == 0) {
                    System.out.print(letras[cont]);
                }

                if (y == 5) {

                    System.out.print("|" + unTablero[x][y] + "|");
                    System.out.print(letras[cont]);
                    cont++;
                } else {
                    System.out.print("|" + unTablero[x][y]);
                }

            }
            System.out.println("");
            System.out.println("   +-+-+-+-+-+-+");
        }
        mostrarNumHorizontales();
    }

    public static void mostrarNumHorizontales() {
        System.out.println("    1 2 3 4 5 6");
    }

    public void mostrarLetrasVerticales() {
        String[] letras = {"A", "B", "C", "D", "E", "F"};

    }

    private int getValorLetra(String pLetra) {

        int retorno = 0;

        switch (pLetra.toUpperCase()) {

            case "A":
                retorno = 0;
                break;

            case "B":
                retorno = 1;
                break;

            case "C":
                retorno = 2;
                break;

            case "D":
                retorno = 3;
                break;

            case "E":
                retorno = 4;
                break;

            case "F":
                retorno = 5;
                break;
        }

        return retorno;
    }
    
    public String getFichaPosicion(String pLetra, int pNumero){
            
        return tablero[getValorLetra(pLetra)][pNumero];          
    }
    
    public int getprofundidadPosicion(String pLetra, int pNumero){
            
        return matrizPos[getValorLetra(pLetra)][pNumero];          
    }
    
    


}