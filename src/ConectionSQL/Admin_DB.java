
package ConectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexis
 */
public class Admin_DB {
    /*
    *   Sistema login
    */
    
    // Código para BUSCAR un departamento en la tabla de la BD
    public boolean buscaAdmin(String nombre_admin, String password_admin) {
        Connection cnx = DataBaseConexion.getConnection();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT NOMBRE,PASWORD"
                    + " FROM ADMIN_MOBILE_STORE WHERE NOMBRE like (?) AND PASWORD like (?)");
            pst.setString(1, nombre_admin);
            pst.setString(2, password_admin);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String pasword = rs.getString("PASWORD");
                ban = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al buscar al administrador");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return ban;
    }
    
}
