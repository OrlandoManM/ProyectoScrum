
package ConectionSQL;

import Model.Assignment;
import Model.Mobile;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class AssigMobile_DB {
    /*
    *   Sistema que administra los mobiles en una marca
    */
    
    // Código para INSERTAR un nuevo mobile a una marca en la tabla de la BD
    public void altaAssignmentMobile(Assignment assig) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO ASIG_MOB(CLAVE_MOBILE,CLAVE_MARCA)"
                    + " VALUES (?,?)");
            pst.setInt(1, assig.getClaveMobile());
            pst.setString(2, assig.getClaveMarca());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al agregar datos en la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_ASIG_MOBILE)
    public void bajaAssignmentMobile(int claveMobile) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_ASIG_MOBILE (?)}");
            
            // Parametro para el procedimiento almacenado
            cst.setInt(1, claveMobile);
            
            // Ejecuta el procedimiento almacenado
            cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al eliminar el registro de la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Código para BUSCAR un mobile en la tabla de la BD
    public boolean buscaMobileMarca(int claveMobile) {
        Connection cnx = DataBaseConexion.getConnection();
        Assignment assig = new Assignment();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_MOBILE,CLAVE_MARCA"
                    + " FROM ASIG_MOB WHERE CLAVE_MOBILE like (?)");
            pst.setInt(1, claveMobile);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                assig.setClaveMobile(rs.getInt("CLAVE_MOBILE"));
                assig.setClaveMarca(rs.getString("CLAVE_MARCA"));
                ban = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al mostrar el producto");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return ban;
    }
    
    // Código para VER los mobiles en una marca
    public ArrayList<Mobile> consultarMobilesMarca(String claveMarca) {
        ArrayList<Mobile> mobiles = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_MOBILE"
                    + " FROM ASIG_MOB WHERE CLAVE_MARCA like (?)");
            pst.setString(1, claveMarca);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mobiles.add(regresaMobileMarca(rs.getInt("CLAVE_MOBILE")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener los datos de la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return mobiles;
    }
    
    // Código para REGRESAR un producto en la tabla de la BD
    public Mobile regresaMobileMarca(int claveMobile) {
        Connection cnx = DataBaseConexion.getConnection();
        Mobile mob = new Mobile();
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_MOBILE,NOMBRE,PRECIO"
                    + " FROM MOBILES WHERE CLAVE_MOBILE like (?)");
            pst.setInt(1, claveMobile);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mob.setClaveMobile(rs.getInt("CLAVE_MOBILE"));
                mob.setNombre(rs.getString("NOMBRE"));
                mob.setPrecio(rs.getString("PRECIO"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener el producto");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return mob;
    }
    
}
