package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class VentanaJugarPartida extends javax.swing.JFrame {
    
    private JButton[][] botones;
    
    public VentanaJugarPartida(Sistema elSis, Partida p) {
        
        initComponents();
        // crear botones y agregarlos al panel
        sis = elSis;
        int dimensionF = p.getTablero().getTablero().length;
        int dimensionC = p.getTablero().getTablero()[0].length;

        //hago invisible la parte de mover hueco hasta que no ingrese ficha
        lblMoverHueco.setVisible(false);
        
        panelJuego.setLayout(new GridLayout(dimensionF, dimensionC));
        
        botones = new JButton[dimensionF + 2][dimensionC + 2];
        
        for (int i = 1; i <= dimensionF; i++) {
            
            for (int j = 1; j <= dimensionC; j++) {
                
                JButton jButton = new JButton();
                
                jButton.addActionListener(new ListenerBoton(i, j));
                
                panelJuego.add(jButton);
                botones[i][j] = jButton;
                if (p.getTablero().getTablero()[i - 1][j - 1] == 'X') {
                    botones[i][j].setBackground(Color.PINK);
                    botones[i][j].setEnabled(false);
                    
                }
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
        btnRendirse = new javax.swing.JButton();
        lblMoverHueco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Partida en Curso");
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
        if (resp == 0) { //abandona la partida
        }

    }//GEN-LAST:event_btnRendirseActionPerformed

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
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
