
package ConectionSQL;

import Model.Mobile;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Mobile_DB {
    /*
    *   Sistema que administra los dispositivo móviles
    */
    
    // Código para INSERTAR en la tabla de la BD
    public void altaMobile(Mobile mob) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO MOBILES(CLAVE_MOBILE,NOMBRE,PROCESADOR,"
                    + "COLOR,PRECIO) VALUES (?,?,?,?,?)");
            pst.setInt(1, mob.getClaveMobile());
            pst.setString(2, mob.getNombre());
            pst.setString(3, mob.getProcesador());
            pst.setString(4, mob.getColor());
            pst.setString(5, mob.getPrecio());
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
    
    // Código para generar una nueva clave
    public int generaClaveMob() {
        int clave = 0;
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada a la funcion de la BD
            CallableStatement cst = cnx.prepareCall("{? = call CLAVE_MOBILE (?)}");
            
            // Se indica que el primer interrogante es de salida
            cst.registerOutParameter(1, java.sql.Types.INTEGER);
            
            // Se pasa un parámetro en el segundo interrogante
            cst.setInt(2, 0);
            
            // Ejecuta la función almacenada
            cst.executeUpdate();
            
            // Se recupera el resultado de la funcion pl/sql
            clave = cst.getInt(1);
            clave = clave + 1;
        } catch (SQLException ex) {
            clave = 1;
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener la clave mayor o no hay regristros");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return clave;
    }
    
    // Código para VER la tabla de la BD
    public ArrayList<Mobile> consultarMobiles() {
        ArrayList<Mobile> mobiles = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT CLAVE_MOBILE,NOMBRE,PROCESADOR,COLOR,PRECIO"
                    + " FROM MOBILES ORDER BY 1 ");
            while (rs.next()) {
                Mobile mob = new Mobile();
                mob.setClaveMobile(rs.getInt("CLAVE_MOBILE"));
                mob.setNombre(rs.getString("NOMBRE"));
                mob.setProcesador(rs.getString("PROCESADOR"));
                mob.setColor(rs.getString("COLOR"));
                mob.setPrecio(rs.getString("PRECIO"));
                mobiles.add(mob);
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
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_MOBILE)
    public void bajaMobile(int clave_mobile) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_MOBILE (?)}");
            
            // Parametro para el procedimiento almacenado
            cst.setInt(1, clave_mobile);
            
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
    
    // Código para BUSCAR un producto en la tabla de la BD
    public boolean buscaMobile(int clave_prod) {
        Connection cnx = DataBaseConexion.getConnection();
        Mobile mob = new Mobile();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_MOBILE,NOMBRE,PROCESADOR,COLOR,PRECIO"
                    + " FROM MOBILES WHERE CLAVE_MOBILE like (?)");
            pst.setInt(1, clave_prod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mob.setClaveMobile(rs.getInt("CLAVE_MOBILE"));
                mob.setNombre(rs.getString("NOMBRE"));
                mob.setProcesador(rs.getString("PROCESADOR"));
                mob.setColor(rs.getString("COLOR"));
                mob.setPrecio(rs.getString("PRECIO"));
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
    
}
