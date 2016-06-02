package Interfaz;

import Dominio.Sistema;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaConfiguracion extends javax.swing.JFrame {

    private JButton[][] botones;
    private int[] tamanioTab = new int[2];

    public VentanaConfiguracion(Sistema unSis) {
        initComponents();
        sis = unSis;
        panelJuegoConfig.setVisible(true);
        mostrarTableroConSubTableros(3, 3);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroupTamTablero = new javax.swing.ButtonGroup();
        panelJuegoConfig = new javax.swing.JPanel();
        btnGuardarConfig = new javax.swing.JButton();
        jPanelTamTablero = new javax.swing.JPanel();
        rb6x6 = new javax.swing.JRadioButton();
        rb4x6 = new javax.swing.JRadioButton();
        rb8x8 = new javax.swing.JRadioButton();
        rb6x4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(702, 544));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 658));

        javax.swing.GroupLayout panelJuegoConfigLayout = new javax.swing.GroupLayout(panelJuegoConfig);
        panelJuegoConfig.setLayout(panelJuegoConfigLayout);
        panelJuegoConfigLayout.setHorizontalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        panelJuegoConfigLayout.setVerticalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        btnGuardarConfig.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarConfig.setText("Guardar configuracion");
        btnGuardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConfigActionPerformed(evt);
            }
        });

        jPanelTamTablero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelTamTablero.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTamTablero.setToolTipText("Tamaño tablero: ");

        bgroupTamTablero.add(rb6x6);
        rb6x6.setText(" 6*6");
        rb6x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6x6ActionPerformed(evt);
            }
        });

        bgroupTamTablero.add(rb4x6);
        rb4x6.setText(" 4*6");
        rb4x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4x6ActionPerformed(evt);
            }
        });

        bgroupTamTablero.add(rb8x8);
        rb8x8.setText("8*8");
        rb8x8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb8x8ActionPerformed(evt);
            }
        });

        bgroupTamTablero.add(rb6x4);
        rb6x4.setText(" 6*4");
        rb6x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6x4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTamTableroLayout = new javax.swing.GroupLayout(jPanelTamTablero);
        jPanelTamTablero.setLayout(jPanelTamTableroLayout);
        jPanelTamTableroLayout.setHorizontalGroup(
            jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTamTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb6x6)
                    .addComponent(rb8x8))
                .addGap(36, 36, 36)
                .addGroup(jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb6x4)
                    .addComponent(rb4x6))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelTamTableroLayout.setVerticalGroup(
            jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTamTableroLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb6x6)
                    .addComponent(rb4x6))
                .addGap(18, 18, 18)
                .addGroup(jPanelTamTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb8x8)
                    .addComponent(rb6x4))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jButton1.setText("Cargar Partida");

        jLabel1.setText("Seleccionar la posicion del hueco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnGuardarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanelTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanelTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(btnGuardarConfig)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfigActionPerformed


    }//GEN-LAST:event_btnGuardarConfigActionPerformed

    private void rb6x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6x6ActionPerformed
        // TODO add your handling code here:

        tamanioTab[0] = 6;
        tamanioTab[1] = 6;


    }//GEN-LAST:event_rb6x6ActionPerformed

    private void rb4x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4x6ActionPerformed
        // TODO add your handling code here:
        mostrarTableroConSubTableros(4, 6);
        tamanioTab[0] = 4;
        tamanioTab[1] = 6;
    }//GEN-LAST:event_rb4x6ActionPerformed

    private void rb6x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6x4ActionPerformed
        mostrarTableroConSubTableros(6, 4);
        tamanioTab[0] = 6;
        tamanioTab[1] = 4;
    }//GEN-LAST:event_rb6x4ActionPerformed

    private void rb8x8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb8x8ActionPerformed
        // TODO add your handling code here:
        mostrarTableroConSubTableros(8, 8);
        tamanioTab[0] = 8;
        tamanioTab[1] = 8;
    }//GEN-LAST:event_rb8x8ActionPerformed
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
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaConfiguracion().setVisible(true);
//            }
//        });
    }

    private class ListenerBoton implements ActionListener {

        private int x;

        private int y;

        public ListenerBoton(int i, int j) {

            // en el constructor se almacena la fila y columna que se presionó
            x = i;

        }

        public void actionPerformed(ActionEvent e) {

            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);

        }
    }

    private void clickBoton(int fila, int columna) {

// Método a completar!.
// En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
// fila 1 y columna 1 corresponden a la posición de arriba a la izquierda.
// Debe indicarse cómo responder al click de ese botón.
    }

    public void mostrarTableroConSubTableros(int dimensionF, int dimensionC) {

        panelJuegoConfig.setLayout(new GridLayout(dimensionF, dimensionC));

        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();

                jButton.addActionListener(new ListenerBoton(i, j));

                panelJuegoConfig.add(jButton);

            }

        }

    }

    Sistema sis = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroupTamTablero;
    private javax.swing.JButton btnGuardarConfig;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelTamTablero;
    private javax.swing.JPanel panelJuegoConfig;
    private javax.swing.JRadioButton rb4x6;
    private javax.swing.JRadioButton rb6x4;
    private javax.swing.JRadioButton rb6x6;
    private javax.swing.JRadioButton rb8x8;
    // End of variables declaration//GEN-END:variables
}
