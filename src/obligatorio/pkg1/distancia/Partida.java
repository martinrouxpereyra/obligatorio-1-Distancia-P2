//Martin Roux 254820 - Gaspar Flom 264135
package obligatorio.pkg1.distancia;

import java.util.HashMap;

public class Partida {

    private Jugador _Jugador1;
    private Jugador _Jugador2;
    private Tablero _Tablero;
    private String aliasGanador;
    private HashMap<String, Integer> _CantidadDeFichas;

    Partida(Jugador pJugador1, Jugador pJugador2, Tablero pTablero) {

        this.setJugador1(pJugador1);
        this.setJugador2(pJugador2);
        this.setTablero(pTablero);

        _CantidadDeFichas = new HashMap<String, Integer>();

        _CantidadDeFichas.put(pJugador1.getAlias().toUpperCase(), _Tablero.getCantidadFichasInicialesRojas());
        _CantidadDeFichas.put(pJugador2.getAlias().toUpperCase(), _Tablero.getCantidadFichasInicialesAzules());

    }
    /////////////////////////////////////////////////////////////////////////////
    //metodos get
    /////////////////////////////////////////////////////////////////////////////

    public Jugador getJugador1() {
        return _Jugador1;
    }

    public Jugador getJugador2() {
        return _Jugador2;
    }

    public Tablero getTablero() {
        return _Tablero;
    }
    /////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////
    //metodos set
    /////////////////////////////////////////////////////////////////////////////
    public void setJugador1(Jugador pJugador1) {
        this._Jugador1 = pJugador1;
    }

    public void setJugador2(Jugador pJugador2) {
        this._Jugador2 = pJugador2;
    }

    public void setTablero(Tablero pTablero) {
        this._Tablero = pTablero;
    }
    /////////////////////////////////////////////////////////////////////////////
    
    public boolean hayGanador() {

        System.out.println("hay ganador cantidad de fichas " + _CantidadDeFichas);

        if (_CantidadDeFichas.get(_Jugador1.getAlias()) <= 0) {
            aliasGanador = _Jugador2.getAlias();

            return true;
        }

        if (_CantidadDeFichas.get(_Jugador2.getAlias()) <= 0) {
            aliasGanador = _Jugador1.getAlias();
            return true;
        }

        return false;
    }
    
    public int cantidadDeFichas(String pJugadorAlias) {
        return _CantidadDeFichas.get(pJugadorAlias);
    }

    public void restarFicha(String pTurno) {

        if (pTurno.equals("R")) {
            _CantidadDeFichas.put(_Jugador1.getAlias(), _CantidadDeFichas.get(_Jugador1.getAlias()) - 1);
        } else {
            _CantidadDeFichas.put(_Jugador2.getAlias(), _CantidadDeFichas.get(_Jugador2.getAlias()) - 1);
        }

    }

    public void sumarFicha(String pTurno) {

        if (pTurno.equals("R")) {
            _CantidadDeFichas.put(_Jugador1.getAlias(), _CantidadDeFichas.get(_Jugador1.getAlias()) + 1);
        } else {
            _CantidadDeFichas.put(_Jugador2.getAlias(), _CantidadDeFichas.get(_Jugador2.getAlias()) + 1);
        }
    }
    

}
