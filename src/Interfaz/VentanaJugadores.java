package Interfaz;

import Dominio.Jugador;
import Dominio.Sistema;
import java.awt.Image;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
//        ImageIcon fot = new ImageIcon("/imagenes/corona.png");
//        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblCoronaImg.getWidth(), lblCoronaImg.getHeight(), Image.SCALE_DEFAULT));
//        lblCoronaImg.setIcon(icono);
//        //this.repaint();
        String path = "/imagenes/corona.png";  
        URL url = this.getClass().getResource(path);  
        ImageIcon icon = new ImageIcon(url);  
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblCoronaImg.getWidth(), lblCoronaImg.getHeight(), Image.SCALE_DEFAULT));

        lblCoronaImg.setIcon(icon); 
    }

    public void cargarLista() {
        borrarCacheTabla();
        DefaultTableModel modelo = (DefaultTableModel) tablaJugadores.getModel();
        for (int i = 0; i < miSistema.getListaJugadores().size(); i++) {
            Jugador jug = miSistema.getListaJugadores().get(i);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        lblRanking = new javax.swing.JLabel();
        jBtnMusic = new javax.swing.JButton();
        lblCoronaImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(942, 658));

        jBtnBorrar.setText("Borrar Jugador");
        jBtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarActionPerformed(evt);
            }
        });

        jBtnAgregarJugador.setText("Agregar Jugador");
        jBtnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarJugadorActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Jugador");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 155, Short.MAX_VALUE))
        );

        lblRanking.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRanking.setForeground(new java.awt.Color(0, 204, 102));
        lblRanking.setText("RANKING");

        jBtnMusic.setLabel("Music");
        jBtnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMusicActionPerformed(evt);
            }
        });

        lblCoronaImg.setBackground(new java.awt.Color(255, 255, 255));
        lblCoronaImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoronaImg.setFocusable(false);
        lblCoronaImg.setMaximumSize(new java.awt.Dimension(279, 181));
        lblCoronaImg.setMinimumSize(new java.awt.Dimension(279, 181));
        lblCoronaImg.setPreferredSize(new java.awt.Dimension(279, 181));
        lblCoronaImg.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCoronaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCoronaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jBtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarJugadorActionPerformed
        VentanaEditarJugador agregarVentana = new VentanaEditarJugador(miSistema);
        agregarVentana.setVisible(true);


    }//GEN-LAST:event_jBtnAgregarJugadorActionPerformed

    private void jBtnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMusicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnMusicActionPerformed

    private void jBtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            miSistema.eliminarJugador(miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()));
//            model.removeRow(tabla.getSelectedRow());
        }
        if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            VentanaEditarJugador editarJugador = new VentanaEditarJugador(miSistema, miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()));
            editarJugador.setVisible(true);
        }
        if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
    private javax.swing.JButton jBtnMusic;
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCoronaImg;
    private javax.swing.JLabel lblRanking;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }

}
