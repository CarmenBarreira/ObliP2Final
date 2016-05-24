
package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Configuracion extends javax.swing.JFrame {
    
    private JButton[][] botones;
    
    public Configuracion() {
        initComponents();
        panelJuegoConfig.setVisible(false);
       
        
        
        int dimensionF = 6;
        int dimensionC = 6;
        panelJuegoConfig.setLayout(new GridLayout(dimensionF, dimensionC));

        botones = new JButton[dimensionF+2][dimensionC+2];

        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

            JButton jButton = new JButton();

            jButton.addActionListener(new Configuracion.ListenerBoton(i, j));

            panelJuegoConfig.add(jButton);

            }

        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbTamTablero = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        panelJuegoConfig = new javax.swing.JPanel();
        btnGuardarConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(942, 658));
        setResizable(false);
        setSize(new java.awt.Dimension(942, 658));

        jcbTamTablero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbTamTablero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6*6", "4*6", "6*4", "8*8" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Elija el tamaño del tablero: ");

        javax.swing.GroupLayout panelJuegoConfigLayout = new javax.swing.GroupLayout(panelJuegoConfig);
        panelJuegoConfig.setLayout(panelJuegoConfigLayout);
        panelJuegoConfigLayout.setHorizontalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        panelJuegoConfigLayout.setVerticalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        btnGuardarConfig.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarConfig.setText("Guardar configuracion");
        btnGuardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarConfig)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfigActionPerformed
         String opcionTamTablero = (String) jcbTamTablero.getSelectedItem();
         
         
        

    }//GEN-LAST:event_btnGuardarConfigActionPerformed
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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
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
    
    public int [] convertirTamanioTableroInt(String datoIngresado){
        /*Este metodo recibe el valor seleccionado del combo box, 
        lo convierte en un int [] en posicion 0 estaran las filas del tablero
        y en posicion 1 estaran la cantidad de columnas.*/
        
        int [] tamanio = new int[2];
        if(datoIngresado.equalsIgnoreCase("6*6")){ //tablero 6*6
            tamanio[0]=6;
            tamanio[1]=6;
        }else{
            if(datoIngresado.equalsIgnoreCase("4*6")){ //tablero 4*6
                tamanio[0]=4;
                tamanio[1]=6;
            }else{
                if(datoIngresado.equalsIgnoreCase("6*4")){ //tablero 6*4
                    tamanio[0]=6;
                    tamanio[1]=4;
                }
                else{ //tablero 8*8
                    tamanio[0]=8;
                    tamanio[1]=8;
                }
            }
        }
        return tamanio;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jcbTamTablero;
    private javax.swing.JPanel panelJuegoConfig;
    // End of variables declaration//GEN-END:variables
}
