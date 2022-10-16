package obligatorio.pkg1.distancia;

import java.util.Scanner;

public class Interfaz {

    static Scanner lector;
    private static String[][] opciones;
    private static Sistema miSist;
    //private static Tablero _Tablero;

    public static void main(String[] args) {

        miSist = new Sistema();
        // _Tablero = new Tablero();

        inicializarOpciones();
        miSist.menuPrincipal();
    }

    //----------------------------------------------------------------
    //se inicializan las opciones y llama a invocar menu
    //----------------------------------------------------------------
    public static void inicializarOpciones() {

        opciones = new String[5][2];
        opciones[0][0] = "A - Registrar Jugador";
        opciones[0][1] = "A";

        /*opciones[1][0] = "E - Establecer tablero";
        opciones[1][1] = "E";*/
        opciones[2][0] = "J - Jugar Partida";
        opciones[2][1] = "J";

        opciones[3][0] = "R - Ranking";
        opciones[3][1] = "R";

        opciones[4][0] = "S - Salir";
        opciones[4][1] = "S";

    }
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    //mostrar menu
    //----------------------------------------------------------------
    private static void mostrarMenu() {

        System.out.println("Menu principal:");
        System.out.println("");

        for (int i = 0; i < opciones.length; i++) {

            System.out.println(opciones[i][0]);
        }
    }
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    //funcion que valida la opcion elegida
    //----------------------------------------------------------------
    private static boolean validarOpcion(String opcion) {

        boolean esValida = false;

        for (int i = 0; i < opciones.length && !esValida; i++) {

            if (opcion.equals(opciones[i][1])) {
                esValida = true;
            }
        }

        return esValida;
    }

    //----------------------------------------------------------------
    //funcion que invoca al menu y pide una opcion
    //----------------------------------------------------------------
    public static String invocarMenu() {

        String opcion = "";
        boolean esOpcionValida;
        lector = new Scanner(System.in);

        do {

            mostrarMenu();
            opcion = lector.nextLine().toUpperCase();

            esOpcionValida = validarOpcion(opcion);

            if (!esOpcionValida) {
                System.out.println("la opcion no es valida, por favor ingrese otra");
                System.out.println("");
            }

        } while (!esOpcionValida);

        System.out.println(opcion);
        return opcion;
    }
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    //funcion que pide los datos del jugador, manda a sistema para que los valide
    //crea un nuevo jugador y llama a una funcion de sistema para agregarlo a la lista
    //----------------------------------------------------------------
    public void pedirDatosJugador() {

        ////////////////////////////////////////////////////////////////////
        //pedido del nombre y sistema valida que sea un nombre valido
        ////////////////////////////////////////////////////////////////////
        lector = new Scanner(System.in);

        System.out.println("ingrese nombre del jugador");
        String nombreJugador;
        boolean nombreValido;

        do {

            nombreValido = true;
            nombreJugador = lector.nextLine().toUpperCase();

            if (!miSist.validarJugadorNombre(nombreJugador)) {
                nombreValido = false;
                System.out.println("nombre invalido, ingreselo nuevamente");
            }
        } while (!nombreValido);

        //////////////////////////////////////////////////////////////////// 
        ////////////////////////////////////////////////////////////////////
        //pedido del edad y sistema valida que sea una edad valida
        ////////////////////////////////////////////////////////////////////
        System.out.println("ingrese la edad del juador");
        String edadJugador;
        boolean edadValida;

        do {

            edadValida = true;
            edadJugador = lector.nextLine();

            if (!miSist.validarJugadorEdad(edadJugador)) {
                edadValida = false;
                System.out.println("edad invalida, ingresela nuevamente");
            }

        } while (!edadValida);

        ////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////
        //pedido del alias y sistema se encarga de verificar unicidad
        ////////////////////////////////////////////////////////////////////
        System.out.println("ingrese un alias para el jugador");
        String aliasJugador;
        boolean aliasValido;

        do {
            aliasValido = true;
            aliasJugador = lector.nextLine();
            if (!miSist.validarJugadorAlias(aliasJugador)) {
                aliasValido = false;
                System.out.println("alias invalido, ingreselo nuevamente");
            }

        } while (!aliasValido);

        Jugador miJugador = new Jugador(nombreJugador, edadJugador, aliasJugador);

        miSist.registrarJugador(aliasJugador, miJugador);

    }
    //----------------------------------------------------------------

    public void pedirDatosPartida() {

        Jugador jugadorAzul;
        Jugador jugadorRojo;

        String indiceJugadorA = "";
        String indiceJugadorR = "";

        miSist.listarJugadores();

        //pide alias para jugador azul
        System.out.println("ingrese un alias de la lista para elegir el Jugador Azul");
        indiceJugadorA = lector.nextLine();

        validarIndiceDelJugador(indiceJugadorA);
        jugadorAzul = miSist.listaJugadoresGet().get(indiceJugadorA);
        //System.out.println(jugadorAzul);
        //////////////////////////////////////////////////////////////////////////////|

        //pide alias para jugador rojo
        System.out.println("ingrese un alias de la lista para elegir el Jugador Rojo");
        indiceJugadorR = lector.nextLine();

        validarIndiceDelJugador(indiceJugadorR);
        jugadorRojo = miSist.listaJugadoresGet().get(indiceJugadorR);
        //System.out.println(jugadorRojo);
        //////////////////////////////////////////////////////////////////////////////|

        String tablero = "";
        String[][] tableroElegido;
        
        System.out.print("seleccione el tablero a utilizar: ");
        System.out.println(" S|Standar, P1|precargado 1, P2|precargado2");
        tablero = lector.nextLine().toUpperCase().trim();
        //System.out.println(tablero);
        validarSeleccionDeTablero(tablero);
        //llamar a funcion de sistema

    }

    public String validarIndiceDelJugador(String unAlias) {

        while (!miSist.listaJugadoresGet().containsKey(unAlias)) {

            System.out.println("alias Incorrecto ingreselo nuevamente");

            unAlias = lector.nextLine();
        }

        return unAlias;
    }

    public String validarSeleccionDeTablero(String unTablero) {

        /*while (!unTablero.equals("S") || !unTablero.equals("P1") || !unTablero.equals("P2")) {
            
            System.out.println("seleccion de tablero invalido, ingreselo nuevamente");
            unTablero = lector.nextLine();
        }*/
        
        while(!unTablero.matches("S") || !unTablero.matches("P1") ||!unTablero.matches("P2") ){
            
            System.out.println("seleccion de tablero invalido, ingreselo nuevamente");
            unTablero = lector.nextLine();
        }
        
        return unTablero;
    }
}
