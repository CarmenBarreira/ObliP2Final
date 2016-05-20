
package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import javax.swing.JOptionPane;

public class Jugadores extends javax.swing.JFrame {

    Sistema miSistema = new Sistema();
    
    
    public Jugadores() {
        
       // jPanelAgregarJugador.setVisible(false);
        initComponents();
        jPanelAgregarJugador.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jBtnAgregarJugador = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelRanking = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanelAgregarJugador = new javax.swing.JPanel();
        jLabelAgregarEditarJugador = new javax.swing.JLabel();
        jLabelAlias = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTxtAlias = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jLabelNombre1 = new javax.swing.JLabel();
        jTxtEdad = new javax.swing.JTextField();
        btnAgregarUsuario = new javax.swing.JButton();
        jBtnMusic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(942, 658));

        jButton1.setText("Borrar Jugador");

        jBtnAgregarJugador.setText("Agregar Jugador");
        jBtnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarJugadorActionPerformed(evt);
            }
        });

        jButton3.setText("Editar Jugador");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Alias", "Nombre", "Partidas Ganadas", "Partidas Perdidas", "Partidas Empatadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("RANKING");

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addGroup(jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRankingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRankingLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRankingLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jPanelAgregarJugador.setEnabled(false);

        jLabelAgregarEditarJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAgregarEditarJugador.setText("Agregar Jugador");

        jLabelAlias.setText("Alias: ");

        jLabelNombre.setText("Nombre: ");

        jTxtAlias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAliasActionPerformed(evt);
            }
        });

        jTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreActionPerformed(evt);
            }
        });

        jLabelNombre1.setText("Edad: ");

        jTxtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEdadActionPerformed(evt);
            }
        });

        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAgregarJugadorLayout = new javax.swing.GroupLayout(jPanelAgregarJugador);
        jPanelAgregarJugador.setLayout(jPanelAgregarJugadorLayout);
        jPanelAgregarJugadorLayout.setHorizontalGroup(
            jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarJugadorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelAlias)
                    .addComponent(jLabelNombre1))
                .addGap(18, 18, 18)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarJugadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarJugadorLayout.createSequentialGroup()
                        .addComponent(jLabelAgregarEditarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarJugadorLayout.createSequentialGroup()
                        .addComponent(btnAgregarUsuario)
                        .addGap(119, 119, 119))))
        );
        jPanelAgregarJugadorLayout.setVerticalGroup(
            jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarJugadorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelAgregarEditarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAlias)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAgregarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre1)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnAgregarUsuario)
                .addGap(48, 48, 48))
        );

        jBtnMusic.setLabel("Music");
        jBtnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMusicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanelAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jBtnMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarJugadorActionPerformed
        // TODO add your handling code here:
        
        jPanelRanking.setVisible(false);  // seteo visible = false al panel de ranking
        jPanelAgregarJugador.setVisible(true); // seteo visible al panel de agregar jugador
       
             
    }//GEN-LAST:event_jBtnAgregarJugadorActionPerformed

    private void jTxtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEdadActionPerformed

    private void jTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNombreActionPerformed

    private void jTxtAliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAliasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAliasActionPerformed

    private void jBtnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMusicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnMusicActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        String nombre, alias;
        int edad =0 ;
        alias = jTxtAlias.getText();
        nombre = jTxtNombre.getText();
    //   edad = Integer.parseInt(jTxtEdad.getText());
        if (!stringCorrecto(alias, "alias") && (!stringCorrecto(nombre, "nombre"))){
            JOptionPane.showMessageDialog(null, "El alias y nombre ingresados no son correcto!"
                    + "Asegurese que no sean vacío, ni comienze con espacios",
                "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);
        }     
        else{
            if(!stringCorrecto(alias, "alias")){
                JOptionPane.showMessageDialog(null, "El alias ingresado no es correcto!"
                    + "Asegurese que no sea vacío, ni comienze con espacios",
                "ALIAS INCORRECTO", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!stringCorrecto(nombre, "nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no es correcto!"
                    + "Asegurese que no sea vacío, ni comienze con espacios",
                "NOMBRE INCORRECTO", JOptionPane.ERROR_MESSAGE);
                }else{
                    Jugador j = new Jugador (alias, nombre, edad);
                    miSistema.agregarJugador(j);
                    JOptionPane.showMessageDialog(null, "Jugador" + alias +  " ingresado con éxito!",
                            "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jugadores().setVisible(true);
                
            }
        });
         
    }
    
    public boolean stringCorrecto (String s, String tipo){
        /*Esta funcion valida si el string que se pasa por parametro segun el tipo
        es o no valido. Y retorna un booleano segun sea o no valido*/
        boolean esCorrecto = false;
        boolean espaciosVacios;
        
        espaciosVacios = false; // s.charAt(0) == ' '; //empieza con espacio
        if (s.equals("") || espaciosVacios) {
            //el string esta vacio o empieza con espacio
            if (tipo.toUpperCase().equals("nombre".toUpperCase()) || 
                    (tipo.toUpperCase().equals("alias".toUpperCase()))) {
                esCorrecto=false;
            }    
        } else {
            esCorrecto = true;
        }
        
        return esCorrecto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton jBtnAgregarJugador;
    private javax.swing.JButton jBtnMusic;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAgregarEditarJugador;
    private javax.swing.JLabel jLabelAlias;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JPanel jPanelAgregarJugador;
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtAlias;
    private javax.swing.JTextField jTxtEdad;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables

   

}
