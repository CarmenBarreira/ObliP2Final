package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class VentanaJugarPartida extends javax.swing.JFrame {

    private JButton[][] botones;
    
   
   
    

    public VentanaJugarPartida(Sistema elSis) {
        
        initComponents();
        // crear botones y agregarlos al panel
        sis = elSis;
        int dimensionF = 6;
        int dimensionC = 6;
        
        //hago invisible la parte de mover hueco hasta que no ingrese ficha
        panelMoverHueco.setVisible(false);
        lblMoverHueco.setVisible(false);
        
        panelJuego.setLayout(new GridLayout(dimensionF, dimensionC));

        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();

                jButton.addActionListener(new ListenerBoton(i, j));

                panelJuego.add(jButton);

            }

        }
        
               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        panelJuego = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textArea1 = new java.awt.TextArea();
        panelMoverHueco = new javax.swing.JPanel();
        btnMoverHuecoIzquierda = new javax.swing.JButton();
        btnMoverHuecoDerecha = new javax.swing.JButton();
        btnMoverHuecoArriba = new javax.swing.JButton();
        btnMoverHuecoAbajo = new javax.swing.JButton();
        btnRendirse = new javax.swing.JButton();
        lblMoverHueco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnElegirJugadores = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(942, 658));
        setResizable(false);
        setSize(new java.awt.Dimension(942, 658));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego);
        panelJuego.setBounds(490, 130, 420, 370);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 510, 440, 60);
        getContentPane().add(textArea1);
        textArea1.setBounds(30, 320, 420, 160);

        btnMoverHuecoIzquierda.setText("Izquierda");

        btnMoverHuecoDerecha.setText("Derecha");

        btnMoverHuecoArriba.setText("Arriba");

        btnMoverHuecoAbajo.setText("Abajo");

        javax.swing.GroupLayout panelMoverHuecoLayout = new javax.swing.GroupLayout(panelMoverHueco);
        panelMoverHueco.setLayout(panelMoverHuecoLayout);
        panelMoverHuecoLayout.setHorizontalGroup(
            panelMoverHuecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoverHuecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMoverHuecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMoverHuecoLayout.createSequentialGroup()
                        .addComponent(btnMoverHuecoIzquierda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnMoverHuecoDerecha))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMoverHuecoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelMoverHuecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMoverHuecoLayout.createSequentialGroup()
                                .addComponent(btnMoverHuecoArriba)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMoverHuecoLayout.createSequentialGroup()
                                .addComponent(btnMoverHuecoAbajo)
                                .addGap(60, 60, 60))))))
        );
        panelMoverHuecoLayout.setVerticalGroup(
            panelMoverHuecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoverHuecoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnMoverHuecoArriba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMoverHuecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoverHuecoIzquierda)
                    .addComponent(btnMoverHuecoDerecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoverHuecoAbajo)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(panelMoverHueco);
        panelMoverHueco.setBounds(40, 110, 200, 180);

        btnRendirse.setText("Rendirse");
        btnRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRendirseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRendirse);
        btnRendirse.setBounds(10, 540, 110, 30);

        lblMoverHueco.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMoverHueco.setForeground(new java.awt.Color(0, 204, 102));
        lblMoverHueco.setText("MOVER SUBTABLERO");
        getContentPane().add(lblMoverHueco);
        lblMoverHueco.setBounds(40, 40, 360, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 51));
        jLabel2.setText("TURNO DE JUGADOR CACHO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(540, 50, 360, 70);

        btnElegirJugadores.setText("Elegir Jugadores");
        btnElegirJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirJugadoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnElegirJugadores);
        btnElegirJugadores.setBounds(260, 220, 170, 40);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(66, 40));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(181, 40));

        jMenu1.setText("Partida");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Jugadores");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ayuda");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRendirseActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro desea abandonar la partida?");
        /*
        0 - selecciono SI
        1 - selecciono NO
        2- selecciono Cancelar
        */
        if (resp == 0){ //abandona la partida
        }
        
    }//GEN-LAST:event_btnRendirseActionPerformed

    private void btnElegirJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirJugadoresActionPerformed
        VentanaJugadores vJugadores = new VentanaJugadores(sis);
        Rectangle rct = vJugadores.getGraphicsConfiguration().getBounds();
        vJugadores.setLocation((rct.width - vJugadores.getWidth()) / 2, (rct.height - vJugadores.getHeight()) / 2);
        vJugadores.setVisible(true);
        
    
    }//GEN-LAST:event_btnElegirJugadoresActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaJugarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJugarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJugarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJugarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaJugarPartida().setVisible(true);
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

    Sistema sis = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirJugadores;
    private javax.swing.JButton btnMoverHuecoAbajo;
    private javax.swing.JButton btnMoverHuecoArriba;
    private javax.swing.JButton btnMoverHuecoDerecha;
    private javax.swing.JButton btnMoverHuecoIzquierda;
    private javax.swing.JButton btnRendirse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblMoverHueco;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelMoverHueco;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
