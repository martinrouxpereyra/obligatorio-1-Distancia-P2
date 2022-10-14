
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
                    _Interfaz.pedirDatosJugador();
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
    
    public void registrarJugador(Jugador pJugador) {
        
        //Agregar jugador al arraylist
        _ListaJugadores.add(pJugador);
        System.out.println(_ListaJugadores);
    }
    
    
    public boolean validarJugadorNombre(String pNombre){

        //matches comprueba si un String cumple una expresión regular pasada como parámetro
        return pNombre.matches("[a-zA-Z]{1,20}");
    }
    
    public boolean validarJugadorEdad(String pEdad){
        
        //Aca se valida que la edad no sea 0, que no sea 01,02,...09
        //y con match se comprueba que sean solo digitos entre 0-9 y de 1 0 2 cifras
        
        if(pEdad.equals("0")){
            return false;
        }
        
        String edadAux ="";
        
        for(int i = 0; i <= 9; i++){
            
            edadAux = "0" + i;
            
            if(pEdad.equals(edadAux)){
                return false;
            }
        }      
        return pEdad.matches("[0-9]{1,2}");       
    }
    
    public boolean validarJugadorAlias(String pAlias){
        //aca se valida la unicidad del alias
        
        return true;
    }
    
    
    
    
}
