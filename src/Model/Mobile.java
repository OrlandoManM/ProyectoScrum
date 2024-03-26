
package Model;

/**
 *
 * @author alexis
 */
public class Mobile {
    private int claveMobile;
    private String nombre;
    private String procesador;
    private String color;
    private String precio;

    public Mobile() {
    }

    public Mobile(int claveMobile, String nombre, String procesador, String color, String precio) {
        this.claveMobile = claveMobile;
        this.nombre = nombre;
        this.procesador = procesador;
        this.color = color;
        this.precio = precio;
    }

    public int getClaveMobile() {
        return claveMobile;
    }

    public void setClaveMobile(int claveMobile) {
        this.claveMobile = claveMobile;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
