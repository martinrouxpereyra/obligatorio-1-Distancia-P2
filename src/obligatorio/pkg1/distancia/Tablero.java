//Martin Roux 254820 - Gaspar Flom 264135
package obligatorio.pkg1.distancia;

public class Tablero {

    private String[][] tablero = new String[6][6];
    private int[][] matrizPos = {{6, 5, 4, 4, 5, 6}, {5, 3, 2, 2, 3, 5}, {4, 2, 1, 1, 2, 4}, {4, 2, 1, 1, 2, 4}, {5, 3, 2, 2, 3, 5}, {6, 5, 4, 4, 5, 6}};
    private String clave;

  
    public Tablero(String unaClave) {
        this.clave = unaClave;
        
        if (clave.equals("S")) {           
            inicializarTableroStandar();
        }
        
        if (clave.equals("P1")) {
            inicializarTableroPrecargado1();
        }
        if (clave.equals("P2")) {
            inicializarTableroPrecargado2();
        }
    }
    
    
    public int getCantidadFichasInicialesRojas() {

        if (clave.equals("S")) {
            return 18;
        }
        if (clave.equals("P1")) {
            return 2;
        }
        if (clave.equals("P2")) {
            return 1;
        }
        return 0;
    }
    
    public int getCantidadFichasInicialesAzules() {
        if (clave.equals("S")) {
            return 18;
        }
        if (clave.equals("P1")) {
            return 3;
        }
        if (clave.equals("P2")) {
            return 2;
        }
        return 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //metodos de inicializacion de los tableros
    ////////////////////////////////////////////////////////////////////////////
    public void inicializarTableroStandar() {

        String R = "R";
        String A = "A";

        //System.out.println("inicializar tablero tablero.length " + tablero.length);
        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                if (x % 2 == 0) {
                    
                    if (y % 2 == 0) {

                        tablero[x][y] = A;
                    } else {
                        tablero[x][y] = R;
                    }
                }else{
                    if (y % 2 == 0) {

                        tablero[x][y] = R;
                    } else {
                        tablero[x][y] = A;
                    }
                }
            }
        }
    }

    public void inicializarTableroPrecargado1() {

        String R = "R";
        String A = "A";

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
    }

    public void  inicializarTableroPrecargado2() {

        String R = "R";
        String A = "A";

        for (int x = 0; x < tablero.length; x++) {

            for (int y = 0; y < tablero[x].length; y++) {

                if (x == 0 && y == 0) {
                    tablero[x][y] = R;

                } else {
                    if (x == 5 && y == 4) {
                        tablero[x][y] = A;
                    } else {
                        if (x == 5 && y == 5) {
                            tablero[x][y] = A;
                        } else {
                            tablero[x][y] = " ";
                        }
                    }
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    //metodos urilizados para mostrar la matriz
    ///////////////////////////////////////////////////////////////////////////
    public void mostrarTableroJuego() {
        
        String[] letras = {" A ", " B ", " C ", " D ", " E ", " F "};
        int cont = 0;
        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";
        String E = "\u001B[32mE\u001B[0m";
        String numeral = "\u001B[32m#\u001B[0m";
        String asterisco = "\u001B[32m*\u001B[0m";
        
        mostrarNumHorizontales();

        System.out.println("   +-+-+-+-+-+-+");

        for (int x = 0; x < tablero.length; x++) {

            String[] miLinea = new String[6];
            
            for (int y = 0; y < tablero[x].length; y++) {
                
                switch(tablero[x][y]){
                    case "R":
                        miLinea[y] = R;
                        break;
                    
                    case "A":
                        miLinea[y] = A;
                        break;
                    
                    case "#":
                        miLinea[y] = numeral;
                        break;
                        
                    case "*":
                        miLinea[y] = asterisco;
                        break;
                        
                    case "E":
                        miLinea[y] = E;
                        break;
                     
                    case " ":
                        miLinea[y] = " ";
                        break;
                }
                
                if (y == 0) {
                    System.out.print(letras[cont]);
                }

                if (y == 5) {

                    System.out.print("|" + miLinea[y] + "|");
                    System.out.print(letras[cont]);
                    cont++;
                } else {
                    System.out.print("|" + miLinea[y]);
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
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    //metodos que nos ayudan a conseguir la profundidad y la posicion de una ficha
    //el valor que recibe de la coordenada y es de 1 a 6 y le hace -1
    ///////////////////////////////////////////////////////////////////////////
    public int getValorLetra(String pLetra) {

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
            
        return getFichaPosicion(getValorLetra(pLetra),pNumero);
    }
    
    public String getFichaPosicion(int pNumerox, int pNumeroy){
            
        //System.out.println("getFichaPos " + pNumerox + " " + pNumeroy);
        return tablero[pNumerox][pNumeroy-1];          
    }
    
    public String getFichaPosicion(String pJugada){
        
        String letra = pJugada.substring(0, 1);
        int numero = Integer.parseInt(pJugada.substring(1, 2));
        
        return getFichaPosicion(letra, numero);
        
    }
    
    public int getprofundidadPosicion(String pLetra, int pNumero){
            
        return getprofundidadPosicion(getValorLetra(pLetra),pNumero);
    }
    
    public int getprofundidadPosicion(int pNumerox, int pNumeroy){
            
        return matrizPos[pNumerox][pNumeroy-1];          
    }
    
    public int getprofundidadPosicion(String pJugada){
        
        String letra = pJugada.substring(0, 1);
        int numero = Integer.parseInt(pJugada.substring(1, 2));
        
        return getprofundidadPosicion(letra, numero);
        
    }
    ///////////////////////////////////////////////////////////////////////////
  
    public void setFichaPosicion(String pJugada, String pValor){
        
        String letra = pJugada.substring(0, 1);
        int numero = Integer.parseInt(pJugada.substring(1, 2));
        
        setFichaPosicion(getValorLetra(letra), numero, pValor);
    }
    
    public void setFichaPosicion(int pNumerox, int pNumeroy, String pValor){
            
        tablero[pNumerox][pNumeroy-1] = pValor;          
    }
    


}