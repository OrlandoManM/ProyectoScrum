
package Model;

/**
 *
 * @author alexis
 */
public class Marca {
    private String claveMarca;
    private String nombre;
    private String sitioWeb;

    public Marca() {
    }

    public Marca(String claveMarca, String nombre, String sitioWeb) {
        this.claveMarca = claveMarca;
        this.nombre = nombre;
        this.sitioWeb = sitioWeb;
    }

    public String getClaveMarca() {
        return claveMarca;
    }

    public void setClaveMarca(String claveMarca) {
        this.claveMarca = claveMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    
}
