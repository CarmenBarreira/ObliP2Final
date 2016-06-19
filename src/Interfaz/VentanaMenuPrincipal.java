package Interfaz;

import Dominio.Sistema;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class VentanaMenuPrincipal extends javax.swing.JFrame {

    public VentanaMenuPrincipal(Sistema sis) throws ClassNotFoundException {
        initComponents();
        elSis = sis;
         try {
                elSis = sis.persistirLeer();
           
           } catch (FileNotFoundException e) {
            System.out.println("1" + e.getMessage());
        } catch (IOException e) {
            System.out.println("2" + e.getMessage());
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                try {
            elSis.persistirGuardar(elSis);
             
        } catch (IOException ex) {
        }       
        close();
        }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMPJugadores1 = new javax.swing.JButton();
        btnMPConfiguraciones = new javax.swing.JButton();
        btnMPJugarPartida = new javax.swing.JButton();
        btnMPJugadores2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4enCuadrado - Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setResizable(false);
        setSize(new java.awt.Dimension(594, 420));

        btnMPJugadores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jugadoresIcono.png"))); // NOI18N
        btnMPJugadores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugadores1ActionPerformed(evt);
            }
        });

        btnMPConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonConfiguracionPrincipal.png"))); // NOI18N
        btnMPConfiguraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPConfiguracionesActionPerformed(evt);
            }
        });

        btnMPJugarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonDeJugarPartida.png"))); // NOI18N
        btnMPJugarPartida.setText("Jugar Partida");
        btnMPJugarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugarPartidaActionPerformed(evt);
            }
        });

        btnMPJugadores2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirIcono.png"))); // NOI18N
        btnMPJugadores2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugadores2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoJuego.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMPConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugadores1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugadores2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnMPJugarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMPConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMPJugadores1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMPJugadores2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMPJugadores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPJugadores1ActionPerformed
        VentanaJugadores vJugadores = new VentanaJugadores(elSis);
        Rectangle rct = vJugadores.getGraphicsConfiguration().getBounds();
        vJugadores.setLocation((rct.width - vJugadores.getWidth()) / 2, (rct.height - vJugadores.getHeight()) / 2);
        vJugadores.setVisible(true);
    }//GEN-LAST:event_btnMPJugadores1ActionPerformed

    private void btnMPJugarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPJugarPartidaActionPerformed
        if (elSis.getListaJugadores().size() >= 2) {
            VentanaPreJugar vJugar = new VentanaPreJugar(elSis);
            Rectangle rct = vJugar.getGraphicsConfiguration().getBounds();
            vJugar.setLocation((rct.width - vJugar.getWidth()) / 2, (rct.height - vJugar.getHeight()) / 2);
            vJugar.setVisible(true);
        } else {
            int resp = JOptionPane.showConfirmDialog(this, "No hay jugadores, desea ingresar al menu jugador para ingresarlos?", "4enCuadrado - Faltan Jugadores", ERROR_MESSAGE);
            if (resp == 0) {
                VentanaJugadores vJugadores = new VentanaJugadores(elSis);
                Rectangle rct = vJugadores.getGraphicsConfiguration().getBounds();
                vJugadores.setLocation((rct.width - vJugadores.getWidth()) / 2, (rct.height - vJugadores.getHeight()) / 2);
                vJugadores.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnMPJugarPartidaActionPerformed

    private void btnMPConfiguracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPConfiguracionesActionPerformed
        VentanaConfiguracion vConfig = new VentanaConfiguracion(elSis);
        Rectangle rct = vConfig.getGraphicsConfiguration().getBounds();
        vConfig.setLocation((rct.width - vConfig.getWidth()) / 2, (rct.height - vConfig.getHeight()) / 2);
        vConfig.setVisible(true);
    }//GEN-LAST:event_btnMPConfiguracionesActionPerformed

    private void btnMPJugadores2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPJugadores2ActionPerformed
        try {
             
            elSis.persistirGuardar(elSis);
            close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      
        System.exit(0);
    }//GEN-LAST:event_btnMPJugadores2ActionPerformed

    
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
        Sistema sis = new Sistema();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaMenuPrincipal(sis).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro/a que desea salir?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
   
   private Sistema elSis;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMPConfiguraciones;
    private javax.swing.JButton btnMPJugadores1;
    private javax.swing.JButton btnMPJugadores2;
    private javax.swing.JButton btnMPJugarPartida;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
