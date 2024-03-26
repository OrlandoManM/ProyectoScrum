
package View.GUI_Consultas;

import ConectionSQL.Mobile_DB;
import Model.Mobile;
import View.GUI_MenuCliente.MenuPrincipalCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Consulta_Mobiles_Cliente extends javax.swing.JFrame {
    Mobile_DB mobile_db = new Mobile_DB();

    /**
     * Creates new form Consulta_Mobiles
     */
    public Consulta_Mobiles_Cliente() {
        initComponents();
        this.setTitle("Control de Móviles");
        this.setLocationRelativeTo(null);
    }
    
    public void listarDatos() { // Con esta función se muestra la tabla
        ArrayList<Mobile> mobiles;
        mobiles = mobile_db.consultarMobiles();
        DefaultTableModel tb = (DefaultTableModel)tablaMobiles.getModel();
        for(Mobile m: mobiles) {
            tb.addRow(new Object[]{m.getClaveMobile(),m.getNombre(),m.getProcesador(),m.getColor(),m.getPrecio()});
        }
    }
    
    public void limpiarFormulario() {   // Con esta función se limpia la tabla
        DefaultTableModel tb = (DefaultTableModel)tablaMobiles.getModel();
        for (int i=tb.getRowCount()-1; i>=0; i--)
            tb.removeRow(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        regresar_MenuMobile = new javax.swing.JButton();
        verMobiles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMobiles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Consulta de dispositivos móviles:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        regresar_MenuMobile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        regresar_MenuMobile.setText("Regresar a Menú Móviles");
        regresar_MenuMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_MenuMobileActionPerformed(evt);
            }
        });
        jPanel1.add(regresar_MenuMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        verMobiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lupa.png"))); // NOI18N
        verMobiles.setText("Consultar");
        verMobiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMobilesActionPerformed(evt);
            }
        });
        jPanel1.add(verMobiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        tablaMobiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Procesador", "Color", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMobiles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 590, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home_wallpaper_0.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresar_MenuMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_MenuMobileActionPerformed
        new MenuPrincipalCliente().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresar_MenuMobileActionPerformed

    private void verMobilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMobilesActionPerformed
        limpiarFormulario();
        listarDatos();
    }//GEN-LAST:event_verMobilesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta_Mobiles_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_Mobiles_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_Mobiles_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_Mobiles_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_Mobiles_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar_MenuMobile;
    private javax.swing.JTable tablaMobiles;
    private javax.swing.JButton verMobiles;
    // End of variables declaration//GEN-END:variables
}
