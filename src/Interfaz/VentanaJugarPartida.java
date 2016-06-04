package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
import java.awt.event.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public final class VentanaJugarPartida extends javax.swing.JFrame implements Observer {

    int turno = 1;
    private JButton[][] botones;
    private JButton[] filas;
    private JButton[] columnas;
    boolean seRindio = false;
    Jugador jugadorAhora;
    char jugadorAhoraChar;
    boolean fichaPuesta;
    StyledDocument doc;
    Partida partidaActual;
    int posHuecoAnt;
    int dimensionC;
    Jugador j1, j2;
    int dimensionF;
    boolean hayGanador = false;
    SimpleAttributeSet formatoMovimientoFicha = new SimpleAttributeSet(); // DECLARACION DE FORMATO PARA LOS COLORES DEL TEXT PANE
    SimpleAttributeSet formatoMovimientoTablero = new SimpleAttributeSet(); // DECLARACION DE FORMATO PARA LOS COLORES DEL TEXT PANE
    SimpleAttributeSet formatoTurnoNuevo = new SimpleAttributeSet(); // DECLARACION DE FORMATO PARA LOS COLORES DEL TEXT PANE
    int cantFichasTotal;
    Icon fichaBlancaIcono;
    Icon fichaNegraIcono;
    Image fichaNegraImagen;
    Image fichaBlancaImagen;
    Icon hueco;
    Image imagenHueco;

    public VentanaJugarPartida(Sistema elSis, Partida p) {

        partidaActual = p;
        sis = elSis;

        sis.setPartidaActual(p);

        posHuecoAnt = partidaActual.getPosicionHuecoActual();
        StyleConstants.setForeground(formatoMovimientoFicha, Color.RED); //DECLARACION DE ESTILOS
        StyleConstants.setForeground(formatoMovimientoTablero, Color.MAGENTA);//DECLARACION DE ESTILOS
        StyleConstants.setForeground(formatoTurnoNuevo, Color.BLUE);//DECLARACION DE ESTILOS
        StyleConstants.setBold(formatoMovimientoFicha, true);
        StyleConstants.setBold(formatoMovimientoTablero, true);
        StyleConstants.setBold(formatoTurnoNuevo, true);

        j1 = partidaActual.getJugadorBlanco();
        j2 = partidaActual.getJugadorNegro();
        boolean noHayGanador = false;
        initComponents();

        doc = txtAreaDescrip.getStyledDocument();
        panelSubtablero.setVisible(false);
        fichaBlancaImagen = partidaActual.getFichaJBlanco().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        fichaBlancaIcono = new ImageIcon(fichaBlancaImagen);
        fichaNegraImagen = partidaActual.getFichaJNegro().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        fichaNegraIcono = new ImageIcon(fichaNegraImagen);
        imagenHueco = partidaActual.getFichaHueco().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        hueco = new ImageIcon(imagenHueco);
        lblNumeroTurno.setText("Turno: " + turno);
        cantFichasTotal = partidaActual.getTablero().getTablero().length * partidaActual.getTablero().getTablero()[0].length - 4;
        lblCantFichas.setText("Cantidad de Fichas Restantes: " + cantFichasTotal);
        mostrarTableroConSubTableros(p.getTablero().getTablero().length / 2, p.getTablero().getTablero()[0].length / 2, p);
        lblFichaBlanca.setIcon(fichaBlancaIcono);
        lblFichaNegra.setIcon(fichaNegraIcono);
        // crear botones y agregarlos al panel
        sis = elSis;
        dimensionF = p.getTablero().getTablero().length;
        dimensionC = p.getTablero().getTablero()[0].length;
        mostrarFilas(p);
        mostrarColumnas(p);
        panelLetras.setVisible(true);
        panelNumeros.setVisible(true);

        //hago invisible la parte de mover hueco hasta que no ingrese ficha
        mostrarTableroJuego(p);
        txtAreaDescrip.setBackground(Color.WHITE);
        jugadorAhora = j1;
        jugadorAhoraChar = 'B';
        escribirLineaPane("BIENVENIDO A 4 en CUADRADO", formatoTurnoNuevo, doc);
        escribirLineaPane("\nEs el turno del Jugador Blanco", formatoMovimientoTablero, doc);
        lblTurno.setText("Turno de Jugador " + j1.getAlias().toUpperCase() + " fichas blancas");
        partidaActual.addObserver(this);
        update(p, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnRendirse = new javax.swing.JButton();
        lblTurno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescrip = new javax.swing.JTextPane();
        panelSubtablero = new javax.swing.JPanel();
        panelNumeros = new javax.swing.JPanel();
        panelLetras = new javax.swing.JPanel();
        lblCantFichas = new javax.swing.JLabel();
        lblNumeroTurno = new javax.swing.JLabel();
        lblFichaNegra = new javax.swing.JLabel();
        lblFichaBlanca = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Partida en Curso");
        setPreferredSize(new java.awt.Dimension(942, 658));
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
        panelJuego.setBounds(480, 120, 420, 370);

        jButton1.setText("MUSICA");
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 510, 440, 60);

        btnRendirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rendirseIcono.png"))); // NOI18N
        btnRendirse.setText("Rendirse");
        btnRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRendirseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRendirse);
        btnRendirse.setBounds(10, 540, 110, 30);

        lblTurno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(51, 51, 51));
        lblTurno.setText("TURNO DE JUGADOR CACHO Fichas Blancas");
        getContentPane().add(lblTurno);
        lblTurno.setBounds(420, 10, 520, 70);

        jScrollPane1.setViewportView(txtAreaDescrip);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 330, 360, 130);

        javax.swing.GroupLayout panelSubtableroLayout = new javax.swing.GroupLayout(panelSubtablero);
        panelSubtablero.setLayout(panelSubtableroLayout);
        panelSubtableroLayout.setHorizontalGroup(
            panelSubtableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelSubtableroLayout.setVerticalGroup(
            panelSubtableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        getContentPane().add(panelSubtablero);
        panelSubtablero.setBounds(90, 100, 240, 220);

        javax.swing.GroupLayout panelNumerosLayout = new javax.swing.GroupLayout(panelNumeros);
        panelNumeros.setLayout(panelNumerosLayout);
        panelNumerosLayout.setHorizontalGroup(
            panelNumerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        panelNumerosLayout.setVerticalGroup(
            panelNumerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelNumeros);
        panelNumeros.setBounds(480, 70, 420, 50);

        javax.swing.GroupLayout panelLetrasLayout = new javax.swing.GroupLayout(panelLetras);
        panelLetras.setLayout(panelLetrasLayout);
        panelLetrasLayout.setHorizontalGroup(
            panelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        panelLetrasLayout.setVerticalGroup(
            panelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(panelLetras);
        panelLetras.setBounds(420, 120, 60, 370);

        lblCantFichas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCantFichas.setText("jLabel1");
        getContentPane().add(lblCantFichas);
        lblCantFichas.setBounds(160, 470, 230, 40);

        lblNumeroTurno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumeroTurno.setText("jLabel1");
        getContentPane().add(lblNumeroTurno);
        lblNumeroTurno.setBounds(40, 470, 110, 40);

        lblFichaNegra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFichaNegra.setText("Fichas Negras");
        getContentPane().add(lblFichaNegra);
        lblFichaNegra.setBounds(30, 20, 140, 60);

        lblFichaBlanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFichaBlanca.setText("Fichas Blancas");
        getContentPane().add(lblFichaBlanca);
        lblFichaBlanca.setBounds(190, 20, 160, 60);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaIconito.png"))); // NOI18N
        jMenu1.setText("Partida");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaMenuJuego.png"))); // NOI18N
        jMenuItem2.setText("Cambiar Diseño de Fichas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/music-icon.png"))); // NOI18N
        jMenuItem3.setText("Musica");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rendirseIcono.png"))); // NOI18N
        jMenuItem1.setText("Rendirse");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarFilas(Partida p) {
        panelLetras.setLayout(new GridLayout(dimensionF, 1));
        int contador = 0;
        filas = new JButton[dimensionF + 2];
        for (int i = 1; i <= dimensionF; i++) {
            JButton jButton = new JButton();
            panelLetras.add(jButton);
            filas[i] = jButton;
            filas[i].setText("" + numALetra(contador));
            filas[i].setEnabled(false);
            filas[i].setFont((new Font("Arial", Font.BOLD, 25)));
            contador++;
        }
    }

    public void mostrarColumnas(Partida p) {
        panelNumeros.setLayout(new GridLayout(1, dimensionC));
        int contador = 1;
        columnas = new JButton[dimensionC + 2];
        for (int i = 1; i <= dimensionC; i++) {
            JButton jButton = new JButton();
            panelNumeros.add(jButton);
            columnas[i] = jButton;
            columnas[i].setText("" + contador);
            columnas[i].setFont((new Font("Arial", Font.BOLD, 25)));
            columnas[i].setEnabled(false);
            contador++;
        }

    }

    public static char numALetra(int num) {
        //convierte la letra a numero, se utiliza para el ingreso de ubicación de la ficha.

        char letraRetorno = ' ';
        switch (num) {
            case 0:
                letraRetorno = 'A';
                break;
            case 1:
                letraRetorno = 'B';
                break;
            case 2:
                letraRetorno = 'C';
                break;
            case 3:
                letraRetorno = 'D';
                break;
            case 4:
                letraRetorno = 'E';
                break;
            case 5:
                letraRetorno = 'F';
                break;
            case 6:
                letraRetorno = 'G';
                break;
            case 7:
                letraRetorno = 'H';
                break;
        }
        return letraRetorno;
    }

    public void mostrarTableroJuego(Partida p) {
        int contFila = 0;

        LineBorder border = new LineBorder(Color.lightGray, 1);

        Dimension dim = new Dimension(55, 55);
        panelJuego.setLayout(new GridLayout(dimensionF, dimensionC));

        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {
            int contCol = 0;
            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();

                jButton.addActionListener(new ListenerBoton(i, j));

                panelJuego.add(jButton);
                botones[i][j] = jButton;
                botones[i][j].setBorder(border);
                botones[i][j].setPreferredSize(dim);
                if (contFila <= 1) {
                    if (contCol <= 2) {
                        botones[i][j].setBackground(new Color(162, 250, 203));
                        contCol++;
                    }
                    if (contCol > 2) {
                        botones[i][j].setBackground(new Color(125, 189, 154));
                        contCol++;
                        if (contCol == 5) {
                            contCol = 0;
                        }
                    }

                }

                if (contFila > 1) {

                    if (contCol <= 2) {
                        botones[i][j].setBackground(new Color(125, 189, 154));
                        contCol++;

                    }
                    if (contCol > 2) {
                        botones[i][j].setBackground(new Color(162, 250, 203));
                        contCol++;
                        if (contCol == 5) {
                            contCol = 0;
                        }

                    }

                }

                if (p.getTablero().getTablero()[i - 1][j - 1] == 'X') {
                    botones[i][j].setBackground(Color.PINK);
                    botones[i][j].setIcon(hueco);

                }
                if (p.getTablero().getTablero()[i - 1][j - 1] == 'B') {

                    botones[i][j].setIcon(fichaBlancaIcono);
                    botones[i][j].setEnabled(true);

                }
                if (p.getTablero().getTablero()[i - 1][j - 1] == 'N') {

                    botones[i][j].setIcon(fichaNegraIcono);
                    botones[i][j].setEnabled(true);

                }

            }

            contFila++;
            if (contFila == 4) {
                contFila = 0;
            }
        }
    }

    private void escribirLineaPane(String s, SimpleAttributeSet formato, StyledDocument doc) {

        try {
            doc.insertString(doc.getLength(), s, formato);
        } catch (BadLocationException ex) {
            Logger.getLogger(VentanaJugarPartida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void btnRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRendirseActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro desea abandonar la partida?");
        /*
        0 - selecciono SI
        1 - selecciono NO
        2- selecciono Cancelar
         */
        if (resp == 0) { //abandona la partida
            String ganador;
            if (jugadorAhora.equals(j1)) {
                ganador = determinarGanador('N');
                hayGanador = true;

            } else {
                ganador = determinarGanador('B');
                hayGanador = true;
            }
            JOptionPane.showMessageDialog(this, "\nFELICITACIONES " + ganador + " ganaste la partida!", "Felicitaciones " + ganador.toLowerCase(), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }

    }//GEN-LAST:event_btnRendirseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro desea abandonar la partida?");
        /*
        0 - selecciono SI
        1 - selecciono NO
        2- selecciono Cancelar
         */
        if (resp == 0) { //abandona la partida
            String ganador;
            if (jugadorAhora.equals(j1)) {
                ganador = determinarGanador('N');
                hayGanador = true;

            } else {
                ganador = determinarGanador('B');
                hayGanador = true;
            }
            JOptionPane.showMessageDialog(this, "\nFELICITACIONES " + ganador + " ganaste la partida!", "Felicitaciones " + ganador.toLowerCase(), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        frameCambiarFicha fcf = new frameCambiarFicha(sis, this);
        fcf.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            y = j;
        }

        public void actionPerformed(ActionEvent e) {

            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);

        }
    }

    private void clickBoton(int fila, int columna) {
        int[] posFicha = {fila - 1, columna - 1};

        if (fichaPuesta) {
            JOptionPane.showMessageDialog(this, "Ya puso la ficha de este turno", "Ficha ya jugada", JOptionPane.ERROR_MESSAGE);

        } else {
            boolean posCorrecta = sis.getPartidaActual().getTablero().setFicha(posFicha, jugadorAhoraChar);
            if (posCorrecta && !fichaPuesta && !hayGanador) {

                botones[fila][columna].setBackground(Color.BLUE);
                fichaPuesta = true;
                escribirLineaPane("\nEl Jugador " + jugadorAhora.getAlias() + " puso ficha en " + posFicha[0] + " " + posFicha[1], formatoMovimientoFicha, doc);
                panelSubtablero.setVisible(true);
                cantFichasTotal--;
                lblCantFichas.setText("Cantidad de Fichas Restantes: " + cantFichasTotal);

                if (!(partidaActual.getTablero().encontroGanador() == 'E')) {
                    hayGanador = true;
                    String ganador = determinarGanador(partidaActual.getTablero().encontroGanador());

                    // HACER UN IF GANADOR ES LO QUE HICISTE EN DETERMINADOR GANADOR
                    JOptionPane.showMessageDialog(this, "FELICITACIONES " + ganador + " ganaste la partida!", "Felicitaciones " + ganador.toLowerCase(), JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }

            if (!posCorrecta) {
                JOptionPane.showMessageDialog(this, "Posicion Incorrecta!", "Posicion incorrecta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String determinarGanador(char jugador) {
        String ganador = "";
        if (jugador == 'B') {
            ganador = "" + partidaActual.getJugadorBlanco().getAlias().toUpperCase();
            partidaActual.getJugadorBlanco().setCantidadPartidasGanadas(partidaActual.getJugadorBlanco().getCantidadPartidasGanadas() + 1);
            partidaActual.getJugadorNegro().setCantidadPartidasPerdidas(partidaActual.getJugadorNegro().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
            escribirLineaPane("FELICIDADES " + ganador.toUpperCase() + " GANASTE LA PARTIDA!", formatoTurnoNuevo, doc);
        }
        if (jugador == 'N') {
            ganador = "" + partidaActual.getJugadorNegro().getAlias().toUpperCase();
            partidaActual.getJugadorNegro().setCantidadPartidasGanadas(partidaActual.getJugadorNegro().getCantidadPartidasGanadas() + 1);
            partidaActual.getJugadorBlanco().setCantidadPartidasPerdidas(partidaActual.getJugadorBlanco().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
            escribirLineaPane("FELICIDADES " + ganador.toUpperCase() + " GANASTE LA PARTIDA!", formatoTurnoNuevo, doc);
        }
        /* AGREGAR METODO QUE SI ES A, DOY PARTIDAS DE EMPATE A AMBOS, ESCRIBO LINEAS DE QUE EMPATARON, Y HAY GANADOR TRUE*/
        return ganador;
    }

    private class ListenerBotonSubtableros implements ActionListener {

        private int cont;

        public ListenerBotonSubtableros(int r) {

            // en el constructor se almacena la fila y columna que se presionó
            cont = r;

        }

        public void actionPerformed(ActionEvent e) {

            // cuando se presiona un botón, se ejecutará este método
            clickBotonSubtableros(cont);

        }
    }

    private void clickBotonSubtableros(int Subtablero) {

        partidaActual.getTablero().moverHueco(partidaActual.getTablero().setNumeroSubtablero(Subtablero, partidaActual.getTablero().getOpcionDeTablero()));
        partidaActual.setPosicionHuecoActual(Subtablero);
        partidaActual.setDeshacerMovPosHueco(posHuecoAnt);
        posHuecoAnt = Subtablero;
        panelSubtablero.removeAll();
        mostrarTableroConSubTableros(dimensionF / 2, dimensionC / 2, partidaActual);
        panelSubtablero.revalidate();
        panelSubtablero.repaint();
        escribirLineaPane("\nEl Jugador " + jugadorAhora.getAlias().toUpperCase() + " movio el hueco al subtablero " + Subtablero, formatoMovimientoTablero, doc);
        panelSubtablero.setVisible(false);

        panelJuego.removeAll();
        mostrarTableroJuego(partidaActual);
        panelJuego.revalidate();
        panelJuego.repaint();
        if (!(partidaActual.getTablero().encontroGanador() == 'E')) {
            String ganador = determinarGanador(partidaActual.getTablero().encontroGanador());
            JOptionPane.showMessageDialog(this, "FELICITACIONES " + ganador + " ganaste la partida!", "Felicitaciones " + ganador.toLowerCase(), JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            //VER EMPATE

        }
        fichaPuesta = false;

        if (jugadorAhora.equals(j1)) {
            jugadorAhora = j2;
            jugadorAhoraChar = 'N';
            lblTurno.setText("Turno de Jugador " + j2.getAlias().toUpperCase() + " fichas negras");
            escribirLineaPane("\nEs el turno del Jugador Negro, Alias: " + j2.getAlias().toUpperCase(), formatoTurnoNuevo, doc);

        } else {
            jugadorAhora = j1;
            lblTurno.setText("Turno de Jugador " + j1.getAlias().toUpperCase() + " fichas blancas");
            escribirLineaPane("\nEs el turno del Jugador Blanco, Alias: " + j1.getAlias().toUpperCase(), formatoTurnoNuevo, doc);
            jugadorAhoraChar = 'B';
            turno++;
            lblNumeroTurno.setText("Turno: " + turno);

        }

    }

    public void mostrarTableroConSubTableros(int dimensionF, int dimensionC, Partida p) {
        panelSubtablero.setLayout(new GridLayout(dimensionF, dimensionC));
        int cont = 0;
        botones = new JButton[dimensionF + 2][dimensionC + 2];

        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();
                cont++;
                jButton.addActionListener(new ListenerBotonSubtableros(cont)); // PASO NUMERO DE SUBTABLERO
                panelSubtablero.add(jButton);
                botones[i][j] = jButton;

                if (cont == p.getPosicionHuecoActual()) { // EN CASO DE SER HUECO PINTO DE ROJO
                    botones[i][j].setSelected(true);
                    botones[i][j].setIcon(hueco);
                    botones[i][j].setBackground(Color.PINK);

                }

                if (!p.getTablero().validarPosicionHueco(p.getPosicionHuecoActual(), cont, p.getDeshacerMovPosHueco())) { // EN CASO DE NO SER VALIDO HAGO DISABLED EL BOTON
                    botones[i][j].setEnabled(false);

                }

            }

        }

    }

    @Override
    public void update(Observable o, Object arg) {
        fichaBlancaImagen = partidaActual.getFichaJBlanco().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        fichaNegraImagen = partidaActual.getFichaJNegro().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        fichaBlancaIcono = new ImageIcon(partidaActual.getFichaJBlanco());
        fichaNegraIcono = new ImageIcon(partidaActual.getFichaJNegro());
        lblFichaBlanca.setIcon(fichaBlancaIcono);
        lblFichaNegra.setIcon(fichaNegraIcono);
        panelJuego.removeAll();
        mostrarTableroJuego(partidaActual);
        panelJuego.revalidate();
        panelJuego.repaint();
    }
    Sistema sis = new Sistema();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRendirse;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantFichas;
    private javax.swing.JLabel lblFichaBlanca;
    private javax.swing.JLabel lblFichaNegra;
    private javax.swing.JLabel lblNumeroTurno;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelLetras;
    private javax.swing.JPanel panelNumeros;
    private javax.swing.JPanel panelSubtablero;
    private javax.swing.JTextPane txtAreaDescrip;
    // End of variables declaration//GEN-END:variables
}
