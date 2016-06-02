package Interfaz;

import Dominio.Sistema;
import Dominio.Tablero;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class VentanaConfiguracion extends javax.swing.JFrame {

    private JButton[][] botones;
    private int[] subtableroSelected = {0, 0};
    private int posHueco;
    private int opcionTablero;

    public VentanaConfiguracion(Sistema unSis) {
        initComponents();
        sis = unSis;
        opcionTablero = sis.getConfPartida()[0];
        posHueco = sis.getConfPartida()[1];
        panelJuegoConfig.setVisible(true);
        panelJuegoConfig.setPreferredSize(new Dimension(447, 396));
        panelJuegoConfig.setMinimumSize(new Dimension(447, 396));
        panelJuegoConfig.setMaximumSize(new Dimension(447, 396));
        Tablero tab = new Tablero(sis.getConfPartida()[0], sis.getConfPartida()[1]);
        mostrarTableroConSubTableros((tab.getTablero().length / 2), (tab.getTablero()[0].length / 2), sis.getConfPartida()[1]);
        int tablero = sis.getConfPartida()[0];
        switch (tablero) {
            case 1:
                rb6x6.setSelected(true);
                break;
            case 2:
                rb4x6.setSelected(true);
                break;
            case 3:
                rb6x4.setSelected(true);
                break;
            case 4:
                rb8x8.setSelected(true);
                break;

        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Configuracion de Partida");
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
        btnGuardarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save_16.png"))); // NOI18N
        btnGuardarConfig.setText("Guardar configuracion");
        btnGuardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConfigActionPerformed(evt);
            }
        });

        jPanelTamTablero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar la posicion del hueco");

        jLabel2.setText("Dimensiones de Tablero");

        jButton1.setText("Si");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/music-icon.png"))); // NOI18N
        jLabel3.setText("Musica en Partida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanelTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(56, 56, 56)
                        .addComponent(btnGuardarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfigActionPerformed

        int[] confActual = new int[2];
        confActual[0] = opcionTablero;
        confActual[1] = posHueco;
        sis.setConfPartida(confActual);
        JOptionPane.showMessageDialog(this, "Configuracion guardada con exito!", "Configuracion Guardada", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();


    }//GEN-LAST:event_btnGuardarConfigActionPerformed

    private void rb6x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6x6ActionPerformed
        // TODO add your handling code here:
        panelJuegoConfig.removeAll();
        mostrarTableroConSubTableros(3, 3, 5);
        opcionTablero = 1;
        panelJuegoConfig.repaint();
        panelJuegoConfig.revalidate();


    }//GEN-LAST:event_rb6x6ActionPerformed

    private void rb4x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4x6ActionPerformed
        // TODO add your handling code here:
        panelJuegoConfig.removeAll();
        mostrarTableroConSubTableros(2, 3, 2);

        panelJuegoConfig.repaint();
        panelJuegoConfig.revalidate();
        opcionTablero = 2;

    }//GEN-LAST:event_rb4x6ActionPerformed

    private void rb6x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6x4ActionPerformed
        panelJuegoConfig.removeAll();
        mostrarTableroConSubTableros(3, 2, 2);
        panelJuegoConfig.repaint();
        panelJuegoConfig.revalidate();
        opcionTablero = 3;
    }//GEN-LAST:event_rb6x4ActionPerformed

    private void rb8x8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb8x8ActionPerformed
        // TODO add your handling code here:
        panelJuegoConfig.removeAll();
        mostrarTableroConSubTableros(4, 4, 7);
        panelJuegoConfig.repaint();
        panelJuegoConfig.revalidate();
        opcionTablero = 4;

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
            y = j;

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
        botones[fila][columna].setSelected(true);

        if (subtableroSelected[0] == 0 && subtableroSelected[1] == 0) {
            botones[fila][columna].setBackground(Color.LIGHT_GRAY);
            subtableroSelected[0] = fila;
            subtableroSelected[1] = columna;
        } else {
            botones[subtableroSelected[0]][subtableroSelected[1]].setBackground(null);
            botones[fila][columna].setBackground(Color.LIGHT_GRAY);
            subtableroSelected[0] = fila;
            subtableroSelected[1] = columna;
        }
        posHueco = (int) Integer.parseInt(botones[fila][columna].getText());

    }

    public void mostrarTableroConSubTableros(int dimensionF, int dimensionC, int hueco) {
        panelJuegoConfig.setLayout(new GridLayout(dimensionF, dimensionC));
        int cont = 1;
        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();

                jButton.addActionListener(new ListenerBoton(i, j));
                jButton.setText("" + cont);
                panelJuegoConfig.add(jButton);
                botones[i][j] = jButton;
                cont++;

                if (Integer.parseInt(botones[i][j].getText()) == hueco) {
                    botones[i][j].setSelected(true);
                    botones[i][j].setBackground(Color.LIGHT_GRAY);
                    subtableroSelected[0] = i;
                    subtableroSelected[1] = j;
                }

            }

        }

    }

    Sistema sis = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroupTamTablero;
    private javax.swing.JButton btnGuardarConfig;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelTamTablero;
    private javax.swing.JPanel panelJuegoConfig;
    private javax.swing.JRadioButton rb4x6;
    private javax.swing.JRadioButton rb6x4;
    private javax.swing.JRadioButton rb6x6;
    private javax.swing.JRadioButton rb8x8;
    // End of variables declaration//GEN-END:variables
}
