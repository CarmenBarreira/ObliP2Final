package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class VentanaJugadores extends javax.swing.JFrame implements Observer {

    Sistema miSistema = new Sistema();

    public VentanaJugadores(Sistema sis) {

        initComponents();
        miSistema = sis;
        miSistema.addObserver(this);
        update(null, null);
        
    }

    public void cargarLista() {
        borrarCacheTabla();
        DefaultTableModel modelo = (DefaultTableModel) tablaJugadores.getModel();
        ArrayList<Jugador> jugadoresOrdenadosRanking = miSistema.ordenarCrecienteJugador();
        for (int i = 0; i < jugadoresOrdenadosRanking.size(); i++) {
            Jugador jug = jugadoresOrdenadosRanking.get(i);
            modelo.addRow(new Object[][]{{null, null, null, null, null, null}});
            tablaJugadores.setValueAt(jug.getNombre(), i, 0);
            tablaJugadores.setValueAt(jug.getAlias(), i, 1);
            tablaJugadores.setValueAt(jug.getEdad(), i, 2);
            tablaJugadores.setValueAt(jug.getCantidadPartidasGanadas(), i, 3);
            tablaJugadores.setValueAt(jug.getCantidadPartidasPerdidas(), i, 4);
            tablaJugadores.setValueAt(jug.getCantidadPartidasEmpatadas(), i, 5);

        }

    }

    private void borrarCacheTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaJugadores.getModel();
        int filas = tablaJugadores.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnBorrar = new javax.swing.JButton();
        jBtnAgregarJugador = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanelRanking = new javax.swing.JPanel();
        lblRanking = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Menu Jugadores");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(942, 658));

        jBtnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trash-can-delete.png"))); // NOI18N
        jBtnBorrar.setText("Borrar Jugador");
        jBtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarActionPerformed(evt);
            }
        });

        jBtnAgregarJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_contact_act.png"))); // NOI18N
        jBtnAgregarJugador.setText("Agregar Jugador");
        jBtnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarJugadorActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editIcono.png"))); // NOI18N
        btnEditar.setText("Editar Jugador");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        lblRanking.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRanking.setForeground(new java.awt.Color(0, 204, 102));
        lblRanking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/podium.png"))); // NOI18N
        lblRanking.setText("RANKING");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-menu.png"))); // NOI18N
        jButton1.setText("Volver al menu principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoJuego.png"))); // NOI18N
        jButton2.setText("Jugar Partida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Alias", "Edad", "Partidas Ganadas", "Partidas Perdidas", "Partidas Empatadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jBtnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(lblRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(59, 59, 59))
                            .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarJugadorActionPerformed
        VentanaEditarJugador agregarVentana = new VentanaEditarJugador(miSistema);
        agregarVentana.setVisible(true);


    }//GEN-LAST:event_jBtnAgregarJugadorActionPerformed

    private void jBtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
         int filas = tablaJugadores.getSelectedRowCount();
        
        if (filas>1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar de a 1 Jugador", "Mas de 1 Jugador seleccionado", ERROR_MESSAGE);
        }else{
             if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro/a que desea borrar el/la jugador/a?",
                   "Borrar Jugador/a", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    miSistema.eliminarJugador(miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()));
           
            }else{
                if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
                    JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
                }
            }
        }        
    }//GEN-LAST:event_jBtnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        int filas = tablaJugadores.getSelectedRowCount();
        if (filas>1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar de a 1 Jugador", "Mas de 1 Jugador seleccionado", ERROR_MESSAGE);
        }else{
            if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
                VentanaEditarJugador editarJugador = new VentanaEditarJugador(miSistema, miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()));
                editarJugador.setVisible(true);
            }
            if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
                JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (miSistema.getListaJugadores().size() > 1) {
            VentanaPreJugar ventanPre = new VentanaPreJugar(miSistema);
            ventanPre.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Necesita al menos 2 jugadores para empezar", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

//    public static void main(String args[]) {
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaJugadores().setVisible(true);
//                
//            }
//        });
//         
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jBtnAgregarJugador;
    private javax.swing.JButton jBtnBorrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRanking;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
//        miSistema.setListaJugadores(miSistema.ordenarCrecienteJugador()); 
    }

}
