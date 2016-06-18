package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class VentanaPreJugar extends javax.swing.JFrame {

    JFileChooser fc;
    Jugador jBlanco = new Jugador();
    Jugador jNegro = new Jugador();
    private JButton[][] botones;
    Sistema miSistema = new Sistema();
    JButton cargar;
    Image jBlancoFicha;
    Image jNegroFicha;
    Image huecoFicha;
    Icon iconoHueco;
    boolean hayJNegro = false;
    boolean hayJBlanco = false;
    Tablero tab;

    public VentanaPreJugar(Sistema unSis) {

        miSistema = unSis;
        tab = new Tablero(miSistema.getConfPartida()[0], miSistema.getConfPartida()[1]);
        initComponents();
        iconoHueco = cargarImagenIconoDefault("hueco.png");
        cargarImagenIconoDefault("fichaBlanca.png");
        cargarImagenIconoDefault("fichaNegra.png");
        jButtonCambiarHueco.setIcon(iconoHueco);
        mostrarTableroConSubTableros(tab.getTablero().length, tab.getTablero()[0].length, tab);
        cargarLista();

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

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        jButtonJugadorBlanco = new javax.swing.JButton();
        jButtonJugadorNegro = new javax.swing.JButton();
        jNegrolbl = new javax.swing.JLabel();
        jlabelNombreNegro = new javax.swing.JLabel();
        jLabelNombreBlanco = new javax.swing.JLabel();
        jButtonFichaBlanca = new javax.swing.JButton();
        jButtonFichaNegra = new javax.swing.JButton();
        jCargarPartida = new javax.swing.JButton();
        jButtonJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelJuegoConfig = new javax.swing.JPanel();
        lblJBlanco = new javax.swing.JLabel();
        jButtonCambiarHueco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("4enCuadrado - Pre Jugada");
        setResizable(false);

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Alias", "Edad"
            }
        ));
        jScrollPane1.setViewportView(tablaJugadores);

        jButtonJugadorBlanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaBlanca.png"))); // NOI18N
        jButtonJugadorBlanco.setText("Jugador Blanco");
        jButtonJugadorBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugadorBlancoActionPerformed(evt);
            }
        });

        jButtonJugadorNegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fichitaNegra.png"))); // NOI18N
        jButtonJugadorNegro.setText("Jugador Negro");
        jButtonJugadorNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugadorNegroActionPerformed(evt);
            }
        });

        jNegrolbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jNegrolbl.setText("Jugador Negro");

        jlabelNombreNegro.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jlabelNombreNegro.setText("No seleccionado");

        jLabelNombreBlanco.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabelNombreBlanco.setForeground(new java.awt.Color(153, 153, 153));
        jLabelNombreBlanco.setText("No seleccionado");

        jButtonFichaBlanca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFichaBlanca.png"))); // NOI18N
        jButtonFichaBlanca.setText("Cargar Imagen Ficha");
        jButtonFichaBlanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFichaBlancaActionPerformed(evt);
            }
        });

        jButtonFichaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargarFichanegra.png"))); // NOI18N
        jButtonFichaNegra.setText("Cargar Imagen Ficha");
        jButtonFichaNegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFichaNegraActionPerformed(evt);
            }
        });

        jCargarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inbox-upload-icon.png"))); // NOI18N
        jCargarPartida.setText("Cargar Partida");
        jCargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCargarPartidaActionPerformed(evt);
            }
        });

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

        lblJBlanco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblJBlanco.setText("Jugador Blanco");

        jButtonCambiarHueco.setText("Diseño Hueco");
        jButtonCambiarHueco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarHuecoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNegrolbl)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonFichaNegra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlabelNombreNegro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFichaBlanca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelNombreBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblJBlanco)))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCambiarHueco, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCargarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonJugadorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonJugadorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButtonJugar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblJBlanco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNombreBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFichaBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jNegrolbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelNombreNegro)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFichaNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJuegoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCambiarHueco, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                jLabelNombreBlanco.setText("" + jBlanco.getAlias());
                hayJBlanco = true;
            } else {
                JOptionPane.showMessageDialog(this, "No se puede seleccionar el mismo jugador.", "Error de jugadores", ERROR_MESSAGE);
            }

        }
        if (tablaJugadores.getRowCount() == 0 || !tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {
            JOptionPane.showMessageDialog(this, "No hay un jugador seleccionado!", "No hay Jugadores", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonJugadorBlancoActionPerformed

    private ImageIcon cargarImagenIconoDefault(String imagen) {
        File f1 = new File("src\\imagenes\\" + imagen);
        Image blanca;
        Image negra;
        Image hueco;
        ImageIcon icono = null;

        try {

            // si es la ficha blanca la cargo en la imagen de jugador blanco, asi cuando empiezo la partida si el user no selecciono nada
            // se carga esta imagen por defecto
            if (imagen.equals("fichaBlanca.png")) {

                blanca = ImageIO.read(f1);
                blanca = blanca.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                icono = new ImageIcon(blanca);
                jBlancoFicha = ImageIO.read(f1);

            }
            if (imagen.equals("fichaNegra.png")) {
                negra = ImageIO.read(f1);
                negra = negra.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                icono = new ImageIcon(negra);
                jNegroFicha = ImageIO.read(f1);
            }
            if (imagen.equals("hueco.png")) {
                hueco = ImageIO.read(f1);
                hueco = hueco.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                icono = new ImageIcon(hueco);
                huecoFicha = ImageIO.read(f1);
            }

        } catch (IOException ex) {
            Logger.getLogger(VentanaPreJugar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return icono;
    }


    private void jButtonJugadorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugadorNegroActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaJugadores.getModel();
        if (tablaJugadores.isRowSelected(tablaJugadores.getSelectedRow())) {

            if (!jBlanco.equals(miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow()))) {
                jNegro = miSistema.getListaJugadores().get(tablaJugadores.getSelectedRow());
//            model.removeRow(tabla.getSelectedRow());
                jlabelNombreNegro.setText("" + jNegro.getAlias());
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
        Partida p = new Partida();
        
        if (hayJBlanco && hayJNegro) {
            
                p = new Partida(miSistema.getConfPartida(), jBlanco, jNegro, jBlancoFicha, jNegroFicha, huecoFicha);
             
            VentanaJugarPartida nuevaVentana = new VentanaJugarPartida(miSistema, p);
            nuevaVentana.setVisible(true);
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Faltan jugadores por seleccionar", "No hay suficientes jugadores", ERROR_MESSAGE);
        }
        {

        }

    }//GEN-LAST:event_jButtonJugarActionPerformed


    private void jCargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCargarPartidaActionPerformed
        JFileChooser fileChooserCargarPartida = new JFileChooser();
        int posSubTablero;
        int returnVal = fileChooserCargarPartida.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooserCargarPartida.getSelectedFile();
            String jBlanco, jNegro, tamTablero;   
            String ruta = file.getAbsolutePath();
            int largoRuta = ruta.length();
            Jugador blanco, negro;
            if (ruta.charAt(largoRuta-1) != 't' && ruta.charAt(largoRuta-1) != 'T' 
                    && (ruta.charAt(largoRuta-2) != 'x' && ruta.charAt(largoRuta-1) != 'X')
                    && (ruta.charAt(largoRuta-3) != 't' && ruta.charAt(largoRuta-1) != 'T')){
                JOptionPane.showMessageDialog(this, "El formato de archivo debe ser .txt ", 
                        "Formato de archivo incorrecto", ERROR_MESSAGE);
            }
            else{
                try {
                    miSistema.leerTXT(file);
                    archivo.ArchivoLectura.leerArchivo(file);
                    jBlanco = archivo.ArchivoLectura.linea();
                    blanco = new Jugador(jBlanco);
                    jNegro = archivo.ArchivoLectura.linea();
                    negro = new Jugador (jNegro);
                    int tamTab ;
                    if ((miSistema.getListaJugadores().indexOf(blanco) != -1)
                            && (miSistema.getListaJugadores().indexOf(negro) != -1)){
                        //los jugadores estan en el sistema
                        int aux [] = new int [2];
                        tamTablero = archivo.ArchivoLectura.linea();
                        tamTab= convertirTamTab(tamTablero);
                        Tablero tabAux = new Tablero(tamTab, 1);
                        int[] posHueco = new int[2];
                        int primeraPosHueco = 0;
                        aux = tabAux.setTamanioTablero(tamTab);
                        int filas =aux [0], col = aux[1]; 
                        char[][] tablero= new char[filas][col];
                        for (int i =0; i< filas; i++){
                            //leo fila 1
                            String filaLectura = archivo.ArchivoLectura.linea();
                            int a =0;
                            for (int j=0; j<col; j++){
                               // for (int a =0; i<filaLectura.length(); a++){
                                    if (filaLectura.charAt(a)=='B'){ //si leo B, pongo ficha blanca
                                       tablero[i][j]='B';
                                    }
                                    else{
                                        if (filaLectura.charAt(a)=='H'){//pongo hueco
                                            tablero[i][j]='X';
                                            if (primeraPosHueco == 0){
                                                posHueco[0]=i;
                                                posHueco[1]=j;

                                            }
                                            primeraPosHueco++;
                                        }
                                        else{
                                             if (filaLectura.charAt(a)=='N'){
                                                 //pongo ficha negra
                                                 tablero[i][j]='N';
                                             }
                                        }
                                    }
                                    a++;
                                //}
                            }
                        } //termino de llenar el tablero

                        posSubTablero = tabAux.getSubtablero(tamTab, posHueco);
                        Partida pAux = new Partida ();
                        tabAux.setTablero(tablero);
                        tabAux.setPosHueco(posHueco);
                        pAux.setTablero(tabAux);
                        miSistema.setPartidaActual(pAux);
                        int [] configPartida = new int [2];
                        configPartida [0] = tamTab;
                        configPartida [1] = posSubTablero;

                        miSistema.setConfPartida(configPartida);
                         JOptionPane.showMessageDialog(this, "Partida cargada correctamente", 
                                 "Partida cargada exitosamente", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{ // no estan los jugadores en el sistema
                        JOptionPane.showMessageDialog(this, "No se encuentran los jugadores (debe darlos de alta previamente)", "Jugadores no se encuentran", ERROR_MESSAGE);

                    }
                    archivo.ArchivoLectura.cerrar();

                } catch (IOException ex) {
                    Logger.getLogger(VentanaPreJugar.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
                        
        }
    }//GEN-LAST:event_jCargarPartidaActionPerformed

    private void jButtonFichaBlancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFichaBlancaActionPerformed
        Image img = null;
        boolean esCorrecta = false;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                img = ImageIO.read(file);
                img = img.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                ImageIcon blanco = new ImageIcon(img);

                jLabelNombreBlanco.setIcon(blanco);
                esCorrecta = true;
            } catch (Exception a) {

                JOptionPane.showMessageDialog(this, "Formato no permitido", "Formato Incorrecto", ERROR_MESSAGE);

            }
            if (esCorrecta) {
                jBlancoFicha = img;

            }
        } else {
            System.out.println("El usuario no cargo imagen");
        }


    }//GEN-LAST:event_jButtonFichaBlancaActionPerformed

    private void jButtonFichaNegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFichaNegraActionPerformed
        Image imgNegra = null;
        boolean esCorrecta = false;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                imgNegra = ImageIO.read(file);
                imgNegra = imgNegra.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                ImageIcon negro = new ImageIcon(imgNegra);

                jlabelNombreNegro.setIcon(negro);
                esCorrecta = true;
            } catch (Exception a) {

                JOptionPane.showMessageDialog(this, "Formato no permitido", "Formato Incorrecto", ERROR_MESSAGE);

            }
            if (esCorrecta) {
                jNegroFicha = imgNegra;

            }
        } else {
            System.out.println("El usuario no cargo imagen");
        }


    }//GEN-LAST:event_jButtonFichaNegraActionPerformed

    private void jButtonCambiarHuecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarHuecoActionPerformed
        Image hueco = null;
        boolean esCorrecta = false;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                hueco = ImageIO.read(file);
                hueco = hueco.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

                iconoHueco = new ImageIcon(hueco);

                jButtonCambiarHueco.setIcon(iconoHueco);
                esCorrecta = true;
            } catch (Exception a) {

                JOptionPane.showMessageDialog(this, "Formato no permitido", "Formato Incorrecto", ERROR_MESSAGE);

            }
            if (esCorrecta) {
                huecoFicha = hueco;
                panelJuegoConfig.removeAll();
                mostrarTableroConSubTableros(tab.getTablero().length, tab.getTablero()[0].length, tab);
                panelJuegoConfig.revalidate();
                panelJuegoConfig.repaint();

            }
        } else {
            System.out.println("El usuario no cargo imagen");
        }

    }//GEN-LAST:event_jButtonCambiarHuecoActionPerformed

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
                    botones[i][j].setEnabled(true);
                    botones[i][j].setBackground(Color.PINK);
                    botones[i][j].setIcon(iconoHueco);

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

    public int convertirTamTab (String tamanio){
        int retorno = 0;
        
        if (tamanio.equalsIgnoreCase("6*6")){ 
            retorno=1;
        }
        else{
            if (tamanio.equalsIgnoreCase("4*6")){
                retorno=2;
            }
            else{
                if (tamanio.equalsIgnoreCase("6*4")){
                    retorno=3;
                }
                else{
                    retorno=4;
                }
            }
        }
        
        return retorno;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButtonCambiarHueco;
    private javax.swing.JButton jButtonFichaBlanca;
    private javax.swing.JButton jButtonFichaNegra;
    private javax.swing.JButton jButtonJugadorBlanco;
    private javax.swing.JButton jButtonJugadorNegro;
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JButton jCargarPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreBlanco;
    private javax.swing.JLabel jNegrolbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelNombreNegro;
    private javax.swing.JLabel lblJBlanco;
    private javax.swing.JPanel panelJuegoConfig;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
