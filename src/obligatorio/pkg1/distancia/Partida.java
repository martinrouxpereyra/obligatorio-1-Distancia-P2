
package obligatorio.pkg1.distancia;


public class Partida {
    
   private Jugador _Jugador1; 
   private Jugador _Jugador2;
   private Tablero _Tablero;
   private String ganador;
   
   Partida(Jugador _Jugador1, Jugador _Jugador2, Tablero _Tablero){
       
       this.setJugador1(_Jugador1);
       this.setJugador2(_Jugador2);
       this.setTablero(_Tablero);
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

    public String getGanador() {
        return ganador;
    }
    /////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////
    //metodos set
    /////////////////////////////////////////////////////////////////////////////

    public void setJugador1(Jugador _Jugador1) {
        this._Jugador1 = _Jugador1;
    }

    public void setJugador2(Jugador _Jugador2) {
        this._Jugador2 = _Jugador2;
    }

    public void setTablero(Tablero _Tablero) {
        //this._Tablero = _Tablero;
        
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    /////////////////////////////////////////////////////////////////////////////
    
    
   
}
