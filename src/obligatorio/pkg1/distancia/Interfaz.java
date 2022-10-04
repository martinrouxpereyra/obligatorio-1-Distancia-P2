
package obligatorio.pkg1.distancia;

import java.util.Scanner;


public class Interfaz {

    private static String[][] opciones;
            static Scanner lector;
  
    public static void main(String[] args) {
        
        inicializarOpciones(); 
        
    }
    
    //----------------------------------------------------------------
    //se inicializan las opciones y llama a invocar menu
    //----------------------------------------------------------------
    private static void inicializarOpciones() {

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
        
        invocarMenu();
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
    //funcion que invoca al menu y pide una opcion
    //----------------------------------------------------------------
    private static String invocarMenu(){
        
        String opcion = "";
        boolean esOpcionValida;
        lector = new Scanner(System.in);
        
        do{
        
            mostrarMenu();
            opcion = lector.nextLine().toUpperCase();
            
            esOpcionValida = validarOpcion(opcion);
            
            if(!esOpcionValida){
                System.out.println("la opcion no es valida, por favor ingrese otra");
                System.out.println("");
            }
            
        }while(!esOpcionValida);
        
        
     return opcion;       
    }
    //----------------------------------------------------------------
    
    
    //----------------------------------------------------------------
    //funcion que valida la opcion elegida
    //----------------------------------------------------------------
    private static boolean validarOpcion(String opcion){
        
        boolean esValida = false;
        
        for(int i=0; i < opciones.length && !esValida; i++){
            
            if(opcion.equals(opciones[i][1])){
                esValida = true;
            }
        }

        return esValida;
    }
    
       
}
