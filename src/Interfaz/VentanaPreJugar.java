/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class VentanaPreJugar extends javax.swing.JFrame {
    
    JFileChooser fc;
    Jugador jBlanco = new Jugador();
    Jugador jNegro = new Jugador();
    private JButton[][] botones;
    Sistema miSistema = new Sistema();
    JButton cargar;
    ImageIcon cargarFicha = new ImageIcon("\\images\\cargarFicha.png");
    boolean hayJNegro = false;
    boolean hayJBlanco = false;
    
    public VentanaPreJugar(Sistema unSis) {
        
        miSistema = unSis;
        Tablero tab = new Tablero(miSistema.getConfPartida()[0], miSistema.getConfPartida()[1]);
        initComponents();
        System.out.print(tab.getTablero().length);
        mostrarTableroConSubTableros(tab.getTablero().length, tab.getTablero()[0].length, tab);
        cargarLista();
        jButtonFichaBlanca.setIcon(cargarFicha);
        
        panelJuegoConfig.setVisible(true);
        
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
        }
        
    }
    
    private void borrarCacheTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaJugadores.getModel();
        int filas = tablaJugadores.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        jButtonJugadorBlanco = new javax.swing.JButton();
        jButtonJugadorNegro = new javax.swing.JButton();
        jBlancolbl = new javax.swing.JLabel();
        jlabelNombreJNegro = new javax.swing.JLabel();
        jNombreBLanco = new javax.swing.JLabel();
        jButtonFichaBlanca = new javax.swing.JButton();
        jButtonFichaNegra = new javax.swing.JButton();
        jCargarPartida = new javax.swing.JButton();
        jButtonJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelJuegoConfig = new javax.swing.JPanel();
        jBlancolbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Pre Jugada");

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Alias", "Edad"
            }
        ));
        jScrollPane1.setViewportView(tablaJugadores);

        jButtonJugadorBlanco.setText("Jugador Blanco");
        jButtonJugadorBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugadorBlancoActionPerformed(evt);
            }
        });

        jButtonJugadorNegro.setText("Jugador Negro");
        jButtonJugadorNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugadorNegroActionPerformed(evt);
            }
        });

        jBlancolbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBlancolbl.setText("Jugador Negro");

        jlabelNombreJNegro.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jlabelNombreJNegro.setText("No seleccionado");

        jNombreBLanco.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jNombreBLanco.setForeground(new java.awt.Color(153, 153, 153));
        jNombreBLanco.setText("No seleccionado");

        jButtonFichaBlanca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFicha.png"))); // NOI18N
        jButtonFichaBlanca.setText("Cargar Imagen Ficha");

        jButtonFichaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFicha.png"))); // NOI18N
        jButtonFichaNegra.setText("Cargar Imagen Ficha");

        jCargarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inbox-upload-icon.png"))); // NOI18N
        jCargarPartida.setText("Cargar Partida");

        jButtonJugar.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jButtonJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoJuego.png"))); // NOI18N
        jButtonJugar.setText("JUGAR");
        jButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugarActionPerformed(evt);
            }
        });

        jLabel1.setText("La configuracion actual es:");

        panelJuegoConfig.setMinimumSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout panelJuegoConfigLayout = new javax.swing.GroupLayout(panelJuegoConfig);
        panelJuegoConfig.setLayout(panelJuegoConfigLayout);
        panelJuegoConfigLayout.setHorizontalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelJuegoConfigLayout.setVerticalGroup(
            panelJuegoConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jBlancolbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBlancolbl1.setText("Jugador Blanco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBlancolbl)
                            .addComponent(jLabel1)
                            .addComponent(jNombreBLanco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonFichaNegra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlabelNombreJNegro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFichaBlanca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBlancolbl1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonJugadorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonJugadorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addComponent(jButtonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCargarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jBlancolbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNombreBLanco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFichaBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBlancolbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelNombreJNegro)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFichaNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCargarPartida)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonJugadorBlanco)
                            .addComponent(jButtonJugadorNegro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJugadorBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugadorBlancoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            
            if (!jNegro.equals(miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()))) {
                jBlanco = miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow());
//            model.removeRow(tabla.getSelectedRow());
                jNombreBLanco.setText("" + jBlanco.getAlias());
                hayJBlanco = true;
            } else {
                JOptionPane.showMessageDialog(this, "No se puede seleccionar el mismo jugador.", "Error de jugadores", ERROR_MESSAGE);
            }
            
        }
        if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonJugadorBlancoActionPerformed

    private void jButtonJugadorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugadorNegroActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            
            if (!jBlanco.equals(miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()))) {
                jNegro = miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow());
//            model.removeRow(tabla.getSelectedRow());
                jlabelNombreJNegro.setText("" + jNegro.getAlias());
                hayJNegro = true;
                
            } else {
                JOptionPane.showMessageDialog(this, "No se puede seleccionar el mismo jugador.", "Error de jugadores", ERROR_MESSAGE);
            }
            
        }
        if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            JOptionPane.showMessageDialog(this, "No hay un jugador selecccionado!", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonJugadorNegroActionPerformed

    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugarActionPerformed
        if (hayJBlanco && hayJNegro) {
            Partida p = new Partida(miSistema.getConfPartida());
            p.setJugadorBlanco(jBlanco);
            p.setJugadorNegro(jNegro);
            VentanaJugarPartida nuevaVentana = new VentanaJugarPartida(miSistema, p);
            nuevaVentana.setVisible(true);
            this.dispose();
        } else {
            
            JOptionPane.showMessageDialog(this, "Faltan jugadores por seleccionar", "No hay suficientes jugadores", ERROR_MESSAGE);
        }
        {
            
        }

    }//GEN-LAST:event_jButtonJugarActionPerformed
    
    public void mostrarTableroConSubTableros(int dimensionF, int dimensionC, Tablero tab) {
        
        panelJuegoConfig.setLayout(new GridLayout(dimensionF, dimensionC));
        
        botones = new JButton[dimensionF + 2][dimensionC + 2];
        
        for (int i = 1; i <= dimensionF; i++) {
            
            for (int j = 1; j <= dimensionC; j++) {
                
                JButton jButton = new JButton();
                panelJuegoConfig.add(jButton);
                botones[i][j] = jButton;
                jButton.setEnabled(false);
                if (tab.getTablero()[i - 1][j - 1] == 'X') {
                    botones[i][j].setBackground(Color.PINK);
                    botones[i][j].setText("X");
                }
            }
            
        }
        
    }

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
//            java.util.logging.Logger.getLogger(VentanaPreJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPreJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPreJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPreJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPreJugar().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBlancolbl;
    private javax.swing.JLabel jBlancolbl1;
    private javax.swing.JButton jButtonFichaBlanca;
    private javax.swing.JButton jButtonFichaNegra;
    private javax.swing.JButton jButtonJugadorBlanco;
    private javax.swing.JButton jButtonJugadorNegro;
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JButton jCargarPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNombreBLanco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelNombreJNegro;
    private javax.swing.JPanel panelJuegoConfig;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
