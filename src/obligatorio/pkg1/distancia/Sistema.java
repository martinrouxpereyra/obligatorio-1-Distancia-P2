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

                System.out.println(cont + " - " + j.getValue().getNombre() + " - Alias( " + j.getValue().getAlias() + " )");
                cont++;
            }
        } else {
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
                    this.comenzarPartida();
                    break;

                case "R":
                    //this.mostrarRanking();
                    break;

                case "S":
                //this.finalizar();
            }

        }
    }

    public void comenzarPartida() {
        _Interfaz.pedirDatosPartida();

        this.jugarPartida();
    }

    public void jugarPartida() {
        String turno = "R";
        String jugada;

        while (jugarTurno(turno) != -1) {

        }

        //aca tengo que mostrar los datos del ganador
        System.out.println("termino juego");
    }

    private int jugarTurno(String pTurno) {

        HashMap<String,String> listaMovimientosValidos;
        
        //devuelvo -1 si finzaliza el juego, de lo contrario devuelvo 1
        String jugada;

        //punto 1, 2 y 3 del turno
        jugada = _Interfaz.pedirJugadaOrigen(pTurno).toUpperCase();

        if (jugada == "X") {
            return -1;
        }

        //punto 4 - averiguar movimientos validos
        listaMovimientosValidos = getMovimientosValidos(jugada, pTurno);
        //funcion encontrar posiciones
        
        //punto 5 - mostrar movimientos validos
        
        //punto 6,7,8 
        //jugada = _Interfaz.pedirJugadaDestino(pTurno).toUpperCase();

        if (jugada == "X") {
            return -1;
        }
        
        //punto 9 - realizar movimiento
        
        //punto 10 reDibujar tablero
        
        return 1;
    }

    private HashMap<String,String> getMovimientosValidos(String pJugadaOrigen, String pTurno){
        
       HashMap<String,String> miLista = new HashMap<String,String>();
       //averiguar profundidad origen
       //
       
       return miLista;
    }
    
    
    private String getXjugada(String pJugada) {

        return pJugada.substring(0, 1);
        //int indicePos = Character.getNumericValue(pJugada.charAt(1));      
    }

    private int getYjugada(String pJugada) {

        return Integer.parseInt(pJugada.substring(1, 2));
    }

    public void registrarJugador(String pClave, Jugador pJugador) {

        //Agregar jugador al arraylist
        //_ListaJugadores.add(pJugador);
        //System.out.println(_ListaJugadores);
        _ListaJugadores.put(pClave, pJugador);
    }

    public void registrarPartida(Jugador jugadorAzul, Jugador jugadorRojo, String unaTipoTablero) {

        _Partida = new Partida(jugadorAzul, jugadorRojo, new Tablero(unaTipoTablero));
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

            if (unTablero.equals("S") || unTablero.equals("P1") || unTablero.equals("P2")) {
                confValida = true;
            } else {
                System.out.println("\u001B[31mLa opcion no es valida, ingresela denuevo\033[0m");
                unTablero = lector.nextLine();
                System.out.println("");
            }

        } while (!confValida);

        // System.out.println(unTablero);
        Tablero tablero = new Tablero(unTablero);
        return unTablero;
    }
    ////////////////////////////////////////////////////////////////////////////

    public boolean validarJugadaOrigen(String pJugada, String pTurno) {

        if (pJugada.length() != 2) {
            return false;
        }

        String letraPos = getXjugada(pJugada).toUpperCase();
        int indicePos = getYjugada(pJugada);

        System.out.println(letraPos);
        System.out.println(indicePos);

        if (letraPos == "X") {
            return true;
        }

        if (!(letraPos == "A" || letraPos == "B") || letraPos == "C" || letraPos == "D" || letraPos == "E" || letraPos == "F") {
            return false;
        }

        if (indicePos < 1 || indicePos > 6) {
            return false;
        }

        //punto 3 del turno
        String ficha = _Tablero.getFichaPosicion(letraPos, indicePos);

        if (pTurno != ficha) {
            return false;
        }

        return true;
    }

    public int contarFichasAzul() {
        return 0;
    }

    public int contarFichasRojo() {
        return 0;
    }

    public String[][] moverFicha() {
        //leer la coordenada y ver que posiciones corresponde
        // validar que sea valida
        // llamar a armarMatrizOpciones 
        // pedirle que elija a cual lugar mover la ficha
        //validaar que ingreso uno valido (que el lugar esta a +1 en la posicion y que es del color opuesto
        // lo actualizas
        //llamas a contarFichasAzul y contarFichasRojo, si alguno llego a cero termino el juego perri
        return null;
    }

    // armar la matriz con las opciones que tiene para moverse una vez que te pasaron las coordenadas
    public String[][] armarMatrizOpciones() {
        return null;
    }

}
