//Martin Roux 254820 - Gaspar Flom 264135
package obligatorio.pkg1.distancia;


public class Jugador implements Comparable<Jugador>{
    
    //Atributos
    private String nombre;
    private String edad;
    private String alias;
    private int puntaje;

    
    public Jugador(String unNombre, String unaEdad, String unAlias){
        setNombre(unNombre);
        setEdad(unaEdad);
        setAlias(unAlias.toUpperCase());
        setPuntaje(0);
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getAlias() {
        return alias;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void sumarPuntaje() {
        this.puntaje++;
    }
    
    @Override
    public String toString(){
        return "nombre: " + this.getNombre() +" edad: " + this.getEdad() + " alias: " + this.getAlias() + " Partidas ganadas: " + this.getPuntaje();
    }
    
    @Override
    public int compareTo(Jugador pJugador) {
        return this.getPuntaje() - pJugador.getPuntaje();
    }
}
