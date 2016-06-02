/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Dominio.Sistema;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class VentanaMenuPrincipal extends javax.swing.JFrame {

    public VentanaMenuPrincipal(Sistema sis) {
        initComponents();
        elSis = sis;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        btnMPJugadores1 = new javax.swing.JButton();
        btnMPConfiguraciones = new javax.swing.JButton();
        btnMPJugarPartida = new javax.swing.JButton();
        btnMPJugadores2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4enCuadrado - Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(594, 420));
        setResizable(false);
        setSize(new java.awt.Dimension(594, 420));

        lblBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblBienvenida.setText("Bienvenid@s a 4EnCuadrado!!!!!");

        btnMPJugadores1.setText("Jugadores");
        btnMPJugadores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugadores1ActionPerformed(evt);
            }
        });

        btnMPConfiguraciones.setText("Configuraciones");
        btnMPConfiguraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPConfiguracionesActionPerformed(evt);
            }
        });

        btnMPJugarPartida.setText("Jugar Partida");
        btnMPJugarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugarPartidaActionPerformed(evt);
            }
        });

        btnMPJugadores2.setText("Salir");
        btnMPJugadores2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPJugadores2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMPConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugadores1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMPJugadores2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(btnMPJugarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMPConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMPJugadores1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMPJugadores2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
        if(elSis.getListaJugadores().size()>=2){
            VentanaPreJugar vJugar = new VentanaPreJugar(elSis);
            Rectangle rct = vJugar.getGraphicsConfiguration().getBounds();
            vJugar.setLocation((rct.width - vJugar.getWidth()) / 2, (rct.height - vJugar.getHeight()) / 2);
            vJugar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Deben existir al menos 2 jugadores para jugar!", "ERROR", ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnMPJugarPartidaActionPerformed

    private void btnMPConfiguracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPConfiguracionesActionPerformed
        VentanaConfiguracion vConfig = new VentanaConfiguracion(elSis);
        Rectangle rct = vConfig.getGraphicsConfiguration().getBounds();
        vConfig.setLocation((rct.width - vConfig.getWidth()) / 2, (rct.height - vConfig.getHeight()) / 2);
        vConfig.setVisible(true);
                

    }//GEN-LAST:event_btnMPConfiguracionesActionPerformed

    private void btnMPJugadores2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPJugadores2ActionPerformed
        // TODO add your handling code here:
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
                new VentanaMenuPrincipal(sis).setVisible(true);
            }
        });
    }

    private Sistema elSis;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMPConfiguraciones;
    private javax.swing.JButton btnMPJugadores1;
    private javax.swing.JButton btnMPJugadores2;
    private javax.swing.JButton btnMPJugarPartida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables
}
