
package ConectionSQL;

import Model.Marca;
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
public class Marcas_DB {
    /*
    *   Sistema que administra las marcas de la store
    */
    
    // Código para INSERTAR una nueva marca en la tabla de la BD
    public void altaMarca(Marca marca) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO MARCAS(CLAVE_MARCA,NOMBRE,SITIO_WEB)"
                    + " VALUES (?,?,?)");
            pst.setString(1, marca.getClaveMarca());
            pst.setString(2, marca.getNombre());
            pst.setString(3, marca.getSitioWeb());
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
    
    // Código para VER la tabla de la BD
    public ArrayList<Marca> consultarMarcas() {
        ArrayList<Marca> marcas = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT CLAVE_MARCA,NOMBRE,SITIO_WEB"
                    + " FROM MARCAS ORDER BY 1 ");
            while (rs.next()) {
                Marca m = new Marca();
                m.setClaveMarca(rs.getString("CLAVE_MARCA"));
                m.setNombre(rs.getString("NOMBRE"));
                m.setSitioWeb(rs.getString("SITIO_WEB"));
                marcas.add(m);
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
        
        return marcas;
    }
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_MARCA)
    public void bajaMarca(String claveMarca) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_MARCA (?)}");
            
            // Parametro para el procedimiento almacenado
            cst.setString(1, claveMarca);
            
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
    
    // Código para BUSCAR una marca en la tabla de la BD
    public boolean buscaMarca(String claveMarca) {
        Connection cnx = DataBaseConexion.getConnection();
        Marca marca = new Marca();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_MARCA,NOMBRE,SITIO_WEB"
                    + " FROM MARCAS WHERE CLAVE_MARCA like (?)");
            pst.setString(1, claveMarca);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                marca.setClaveMarca("CLAVE_MARCA");
                marca.setNombre(rs.getString("NOMBRE"));
                marca.setSitioWeb(rs.getString("SITIO_WEB"));
                ban = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al mostrar la marca");
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
