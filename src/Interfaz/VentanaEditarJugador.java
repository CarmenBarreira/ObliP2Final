/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Juan
 */
public class VentanaEditarJugador extends javax.swing.JFrame {

    boolean esNuevo = true;
    Jugador j;

    /**
     * Creates new form VentanaAgregarJugador
     */
    public VentanaEditarJugador(Sistema unSis) {
        initComponents();
        sis = unSis;

    }

    public VentanaEditarJugador(Sistema unSis, Jugador juga) {
        initComponents();
        sis = unSis;
        jTxtAlias.setText(juga.getAlias());
        jTxtNombre.setText(juga.getAlias());
        jTxtEdad.setText("" + juga.getEdad());
        esNuevo = false;
        j = juga;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtNombre = new javax.swing.JTextField();
        jTxtAlias = new javax.swing.JTextField();
        jTxtEdad = new javax.swing.JTextField();
        btnAgregarJugador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarJugador.setText("Agregar Jugador");
        btnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugadorActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Alias");

        jLabel4.setText("Edad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarJugador)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58)
                .addComponent(btnAgregarJugador)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        String nombre, alias;
        int edad = 0;
        alias = jTxtAlias.getText();
        nombre = jTxtNombre.getText();
        Jugador tempJugador;
        try {
            edad = Integer.parseInt(jTxtEdad.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "La edad es incorrecta, ingrese un numero valido", "Edad Incorrecta", ERROR_MESSAGE);
            jTxtEdad.selectAll();
            jTxtEdad.requestFocusInWindow();
        }
        if (esNuevo) {
            tempJugador = new Jugador(alias, nombre, edad);

        } else {
            tempJugador = new Jugador(alias, nombre, edad, j.getCantidadPartidasPerdidas(), j.getCantidadPartidasGanadas(), j.getCantidadPartidasEmpatadas());

        }
        
        
        if (!(stringCorrecto(alias, "alias"))) {
            JOptionPane.showMessageDialog(this, "El Alias es Incorrecto", "Alias Incorrecto", ERROR_MESSAGE);
            jTxtAlias.selectAll();
            jTxtAlias.requestFocusInWindow();
        }
        if (!(stringCorrecto(nombre, "nombre"))) {
            JOptionPane.showMessageDialog(this, "El nombre es Incorrecto", "Nombre Incorrecto", ERROR_MESSAGE);
            jTxtNombre.selectAll();
            jTxtNombre.requestFocusInWindow();
        }
        if (sis.getListaJugadores().indexOf(tempJugador) != -1) {
            JOptionPane.showMessageDialog(this, "Ya Existe un jugador con el Alias: " + tempJugador.getAlias(), "Jugador Duplicado", ERROR_MESSAGE);
            jTxtNombre.selectAll();
            jTxtNombre.requestFocusInWindow();
        }
        
        if ((stringCorrecto(alias, "alias")) && (stringCorrecto(nombre, "nombre")) && ((edad > 0) && (edad < 80)) && sis.getListaJugadores().indexOf(tempJugador) == -1) {
            if (esNuevo) {
                sis.agregarJugador(tempJugador);
                JOptionPane.showMessageDialog(this, "Jugador creado correctamente", "Jugador creado exitosamente", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {

                sis.getListaJugadores().add(tempJugador);
                sis.eliminarJugador(j);
                JOptionPane.showMessageDialog(this, "Jugador editado correctamente", "Jugador editado exitosamente", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            }

        }

    }//GEN-LAST:event_btnAgregarJugadorActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaAgregarJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//Sistema sis = new Sistema();
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaAgregarJugador(sis).setVisible(true);
//            }
//        });
    }

    public boolean stringCorrecto(String s, String tipo) {
        /*Esta funcion valida si el string que se pasa por parametro segun el tipo
        es o no valido. Y retorna un booleano segun sea o no valido*/
        boolean esCorrecto = false;
        boolean espaciosVacios = false;
        if (!s.isEmpty()) {
            if (s.charAt(0) == ' ' || s.isEmpty()) {
                espaciosVacios = true;

            }
            if (s.equals("") || espaciosVacios) {
                //el string esta vacio o empieza con espacio
                if (tipo.toUpperCase().equals("nombre".toUpperCase())
                        || (tipo.toUpperCase().equals("alias".toUpperCase()))) {
                    esCorrecto = false;
                }
            } else {
                esCorrecto = true;
            }

        }

        return esCorrecto;
    }
    Sistema sis = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtAlias;
    private javax.swing.JTextField jTxtEdad;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
