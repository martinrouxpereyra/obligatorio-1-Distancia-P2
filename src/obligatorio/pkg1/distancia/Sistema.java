
package obligatorio.pkg1.distancia;

import java.util.ArrayList;

public class Sistema {
    
    private Interfaz _Interfaz;   
    public ArrayList<Jugador> _ListaJugadores;
 
    
    
    public Sistema() {
        _ListaJugadores = new ArrayList();

        _Interfaz = new Interfaz();

    }
    
    public void menuPrincipal() {
        String opcion = "";

        while (true) {
            opcion = _Interfaz.invocarMenu();

            switch (opcion) {

                case "A":
                    this.registrarJugador();
                    break;

                case "E":
                    //this.elegirTablero();
                    break;

                case "J":
                    //this.jugarPartida();
                    break;

                case "R":
                    //this.mostrarRanking();
                    break;

                case "S":
                    //this.finalizar();
            }

        }
    }
    
    public void registrarJugador() {

        _Interfaz.registrarJugador();
    }
    
    //Agregar jugador al arraylist
    public void agregarJugador(Jugador pJugador) {
        _ListaJugadores.add(pJugador);
    }
    
    
    
}
