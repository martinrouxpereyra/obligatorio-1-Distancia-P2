package obligatorio.pkg1.distancia;

import java.util.Scanner;

public class Interfaz {

    static Scanner lector;
    private static String[][] opciones;
    private static Sistema miSist;

    public static void main(String[] args) {

        miSist = new Sistema();

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

        opciones[1][0] = "E - Establecer tablero";
        opciones[1][1] = "E";

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
        String aliasJugador = lector.nextLine();
        boolean aliasValido;
        
        do{
            aliasValido = true;
            if(!miSist.validarJugadorAlias(aliasJugador)){
                aliasValido = false;
                System.out.println("alias invalido, ingreselo nuevamente");
            }
            
        }while(!aliasValido);
        
        
        Jugador miJugador = new Jugador(nombreJugador, edadJugador, aliasJugador);
        
        miSist.registrarJugador(miJugador);
        
       

    }
    ////////////////////////////////////////////////////////////////////

}
