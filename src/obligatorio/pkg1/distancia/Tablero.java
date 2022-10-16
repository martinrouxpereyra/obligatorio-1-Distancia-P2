
package obligatorio.pkg1.distancia;


public class Tablero {
    private String[][] tablero = new String[6][6];
    private int[][] matrizPos = {{6,5,4,4,5,6}, {5,3,2,2,3,5}, {4,2,1,1,2,4}, {4,2,1,1,2,4}, {5,3,2,2,3,5}, {6,5,4,4,5,6}};
    
    
    public String[][] tableroStandar(String[][] tablero){
        
        String[][] matStandar = tablero;
        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";
        
        for(int x = 0; x < matStandar.length; x++){
            
            for(int y = 0; y < matStandar[x].length; y++){
                
                if( y == 0 || y % 2 == 0){
                    
                    matStandar[x][y] = A;
                }else{
                    matStandar[x][y] = R;
                }              
            }
        }
        
        return matStandar; 
    }
    
    public String[][] tableroPrecargado1(String[][] tablero){
        
        String[][] matPrec1 = tablero;
        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";
        
        for(int x = 0; x < matPrec1.length; x++){
            
            for(int y = 0; y < matPrec1[x].length; y++){
                
                if(x == 0 && y == 0){
                    matPrec1[x][y] = R;
                }else{
                    if(x == 2 && y == 2){
                        matPrec1[x][y] = A;
                    }else{
                        if(x == 3 && y == 5){
                            matPrec1[x][y] = A;
                        }else{
                            if(x == 4 && y == 1){
                                matPrec1[x][y] = A;
                            }else{
                                if(x == 5 && y == 3){
                                    matPrec1[x][y] = R;
                                }
                            }
                        }
                    }
                }
            }
        }       
        return matPrec1;        
    }
    
    public String[][] tableroPrecargado2(String[][] tablero){
        
        String[][] matPrec2 = tablero;
        String R = "\u001B[31mR\033[0m";
        String A = "\u001B[34mA\033[0m";
        
        for(int x = 0; x < matPrec2.length; x++){
            
            for(int y = 0; y < matPrec2[x].length; y++){
                
                if(x == 0 && y == 0){
                    matPrec2[x][y] = R;
                    
                }else{
                    if(x == 5 && y == 4){
                        matPrec2[x][y] = A;
                    }else{
                        if(x == 5 && y == 5){
                            matPrec2[x][y] = R;
                        }
                    }
                }
            }
        }       
        return matPrec2;        
    }

    
     public static void mostrarTableroJuego(String[][] unTablero){
        
        String[] letras = {" A "," B "," C "," D "," E "," F "};
        int cont = 0;
        mostrarNumHorizontales();
        
        System.out.println("   +-+-+-+-+-+-+");
        
        for(int x = 0; x < unTablero.length; x++){   
            
           
            
            for(int y = 0; y < unTablero[x].length; y++){
                
                if(y == 0){
                    System.out.print(letras[cont]);                   
                }
                 
                if(y == 5){
                    
                    System.out.print("|" + unTablero[x][y] + "|");
                    System.out.print(letras[cont]);
                    cont++;
                }else{
                    System.out.print("|" + unTablero[x][y]);
                }
             
            }
            System.out.println("");
            System.out.println("   +-+-+-+-+-+-+");            
        }
        mostrarNumHorizontales();
    }
    
    public static void mostrarNumHorizontales(){
        System.out.println("    1 2 3 4 5 6");
    }
    
    public void mostrarLetrasVerticales(){
        String[] letras = {"A","B","C","D","E","F"};
        
    }
    
}


