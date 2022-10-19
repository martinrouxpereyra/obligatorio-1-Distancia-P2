//Martin Roux 254820 - Gaspar Flom 264135
package obligatorio.pkg1.distancia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import static obligatorio.pkg1.distancia.Interfaz.lector;

public class Sistema{

    private Interfaz _Interfaz;
    //public ArrayList<Jugador> _ListaJugadores;
    private HashMap<String, Jugador> _ListaJugadores;
    private List<Jugador> _ListaRanking;
    private Partida _Partida;
    private String[] arrayLetras = {"A", "B", "C", "D", "E", "F"};
    private HashMap<String, Integer> _ValorLetras;

    public Sistema() {

        _ListaRanking = new ArrayList<Jugador>();
        _ListaJugadores = new HashMap<String, Jugador>();
        _Interfaz = new Interfaz();
        _ValorLetras = new HashMap<String, Integer>();
        _ValorLetras.put("A", 0);
        _ValorLetras.put("B", 1);
        _ValorLetras.put("C", 2);
        _ValorLetras.put("D", 3);
        _ValorLetras.put("E", 4);
        _ValorLetras.put("F", 5);
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

    public void menuPrincipal() {
        String opcion = "";

        while (true) {
            opcion = _Interfaz.invocarMenu();

            switch (opcion) {

                case "A":
                    _Interfaz.pedirDatosJugador();
                    break;

                case "J":
                    this.comenzarPartida();
                    break;

                case "R":
                    mostrarRanking();
                    break;

                case "S":
                    return;
            }
        }
    }

    public void comenzarPartida() {

        _Interfaz.pedirDatosPartida();

        this.jugarPartida();
    }

    public void jugarPartida() {

        Jugador ganador;
        String turno = "R";
        String jugada;
        boolean salir = false;
        int retornoJugarTurno;
        
        while (!salir) {

            retornoJugarTurno = jugarTurno(turno);
            
            if (retornoJugarTurno == -1) {
                salir = true;
                _Partida.setGanador(siguienteTurno(turno));
            }
            
            if (retornoJugarTurno == 0) {
                salir = true;
            }

            turno = siguienteTurno(turno);

            
        }

        //aca tengo que mostrar los datos del ganador
        ganador = _Partida.getGanador();
        System.out.println("Ganador: " + ganador);
    }

    public void registrarJugador(String pClave, Jugador pJugador) {

        //Agregar jugador al arraylist
        //_ListaJugadores.add(pJugador);
        //System.out.println(_ListaJugadores);
        _ListaJugadores.put(pClave, pJugador);
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

    public void registrarPartida(Jugador jugadorAzul, Jugador jugadorRojo, String unTipoTablero) {

        _Partida = new Partida(jugadorAzul, jugadorRojo, new Tablero(unTipoTablero));
        cargarArrayList(_ListaJugadores);
    }

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
        return unTablero;
    }
    ////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////
    //validaciones de las jugadas de origen y destino
    ////////////////////////////////////////////////////////////////////////////
    public boolean validarJugadaOrigen(String pJugada, String pTurno) {

        if (pJugada.length() > 2) {
            return false;
        }
        String letraPos = getXjugada(pJugada).toUpperCase();

        if (letraPos.equals("X")) {
            return true;
        }

        if (pJugada.length() == 1) {
            return false;
        }

        int indicePos = getYjugada(pJugada);

        if (!(letraPos.equals("A") || letraPos.equals("B") || letraPos.equals("C") || letraPos.equals("D") || letraPos.equals("E") || letraPos.equals("F"))) {
            //System.out.println("adaaas");
            return false;
        }

        if (indicePos < 1 || indicePos > 6) {
            //System.out.println("ad");
            return false;
        }

        //punto 3 del turno
        String ficha = _Partida.getTablero().getFichaPosicion(letraPos, indicePos);

        if (!(pTurno.equals(ficha))) {
            //System.out.println("adentro del if condicion " + (!(pTurno.equals(ficha))));
            //System.out.println("adentro del if " + pTurno + " " + ficha);
            return false;
        }

        return true;
    }

    public boolean validarJugadaDestino(String pJugada, HashMap<String, String> pMiListaMovimientosValidos) {

        if (pJugada.length() > 2) {
            return false;
        }

        String letraPos = getXjugada(pJugada).toUpperCase();

        if (letraPos.equals("X")) {
            return true;
        }

        if (letraPos.equals("P")) {
            if (pMiListaMovimientosValidos.size() == 0) {
                return false;
            }else{
                return true;
            }
        }

        if (pJugada.length() == 1) {
            return false;
        }

        int indicePos = getYjugada(pJugada);

        if (!(letraPos.equals("A") || letraPos.equals("B") || letraPos.equals("C") || letraPos.equals("D") || letraPos.equals("E") || letraPos.equals("F"))) {
            return false;
        }

        if (indicePos < 1 || indicePos > 6) {
            return false;
        }

        //validar contra la lista de movimientos validos
        if (!pMiListaMovimientosValidos.containsKey(pJugada)) {

            return false;
        }

        return true;
    }
    ////////////////////////////////////////////////////////////////////////////
 
    public void cargarArrayList(HashMap<String, Jugador> miListaJugadores){
        for (HashMap.Entry<String, Jugador> entry : _ListaJugadores.entrySet()) {
            
            _ListaRanking.add(entry.getValue());
        }
    }
    public void mostrarRanking(){
               
        for(Jugador unJugador : _ListaRanking){
            System.out.println(unJugador);
            
        }
        System.out.println("");
    }
    ////////////////////////////////////////////////////////////////////////////
    //funciones privadas
    ////////////////////////////////////////////////////////////////////////////
    private int jugarTurno(String pTurno) {

        HashMap<String, String> listaMovimientosValidos;

        //devuelvo -1 si finzaliza el juego, de lo contrario devuelvo 1
        String jugadaOrigen;
        String jugadaDestino;

        //punto 1, 2 y 3 del turno
        mostrarTablero();
        jugadaOrigen = _Interfaz.pedirJugadaOrigen(pTurno).toUpperCase();

        if (jugadaOrigen.equals("X")) {
            return -1;
        }

        //punto 4 - averiguar movimientos validos
        listaMovimientosValidos = getMovimientosValidos(jugadaOrigen, pTurno);
        //System.out.println(listaMovimientosValidos);

        //funcion encontrar posiciones
        //punto 5 - mostrar movimientos validos
        cargarTableroJugadasValidas(listaMovimientosValidos);

        //marco la poscision de la jugada con la E
        _Partida.getTablero().setFichaPosicion(jugadaOrigen, "E");

        mostrarTablero();

        //punto 6,7,8 
        jugadaDestino = _Interfaz.pedirJugadaDestino(pTurno, listaMovimientosValidos).toUpperCase();
        

        if (jugadaDestino.equals("P")) {
            return 1;
        }
        
        if (jugadaDestino.equals("X")) {
            return -1;
        }

        //punto 9 - realizar movimiento
        realizarMovimiento(jugadaOrigen, jugadaDestino, pTurno, listaMovimientosValidos);

        //punto 10 reDibujar tablero
        mostrarTablero();

        
        if( _Partida.hayGanador()){
            return 0;
        }else{
            return 1;
        }
    }

    private void realizarMovimiento(String pJugadaOrigen, String pJugadaDestino, String pTurno, HashMap<String, String> pMiListaMovimientosValidos) {

        String valorAux;
        boolean comiFicha = false;

        //seteo en blanco la posicion origen
        _Partida.getTablero().setFichaPosicion(pJugadaOrigen, " ");
        ////////////////////////////////////////////////////////////////////////     

        //seteo los valores de la lista de movimientos validos
        for (HashMap.Entry<String, String> entry : pMiListaMovimientosValidos.entrySet()) {

            valorAux = entry.getValue();

            if (valorAux == "*") {
                _Partida.getTablero().setFichaPosicion(entry.getKey(), " ");
            }

            if (valorAux == "#") {
                _Partida.getTablero().setFichaPosicion(entry.getKey(), siguienteTurno(pTurno));

                if (entry.getKey().equals(pJugadaDestino)) {
                    comiFicha = true;
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////

        //seteo mi color en la posicion destino
        _Partida.getTablero().setFichaPosicion(pJugadaDestino, pTurno);
        ////////////////////////////////////////////////////////////////////////

        if (comiFicha) {

            //resto las fichas del jugador que le comi
            _Partida.restarFicha(siguienteTurno(pTurno));
            ////////////////////////////////////////////////////////////////////////

            //sumo la ficha del jugador del turno
            // _Partida.sumarFicha(pTurno);
            ////////////////////////////////////////////////////////////////////////
        }

    }

    private String siguienteTurno(String pTurno) {

        if (pTurno.equals("R")) {
            return "A";
        } else {
            return "R";
        }
    }

    private void cargarTableroJugadasValidas(HashMap<String, String> miLista) {

        for (HashMap.Entry<String, String> entry : miLista.entrySet()) {

            _Partida.getTablero().setFichaPosicion(entry.getKey(), entry.getValue());
        }
    }

    private void mostrarTablero() {
        _Partida.getTablero().mostrarTableroJuego();
    }

    private HashMap<String, String> getMovimientosValidos(String pJugadaOrigen, String pTurno) {

        HashMap<String, String> miLista = new HashMap<String, String>();
        boolean salirFor = false;
        int auxy;
        int auxx;
        Tablero miTablero = _Partida.getTablero();

        //averiguar fichaOrgien
        String fichaOrigen = miTablero.getFichaPosicion(pJugadaOrigen);

        //averiguar profundidad origen
        int profundidadOrigen = miTablero.getprofundidadPosicion(pJugadaOrigen);

        //obtengo las coordenadas x, y del origen
        String xOrigen = getXjugada(pJugadaOrigen);
        int yOrigen = getYjugada(pJugadaOrigen);
        int xOrigenInt = _ValorLetras.get(xOrigen);

        //caundo voy hacia afuera solo puedo mover a lugares vacios
        //recorro hacia arriba
        for (int x = xOrigenInt - 1; x >= 0 && !salirFor; x--) {

            String fichaActual = miTablero.getFichaPosicion(x, yOrigen);
            int profundidadActual = miTablero.getprofundidadPosicion(x, yOrigen);
            String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

            if (!agregar.equals("")) {
                miLista.put(this.arrayLetras[x] + Integer.toString(yOrigen), agregar);
                salirFor = true;
            }

        }
        //fin de recorrer para arriba

        //recorro hacia la derecha
        salirFor = false;

        for (int y = yOrigen + 1; y <= 6 && !salirFor; y++) {

            String fichaActual = miTablero.getFichaPosicion(xOrigenInt, y);
            int profundidadActual = miTablero.getprofundidadPosicion(xOrigenInt, y);
            String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

            if (!agregar.equals("")) {
                miLista.put(xOrigen + Integer.toString(y), agregar);
                salirFor = true;
            }
        }
        //fin de recorrer a la derecha

        //recorro hacia abajo
        salirFor = false;

        for (int x = xOrigenInt + 1; x < 6 && !salirFor; x++) {

            String fichaActual = miTablero.getFichaPosicion(x, yOrigen);
            int profundidadActual = miTablero.getprofundidadPosicion(x, yOrigen);
            String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

            if (!agregar.equals("")) {
                miLista.put(this.arrayLetras[x] + Integer.toString(yOrigen), agregar);
                salirFor = true;
            }
        }
        //fin de recorrida hacia abajo

        //recorro hacia la izquierda
        salirFor = false;

        for (int y = yOrigen - 1; y > 0 && !salirFor; y--) {

            String fichaActual = miTablero.getFichaPosicion(xOrigen, y);
            int profundidadActual = miTablero.getprofundidadPosicion(xOrigen, y);
            String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

            if (!agregar.equals("")) {
                miLista.put(xOrigen + Integer.toString(y), agregar);
                salirFor = true;
            }
        }
        //fin del recorrido a la izquierda

        //recorro en diagonal arriba derecha
        salirFor = false;
        auxy = yOrigen;
        for (int x = xOrigenInt - 1; x >= 0 && !salirFor; x--) {

            auxy = auxy + 1;

            if (auxy > 6) {
                salirFor = true;
            } else {

                String fichaActual = miTablero.getFichaPosicion(x, auxy);
                int profundidadActual = miTablero.getprofundidadPosicion(x, auxy);
                String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

                if (!agregar.equals("")) {
                    miLista.put(this.arrayLetras[x] + Integer.toString(auxy), agregar);
                    salirFor = true;

                }
            }
        }
        //termino recorrido de arriba derecha

        //recorrido abajo derecha
        salirFor = false;
        auxy = yOrigen;
        for (int x = xOrigenInt + 1; x < 6 && !salirFor; x++) {

            auxy = auxy + 1;

            if (auxy > 6) {
                salirFor = true;
            } else {

                String fichaActual = miTablero.getFichaPosicion(x, auxy);
                int profundidadActual = miTablero.getprofundidadPosicion(x, auxy);
                String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

                if (!agregar.equals("")) {
                    miLista.put(this.arrayLetras[x] + Integer.toString(auxy), agregar);
                    salirFor = true;

                }
            }
        }
        //fin recorrido abajo derecha

        //inicio recorrido abajo izquierda
        salirFor = false;
        auxy = yOrigen;
        for (int x = xOrigenInt + 1; x < 6 && !salirFor; x++) {

            auxy = auxy - 1;

            if (auxy == 0) {
                salirFor = true;
            } else {

                String fichaActual = miTablero.getFichaPosicion(x, auxy);
                int profundidadActual = miTablero.getprofundidadPosicion(x, auxy);
                String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

                if (!agregar.equals("")) {
                    miLista.put(this.arrayLetras[x] + Integer.toString(auxy), agregar);
                    salirFor = true;
                }
            }
        }

        //fin de recorrido abajo izquierda
        //inicio recorrido arriba izquierda
        salirFor = false;
        auxy = yOrigen;
        for (int x = xOrigenInt - 1; x >= 0 && !salirFor; x--) {

            auxy = auxy - 1;

            if (auxy == 0) {
                salirFor = true;
            } else {

                String fichaActual = miTablero.getFichaPosicion(x, auxy);
                int profundidadActual = miTablero.getprofundidadPosicion(x, auxy);
                String agregar = movimientoValido(fichaOrigen, profundidadOrigen, fichaActual, profundidadActual);

                if (!agregar.equals("")) {
                    miLista.put(this.arrayLetras[x] + Integer.toString(auxy), agregar);
                    salirFor = true;

                }
            }
        }
        //fin recorrido arriba izquierda

        return miLista;
    }

    private String movimientoValido(String pFichaOrigen, int pProfundidadOrigen, String pFichaActual, int pProfundidadActual) {

        if (pProfundidadOrigen < pProfundidadActual) {
            //profundidad origen es menor a profundiad nueva - voy para afuera solo puedo mover a lugares vacios
            if (pFichaActual.equals(" ")) {
                return "*";
            }
        } else {
            //profundidad origen es mayor o igual a profundidad nueva - voy para adentro 
            if (!(pFichaActual.equals(pFichaOrigen)) && (!pFichaActual.equals(" "))) {
                return "#";
            }
        }

        return "";
    }

    private String getXjugada(String pJugada) {

        return pJugada.substring(0, 1);
        //int indicePos = Character.getNumericValue(pJugada.charAt(1));      
    }

    private int getYjugada(String pJugada) {

        return Integer.parseInt(pJugada.substring(1, 2));
    }
    ////////////////////////////////////////////////////////////////////////////

   
}
