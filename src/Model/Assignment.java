
package Model;

/**
 *
 * @author alexis
 */
public class Assignment {
    private int claveMobile;
    private String claveMarca;

    public Assignment() {
    }

    public Assignment(int claveMobile, String claveMarca) {
        this.claveMobile = claveMobile;
        this.claveMarca = claveMarca;
    }

    public int getClaveMobile() {
        return claveMobile;
    }

    public void setClaveMobile(int claveMobile) {
        this.claveMobile = claveMobile;
    }

    public String getClaveMarca() {
        return claveMarca;
    }

    public void setClaveMarca(String claveMarca) {
        this.claveMarca = claveMarca;
    }
    
}
