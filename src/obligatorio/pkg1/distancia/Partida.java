//Martin Roux 254820 - Gaspar Flom 264135
package obligatorio.pkg1.distancia;

import java.util.HashMap;

public class Partida {

    private String _AliasGanador;
    private String _AliasJugadorRojo;
    private String _AliasJugadorAzul;

    private HashMap<String, Jugador> _Jugadores;

    private Tablero _Tablero;

    private HashMap<String, Integer> _CantidadDeFichas;

    Partida(Jugador pJugadorRojo, Jugador pJugadorAzul, Tablero pTablero) {

        this.setAliasJugadorRojo(pJugadorRojo.getAlias());
        this.setAliasJugadorAzul(pJugadorAzul.getAlias());
        this.setTablero(pTablero);

        _Jugadores = new HashMap<String, Jugador>();
        _Jugadores.put(pJugadorRojo.getAlias(), pJugadorRojo);
        _Jugadores.put(pJugadorAzul.getAlias(), pJugadorAzul);

        _CantidadDeFichas = new HashMap<String, Integer>();
        _CantidadDeFichas.put(pJugadorRojo.getAlias().toUpperCase(), _Tablero.getCantidadFichasInicialesRojas());
        _CantidadDeFichas.put(pJugadorAzul.getAlias().toUpperCase(), _Tablero.getCantidadFichasInicialesAzules());

    }
    /////////////////////////////////////////////////////////////////////////////
    //metodos get
    /////////////////////////////////////////////////////////////////////////////

    public Jugador getJugadorRojo() {
        return _Jugadores.get(_AliasJugadorRojo);
    }

    public Jugador getJugadorAzul() {
        return _Jugadores.get(_AliasJugadorAzul);
    }

    public Tablero getTablero() {
        return _Tablero;
    }
    /////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    //metodos set
    /////////////////////////////////////////////////////////////////////////////
    public void setAliasJugadorRojo(String pAliasJugadorRojo) {
        this._AliasJugadorRojo = pAliasJugadorRojo;
    }

    public void setAliasJugadorAzul(String pAliasJugadorAzul) {
        this._AliasJugadorAzul = pAliasJugadorAzul;
    }

    public void setTablero(Tablero pTablero) {
        this._Tablero = pTablero;
    }

    public void setGanador(String pTurno) {

        if (pTurno.equals("R")) {
            _AliasGanador = _AliasJugadorRojo;
        } else {
            _AliasGanador = _AliasJugadorAzul;
        }
        _Jugadores.get(_AliasGanador).sumarPuntaje();

    }
    /////////////////////////////////////////////////////////////////////////////

    public boolean hayGanador() {

        //System.out.println("hay ganador cantidad de fichas " + _CantidadDeFichas);
        if (_CantidadDeFichas.get(_AliasJugadorRojo) <= 0) {
            _AliasGanador = _AliasJugadorAzul;
            _Jugadores.get(_AliasGanador).sumarPuntaje();
            return true;
        }

        if (_CantidadDeFichas.get(_AliasJugadorAzul) <= 0) {
            _AliasGanador = _AliasJugadorRojo;
            _Jugadores.get(_AliasGanador).sumarPuntaje();
            return true;
        }

        return false;
    }

    public Jugador getGanador() {

        return _Jugadores.get(_AliasGanador);
    }

    public int cantidadDeFichas(String pJugadorAlias) {
        return _CantidadDeFichas.get(pJugadorAlias);
    }

    public void restarFicha(String pTurno) {

        if (pTurno.equals("R")) {
            _CantidadDeFichas.put(_AliasJugadorRojo, _CantidadDeFichas.get(_AliasJugadorRojo) - 1);
        } else {
            _CantidadDeFichas.put(_AliasJugadorAzul, _CantidadDeFichas.get(_AliasJugadorAzul) - 1);
        }

    }

}
