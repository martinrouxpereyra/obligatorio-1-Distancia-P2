package obligatorio.pkg1.distancia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import static obligatorio.pkg1.distancia.Interfaz.lector;

public class Sistema {

    private Interfaz _Interfaz;
    //public ArrayList<Jugador> _ListaJugadores;
    private HashMap<String, Jugador> _ListaJugadores;
    private Tablero _Tablero;
    private Partida _Partida;
    
    public Sistema() {
        //_ListaJugadores = new ArrayList();
        _ListaJugadores = new HashMap<String, Jugador>();
        _Interfaz = new Interfaz();
    }

    //GET lista jugadores   
    public HashMap<String, Jugador> listaJugadoresGet() {
        return _ListaJugadores;
    }

    public void listarJugadores() {

        int cont = 1;
        if (_ListaJugadores.size() > 0) {

            for (Entry<String, Jugador> j : _ListaJugadores.entrySet()) {

                System.out.println(cont + " - " + j.getValue().getNombre() + " - Alias( " +  j.getValue().getAlias() + " )");
                cont++;
            }
        }else{
            System.out.println("no hay jugadores regisrados");
        }

    }

    /* @Override
    public String toString(){
        
    }*/
    //switch que a partir de tu seleccion en menu ejecuta las funciones debidas
    public void menuPrincipal() {
        String opcion = "";

        while (true) {
            opcion = _Interfaz.invocarMenu();

            switch (opcion) {

                case "A":
                    _Interfaz.pedirDatosJugador();
                    break;

                /*case "E":
                    //this.elegirTablero();
                    break;*/
                    
                case "J":
                    _Interfaz.pedirDatosPartida();
                    break;

                case "R":
                    //this.mostrarRanking();
                    break;

                case "S":
                //this.finalizar();
            }

        }
    }

    public void registrarJugador(String pClave, Jugador pJugador) {

        //Agregar jugador al arraylist
        //_ListaJugadores.add(pJugador);
        //System.out.println(_ListaJugadores);
        _ListaJugadores.put(pClave, pJugador);
    }

    public void registrarPartida(Jugador jugadorAzul, Jugador jugadorRojo, String unaConfiguracion){
        
        _Partida = new Partida(jugadorAzul, jugadorRojo, unaConfiguracion); 
    }
    ////////////////////////////////////////////////////////////////////////////
    //validaciones a la hora de crear un jugador
    ////////////////////////////////////////////////////////////////////////////
    public boolean validarJugadorNombre(String pNombre) {

        //matches comprueba si un String cumple una expresión regular pasada como parámetro
        return pNombre.matches("[a-zA-Z]{1,20}");
    }

    public boolean validarJugadorEdad(String pEdad) {

        //Aca se valida que la edad no sea 0, que no sea 01,02,...09
        //y con match se comprueba que sean solo digitos entre 0-9 y de 1 0 2 cifras
        if (pEdad.equals("0")) {
            return false;
        }

        String edadAux = "";

        for (int i = 0; i <= 9; i++) {

            edadAux = "0" + i;

            if (pEdad.equals(edadAux)) {
                return false;
            }
        }
        return pEdad.matches("[0-9]{1,2}");
    }

    public boolean validarJugadorAlias(String pAlias) {
        //aca se valida la unicidad del alias

        String claveAEncontrar = pAlias;
        boolean estaClave = false;
        boolean valido;

        if (estaClave = _ListaJugadores.containsKey(claveAEncontrar)) {
            valido = false;
        } else {
            valido = true;
        }
        return valido;
    }
    
    ////////////////////////////////////////////////////////////////////////////
 
    ////////////////////////////////////////////////////////////////////////////
    //validaciones a la hora de crear una partida
    ////////////////////////////////////////////////////////////////////////////
    public String validarIndiceDelJugador(String unAlias) {

        while (!listaJugadoresGet().containsKey(unAlias)) {

            System.out.println("alias Incorrecto ingreselo nuevamente");

            unAlias = lector.nextLine();
        }

        return unAlias;
    }
    
    public String validarSeleccionDeTablero(String unTablero) {

        boolean confValida = false;
        
        do {
            
            unTablero = unTablero.toUpperCase().trim();

            if (unTablero.equals("S") || unTablero.equals("P1") || unTablero.equals("P2") ) {
                confValida = true;
            } else {
                System.out.println("\u001B[31mLa opcion no es valida, ingresela denuevo\033[0m");
                unTablero = lector.nextLine();
                System.out.println("");
            }

        } while (!confValida);
        
        System.out.println(unTablero);
        return unTablero;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
}
