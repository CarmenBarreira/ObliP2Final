package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class VentanaEditarJugador extends javax.swing.JFrame {

    
    
    boolean esNuevo = true;
    Jugador j;

    public VentanaEditarJugador(Sistema unSis) {
        initComponents();
        sis = unSis;
        //seteo icono de form
        Image iconoPrincipal;
        try {
            iconoPrincipal = ImageIO.read(getClass().getResource("/imagenes/4En.png"));
            this.setIconImage(iconoPrincipal.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(VentanaConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public VentanaEditarJugador(Sistema unSis, Jugador juga) {

        initComponents();
        sis = unSis;
        Image iconoPrincipal;
        try {
            iconoPrincipal = ImageIO.read(getClass().getResource("/imagenes/4En.png"));
            this.setIconImage(iconoPrincipal.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(VentanaConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTxtAlias.setText(juga.getAlias());
        jTxtNombre.setText(juga.getAlias());
        jTxtEdad.setText("" + juga.getEdad());
        esNuevo = false;
        j = juga;
        lblTexto.setText("Edicion de Jugador");
        btnAgregarJugador.setText("Editar Jugador");
        this.setTitle("4enCuadrado - Edicion de Jugador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtNombre = new javax.swing.JTextField();
        jTxtAlias = new javax.swing.JTextField();
        jTxtEdad = new javax.swing.JTextField();
        btnAgregarJugador = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblAlias = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Agregar Jugador");
        setResizable(false);

        btnAgregarJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_contact_act.png"))); // NOI18N
        btnAgregarJugador.setText("Agregar Jugador");
        btnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugadorActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblAlias.setText("Alias");

        lblEdad.setText("Edad");

        lblTexto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblTexto.setText("Registro de Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTexto)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblAlias)
                                .addComponent(lblNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblEdad)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlias))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad))
                .addGap(38, 38, 38)
                .addComponent(btnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        String nombre, alias;
        int edad = 0;
        alias = jTxtAlias.getText();
        nombre = jTxtNombre.getText();
        Jugador tempJugador;
        boolean edadOK = true;
        
        if (!(stringCorrecto(alias, "alias")) && !(stringCorrecto(nombre, "nombre"))){
            JOptionPane.showMessageDialog(this, "Debe ingresar un Alias y Nombre correctos (los mismos no pueden ser vacios ni mayor a 10 caracteres)", "Datos Incorrectos", ERROR_MESSAGE);
            jTxtAlias.selectAll();
            jTxtAlias.requestFocusInWindow();
        }else{
            if (!(stringCorrecto(alias, "alias"))) {
                JOptionPane.showMessageDialog(this, "El Alias es Incorrecto (el mismo no puede ser vacio ni mayor a 10 caracteres)", "Alias Incorrecto", ERROR_MESSAGE);
                jTxtAlias.selectAll();
                jTxtAlias.requestFocusInWindow();
            }
            if (!(stringCorrecto(nombre, "nombre"))) {
                JOptionPane.showMessageDialog(this, "El nombre es Incorrecto (el mismo no puede ser vacio ni mayor a 10 caracteres)", "Nombre Incorrecto", ERROR_MESSAGE);
                jTxtNombre.selectAll();
                jTxtNombre.requestFocusInWindow();
            }
            try {
                edad = Integer.parseInt(jTxtEdad.getText());
            } catch (Exception e) {
                edadOK=false;    
                JOptionPane.showMessageDialog(this, "La edad es incorrecta, ingrese un numero valido", "Edad Incorrecta", ERROR_MESSAGE);
                jTxtEdad.selectAll();
                jTxtEdad.requestFocusInWindow();
            }
            
            if (!((edad > 7) && (edad < 101)) && edadOK) {
                JOptionPane.showMessageDialog(this, "Edad Incorrecta (la misma debe ser > 7 y menor a 100)", "Edad Incorrecto", ERROR_MESSAGE);
                jTxtEdad.selectAll();
                jTxtEdad.requestFocusInWindow();
            }
        
        }
        if (esNuevo) {
            tempJugador = new Jugador(alias, nombre, edad);

        } else {
            tempJugador = new Jugador(alias, nombre, edad, j.getCantidadPartidasPerdidas(), j.getCantidadPartidasGanadas(), j.getCantidadPartidasEmpatadas());
        }
        
        
        if (sis.getListaJugadores().indexOf(tempJugador) != -1) {
            JOptionPane.showMessageDialog(this, "Ya Existe un jugador con el Alias: " + tempJugador.getAlias(), "Jugador Duplicado", ERROR_MESSAGE);
            jTxtNombre.selectAll();
            jTxtNombre.requestFocusInWindow();
        }

        if ((stringCorrecto(alias, "alias")) && (stringCorrecto(nombre, "nombre")) && ((edad > 7) && (edad < 101)) && sis.getListaJugadores().indexOf(tempJugador) == -1) {
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
            if (s.equals("") || espaciosVacios || s.length()>10) {
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
    private javax.swing.JTextField jTxtAlias;
    private javax.swing.JTextField jTxtEdad;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
