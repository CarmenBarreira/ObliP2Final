package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.sound.sampled.*;
import java.net.URL;

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
    Border bor;
    Icon fichaNegraIcono;
    Icon copa;
    Icon copaIcon = cargarImagenIconoDefault("cup.png");
    Icon rendirseIcon = cargarImagenIconoDefault("rendirseIconoMessage.png");
    Image fichaNegraImagen;
    Image fichaBlancaImagen;
    Icon hueco;
    Image imagenHueco;
    Timer t;
    String tiempolbl;
    Clip clip;

    public VentanaJugarPartida(Sistema elSis, Partida p) {

        partidaActual = p;
        sis = elSis;
        fichaBlancaImagen = partidaActual.getFichaJBlanco().getScaledInstance(100, 60, java.awt.Image.SCALE_SMOOTH);
        fichaBlancaIcono = new ImageIcon(fichaBlancaImagen);
        fichaNegraImagen = partidaActual.getFichaJNegro().getScaledInstance(100, 60, java.awt.Image.SCALE_SMOOTH);
        fichaNegraIcono = new ImageIcon(fichaNegraImagen);
        imagenHueco = partidaActual.getFichaHueco().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
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
        initComponents();
        lblFichaBlanca.setIcon(fichaBlancaIcono);
        lblFichaNegra.setIcon(fichaNegraIcono);
        doc = txtAreaDescrip.getStyledDocument();
        panelSubtablero.setVisible(false);

        hueco = new ImageIcon(imagenHueco);
        lblNumeroTurno.setText("Turno: " + turno);
        cantFichasTotal = partidaActual.getTablero().getTablero().length * partidaActual.getTablero().getTablero()[0].length - 4;
        lblCantFichas.setText("Cantidad de Fichas Restantes: " + cantFichasTotal);
        mostrarTableroConSubTableros(p.getTablero().getTablero().length / 2, p.getTablero().getTablero()[0].length / 2, p);

        t = new Timer(1000, new ActionListener() {
            int segundos = 0;
            int minutos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                segundos++;

                time.repaint();
                tiempolbl = "" + minutos + ":" + segundos;
                if (segundos > 59) {
                    segundos = segundos - 60;
                    minutos++;
                    tiempolbl = "" + minutos + ":" + segundos;
                }
                if (segundos < 10) {
                    tiempolbl = "" + minutos + ":0" + segundos;
                }
                time.setText("Tiempo de Partida: " + tiempolbl);
            }

        });

        t.start();
        // crear botones y agregarlos al panel
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

        partidaActual.addObserver(this);
        update(null, null);
        lblTurno.setIcon(fichaBlancaIcono);
        lblTurno.setText("Turno de " + j1.getAlias().toUpperCase());
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                rendirse();
            }
        });

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
        time = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnStopMusic = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cambiarFichaMenuItem = new javax.swing.JMenuItem();
        musicaMenuItem = new javax.swing.JMenuItem();
        rendirseMenuItem = new javax.swing.JMenuItem();

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
        panelJuego.setBounds(480, 120, 420, 370);

        jButton1.setText("PLAY MUSIC");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 500, 140, 40);

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
        lblTurno.setText("TURNO DE  CACHO");
        getContentPane().add(lblTurno);
        lblTurno.setBounds(530, 20, 340, 50);

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
        lblFichaNegra.setBounds(60, 20, 140, 60);

        lblFichaBlanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFichaBlanca.setText("Fichas Blancas");
        getContentPane().add(lblFichaBlanca);
        lblFichaBlanca.setBounds(220, 20, 160, 60);

        time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(0, 102, 102));
        time.setText("Tiempo de Partida:");
        getContentPane().add(time);
        time.setBounds(150, 540, 220, 30);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoTemp.png"))); // NOI18N
        getContentPane().add(lblLogo);
        lblLogo.setBounds(90, 90, 10, 10);

        btnStopMusic.setText("STOP MUSIC");
        btnStopMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopMusicActionPerformed(evt);
            }
        });
        getContentPane().add(btnStopMusic);
        btnStopMusic.setBounds(690, 500, 140, 40);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/partidaIconito.png"))); // NOI18N
        jMenu1.setText("Partida");

        cambiarFichaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cambiarFichaMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaMenuJuego.png"))); // NOI18N
        cambiarFichaMenuItem.setText("Cambiar Diseño de Fichas");
        cambiarFichaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarFichaMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(cambiarFichaMenuItem);

        musicaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        musicaMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/music-icon.png"))); // NOI18N
        musicaMenuItem.setText("Musica");
        musicaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicaMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(musicaMenuItem);

        rendirseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        rendirseMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rendirseIcono.png"))); // NOI18N
        rendirseMenuItem.setText("Rendirse");
        rendirseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendirseMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(rendirseMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ImageIcon cargarImagenIconoDefault(String imagen) {
        File f1 = new File("src\\imagenes\\" + imagen);
        Image copaImg;
        Image rendirse;

        ImageIcon icono = null;

        try {
            // si es la ficha blanca la cargo en la imagen de jugador blanco, asi cuando empiezo la partida si el user no selecciono nada
            // se carga esta imagen por defecto
            if (imagen.equals("cup.png")) {

                copaImg = ImageIO.read(f1);
                copaImg = copaImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);

                icono = new ImageIcon(copaImg);

            }
            if (imagen.equals("rendirseIconoMessage.png")) {
                rendirse = ImageIO.read(f1);
                rendirse = rendirse.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                icono = new ImageIcon(rendirse);

            }

        } catch (IOException ex) {
            Logger.getLogger(VentanaPreJugar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return icono;
    }

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
        rendirse();

    }//GEN-LAST:event_btnRendirseActionPerformed

    private void rendirse() {
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro desea abandonar la partida?");
        /*
        0 - selecciono SI
        1 - selecciono NO
        2- selecciono Cancelar
         */
        if (resp == 0) { //abandona la partida
            String ganador;
            t.stop();
            if (jugadorAhora.equals(j1)) {
                ganador = determinarGanador('N');
                hayGanador = true;

            } else {
                ganador = determinarGanador('B');
                hayGanador = true;

            }
            JOptionPane.showMessageDialog(this, "Felicitaciones " + ganador + " ganaste la partida en " + tiempolbl + " minutos", "FELICITACIONES " + ganador.toUpperCase(), JOptionPane.INFORMATION_MESSAGE, rendirseIcon);

            this.dispose();
        }
    }


    private void rendirseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendirseMenuItemActionPerformed
        rendirse();

    }//GEN-LAST:event_rendirseMenuItemActionPerformed

    private void cambiarFichaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarFichaMenuItemActionPerformed
        frameCambiarFicha fcf = new frameCambiarFicha(sis, this);
        fcf.setVisible(true);
    }//GEN-LAST:event_cambiarFichaMenuItemActionPerformed

    private void musicaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicaMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musicaMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
        try {
            musica("play", clip);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaJugarPartida.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problem en play");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnStopMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopMusicActionPerformed
        try {
            // TODO add your handling code here:
            musica("stop", clip);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaJugarPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStopMusicActionPerformed

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

                if (jugadorAhoraChar == 'B') {
                    botones[fila][columna].setIcon(fichaBlancaIcono);
                    botones[fila][columna].setFocusPainted(false);
                } else {
                    botones[fila][columna].setIcon(fichaNegraIcono);
                    botones[fila][columna].setFocusPainted(false);
                }

                fichaPuesta = true;
                escribirLineaPane("\nEl Jugador " + jugadorAhora.getAlias() + " puso ficha en " + numALetra(posFicha[0]) + "" + (posAFila((posFicha[1]), dimensionF) + 1), formatoMovimientoFicha, doc);
                panelSubtablero.setVisible(true);
                cantFichasTotal--;
                lblCantFichas.setText("Cantidad de Fichas Restantes: " + cantFichasTotal);

                if (!(partidaActual.getTablero().encontroGanador() == 'E')) {
                    hayGanador = true;
                    String ganador = determinarGanador(partidaActual.getTablero().encontroGanador());

                    if (partidaActual.getTablero().encontroGanador() == 'A') { // empate
                        JOptionPane.showMessageDialog(this, "Felicitaciones " + ganador + " empataron la partida!", "FELICITACIONES " + ganador.toUpperCase(), JOptionPane.INFORMATION_MESSAGE, copaIcon);
                        t.stop();
                    } else {
                        JOptionPane.showMessageDialog(this, "Felicitaciones " + ganador + " ganaste la partida en " + tiempolbl + " minutos", "FELICITACIONES " + ganador.toUpperCase(), JOptionPane.INFORMATION_MESSAGE, copaIcon);
                        t.stop();
                    }
                    this.dispose();
                }

            }

            if (!posCorrecta) {
                JOptionPane.showMessageDialog(this, "Posicion Incorrecta!", "Posicion incorrecta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void musica(String word, Clip clipAux) throws LineUnavailableException {
        String temp = word;
        File f1; 
        AudioInputStream audioIn;
        if (temp.equals("play")){
            try {
             
           f1 = new File("src\\imagenes\\cuatro.wav");
            audioIn = AudioSystem.getAudioInputStream(f1);

            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            
            } catch (UnsupportedAudioFileException e) {
             e.printStackTrace();
            } catch (IOException e) {
               e.printStackTrace();
            } catch (LineUnavailableException e) {
               e.printStackTrace();
            }
            
            

        }else{
            if (clipAux.isRunning()) 
                clipAux.stop();
        }
        
       
      

    }

    public String determinarGanador(char jugador) {
        String ganador = "";
        if (jugador == 'B') {
            ganador = "" + partidaActual.getJugadorBlanco().getAlias().toUpperCase();
            partidaActual.getJugadorBlanco().setCantidadPartidasGanadas(partidaActual.getJugadorBlanco().getCantidadPartidasGanadas() + 1);
            partidaActual.getJugadorNegro().setCantidadPartidasPerdidas(partidaActual.getJugadorNegro().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
            t.stop();
            escribirLineaPane("\nFELICIDADES " + ganador.toUpperCase() + " GANASTE LA PARTIDA!", formatoTurnoNuevo, doc);
        }
        if (jugador == 'N') {
            ganador = "" + partidaActual.getJugadorNegro().getAlias().toUpperCase();
            partidaActual.getJugadorNegro().setCantidadPartidasGanadas(partidaActual.getJugadorNegro().getCantidadPartidasGanadas() + 1);
            partidaActual.getJugadorBlanco().setCantidadPartidasPerdidas(partidaActual.getJugadorBlanco().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
            t.stop();
            escribirLineaPane("\nFELICIDADES " + ganador.toUpperCase() + " GANASTE LA PARTIDA!", formatoTurnoNuevo, doc);
        }

        if (jugador == 'A') { //ganaron los 2 = empate
            ganador = " " + partidaActual.getJugadorNegro().getAlias().toUpperCase() + " y "
                    + partidaActual.getJugadorBlanco().getAlias().toUpperCase() + " ";
            partidaActual.getJugadorNegro().setCantidadPartidasEmpatadas(partidaActual.getJugadorNegro().getCantidadPartidasEmpatadas() + 1);
            partidaActual.getJugadorBlanco().setCantidadPartidasEmpatadas(partidaActual.getJugadorBlanco().getCantidadPartidasEmpatadas() + 1);
            hayGanador = true;
            t.stop();
            escribirLineaPane("\nFELICIDADES " + ganador.toUpperCase() + " EMPATARON LA PARTIDA!", formatoTurnoNuevo, doc);
        }
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
        lblLogo.setSize(panelSubtablero.getSize());

        panelJuego.removeAll();
        mostrarTableroJuego(partidaActual);
        panelJuego.revalidate();
        panelJuego.repaint();
        if (!(partidaActual.getTablero().encontroGanador() == 'E')) {
            String ganador = determinarGanador(partidaActual.getTablero().encontroGanador());
            hayGanador = true;
            t.stop();
            if (partidaActual.getTablero().encontroGanador() == 'A') { // empate
                JOptionPane.showMessageDialog(this, "Empataron la partida!", "EMPATE " + ganador.toLowerCase(), JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Felicitaciones " + ganador + " ganaste la partida en " + tiempolbl + " minutos", "FELICITACIONES " + ganador.toUpperCase(), JOptionPane.INFORMATION_MESSAGE, copaIcon);

            }
            this.dispose();

        } else if (cantFichasTotal == 0) {
            t.stop();
            this.determinarGanador('A');
            JOptionPane.showMessageDialog(this, "Empataron la partida!", "EMPATE", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }

        fichaPuesta = false;

        if (jugadorAhora.equals(j1)) {
            jugadorAhora = j2;
            jugadorAhoraChar = 'N';
            lblTurno.setIcon(fichaNegraIcono);
            lblTurno.setText("Turno de " + j2.getAlias().toUpperCase());
            escribirLineaPane("\nEs el turno del Jugador Negro, Alias: " + j2.getAlias().toUpperCase(), formatoTurnoNuevo, doc);

        } else {
            jugadorAhora = j1;
            lblTurno.setIcon(fichaBlancaIcono);
            lblTurno.setText("Turno de Jugador " + j1.getAlias().toUpperCase());
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
        bor = BorderFactory.createLineBorder(Color.white);
        bor = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
        for (int i = 1; i <= dimensionF; i++) {

            for (int j = 1; j <= dimensionC; j++) {

                JButton jButton = new JButton();
                cont++;
                jButton.addActionListener(new ListenerBotonSubtableros(cont)); // PASO NUMERO DE SUBTABLERO
                panelSubtablero.add(jButton);
                botones[i][j] = jButton;
                jButton.setBorder(bor);

                if (cont == p.getPosicionHuecoActual()) { // EN CASO DE SER HUECO PINTO DE ROJO
                    botones[i][j].setSelected(true);
                    botones[i][j].setIcon(hueco);
                    botones[i][j].setBackground(Color.PINK);

                }

                if (p.getTablero().validarPosicionHueco(p.getPosicionHuecoActual(), cont, p.getDeshacerMovPosHueco())) { // EN CASO DE NO SER VALIDO HAGO DISABLED EL BOTON
                    botones[i][j].setEnabled(true);
                    botones[i][j].setText("" + cont);
                    botones[i][j].setForeground(new Color(125, 189, 154));
                    botones[i][j].setFont((new Font("Arial", Font.BOLD, 25)));
                    botones[i][j].setBackground(new Color(162, 250, 203));
                } else {

                    botones[i][j].setEnabled(false);
                }

            }

        }

    }

    public int posAFila(int nroDeFila, int dimension) {

        if (nroDeFila > dimension) {

            while (nroDeFila > dimension) {

                nroDeFila = nroDeFila - dimension;

            }

        }

        return nroDeFila;
    }

    @Override
    public void update(Observable o, Object arg) {
        fichaBlancaImagen = partidaActual.getFichaJBlanco().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        fichaBlancaIcono = new ImageIcon(fichaBlancaImagen);
        fichaNegraImagen = partidaActual.getFichaJNegro().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        fichaNegraIcono = new ImageIcon(fichaNegraImagen);
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
    private javax.swing.JButton btnStopMusic;
    private javax.swing.JMenuItem cambiarFichaMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantFichas;
    private javax.swing.JLabel lblFichaBlanca;
    private javax.swing.JLabel lblFichaNegra;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNumeroTurno;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JMenuItem musicaMenuItem;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelLetras;
    private javax.swing.JPanel panelNumeros;
    private javax.swing.JPanel panelSubtablero;
    private javax.swing.JMenuItem rendirseMenuItem;
    private javax.swing.JLabel time;
    private javax.swing.JTextPane txtAreaDescrip;
    // End of variables declaration//GEN-END:variables
}
