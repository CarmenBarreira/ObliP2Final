package Interfaz;

import Dominio.Sistema;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class frameCambiarFicha extends javax.swing.JFrame {

    Image fichaNegra;
    Image fichaBlanca;
    boolean cambioBlanca = false;
    boolean cambioNegra = false;

    public frameCambiarFicha(Sistema sis, VentanaJugarPartida ventana) {

        unSistema = sis;
        initComponents();
        ImageIcon blanco = new ImageIcon(unSistema.getPartidaActual().getFichaJBlanco().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
        ImageIcon negro = new ImageIcon(unSistema.getPartidaActual().getFichaJNegro().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));

        lblFichaBlanca.setIcon(blanco);
        lblFichaNegra.setIcon(negro);

        Image iconoPrincipal;
        try {
            iconoPrincipal = ImageIO.read(getClass().getResource("/imagenes/4En.png"));
            this.setIconImage(iconoPrincipal.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(VentanaConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.update(null, null);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        btnBlanco = new javax.swing.JButton();
        btnNegro = new javax.swing.JButton();
        lblFichaBlanca = new javax.swing.JLabel();
        lblFichaNegra = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaBlanca.png"))); // NOI18N
        btnBlanco.setText("Cambiar Ficha Blanca");
        btnBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlancoActionPerformed(evt);
            }
        });

        btnNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaNegra.png"))); // NOI18N
        btnNegro.setText("Cambiar Ficha Negra");
        btnNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegroActionPerformed(evt);
            }
        });

        lblFichaBlanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFichaBlanca.setText("Ficha Jugador Blanco");

        lblFichaNegra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFichaNegra.setText("Ficha Jugador Negro");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reload-icon.png"))); // NOI18N
        jButton1.setText("Cambiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblFichaBlanca)
                        .addGap(60, 60, 60)
                        .addComponent(lblFichaNegra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBlanco)
                        .addGap(33, 33, 33)
                        .addComponent(btnNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFichaBlanca)
                    .addComponent(lblFichaNegra))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlancoActionPerformed
        Image img = null;
        boolean esCorrecta = false;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                img = ImageIO.read(file);
                img = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                ImageIcon blanco = new ImageIcon(img);

                lblFichaBlanca.setIcon(blanco);
                esCorrecta = true;

            } catch (Exception a) {

                JOptionPane.showMessageDialog(this, "Formato no permitido", "Formato Incorrecto", ERROR_MESSAGE);

            }
            if (esCorrecta) {

                fichaBlanca = img;
                cambioBlanca = true;
            }
        } else {
            System.out.println("El usuario no cargo imagen");
        }
    }//GEN-LAST:event_btnBlancoActionPerformed

    private void btnNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegroActionPerformed
        Image imgNegra = null;
        boolean esCorrecta = false;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                imgNegra = ImageIO.read(file);
                imgNegra = imgNegra.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                ImageIcon negro = new ImageIcon(imgNegra);

                lblFichaNegra.setIcon(negro);
                esCorrecta = true;

            } catch (Exception a) {

                JOptionPane.showMessageDialog(this, "Formato no permitido", "Formato Incorrecto", ERROR_MESSAGE);

            }
            if (esCorrecta) {
                fichaNegra = imgNegra;
                cambioNegra = true;
            }
        } else {
            System.out.println("El usuario no cargo imagen");
        }
    }//GEN-LAST:event_btnNegroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro desea cambiar la ficha?");
        if (resp == 0) {

            if (cambioBlanca && cambioNegra) {
                unSistema.getPartidaActual().setFichaJBlanco(fichaBlanca);
                unSistema.getPartidaActual().setFichaJNegro(fichaNegra);
                this.dispose();

                if (!cambioBlanca && cambioNegra) {

                    unSistema.getPartidaActual().setFichaJNegro(fichaNegra);
                    this.dispose();
                }
                if (cambioBlanca && !cambioNegra) {
                    unSistema.getPartidaActual().setFichaJBlanco(fichaBlanca);
                    this.dispose();
                }
                if (!cambioBlanca && !cambioNegra) {

                    this.dispose();
                }

            } else {
                this.dispose();
            }

            if (resp == 1) {
                this.dispose();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

        /**
         * @param args the command line arguments
         */
//    public static void main(String args[]) {
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(frameCambiarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(frameCambiarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(frameCambiarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(frameCambiarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new frameCambiarFicha().setVisible(true);
////            }
////        });
    }
    Sistema unSistema = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlanco;
    private javax.swing.JButton btnNegro;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFichaBlanca;
    private javax.swing.JLabel lblFichaNegra;
    // End of variables declaration//GEN-END:variables
}
