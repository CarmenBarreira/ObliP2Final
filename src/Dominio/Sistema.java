package Dominio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Sistema extends Observable implements Serializable{

    //atributos
    private ArrayList<Jugador> listaJugadores;
    private Partida partidaActual;
    private int[] confPartida = {1, 5}; 
    // CONFIGURACION POR DEFECTO, PRIMER NUMERO ES OPCION DE TABLERO, SEGUNDO ES OPCION DE HUECO
    private transient boolean partidaCargadaArchivo;
    
    //Constructor
    public Sistema() {
        listaJugadores = new ArrayList<Jugador>();
        partidaActual = new Partida();
        partidaCargadaArchivo= false;
    }

    //get's y set's
    public ArrayList<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> laListaJugadores) {
        this.listaJugadores = laListaJugadores;
        updateObserver();
    }

    public Partida getPartidaActual() {
        return this.partidaActual;
    }

    public void setPartidaActual(Partida laPartidaActual) {
        this.partidaActual = laPartidaActual;
    }

    public int[] getConfPartida() {
        return this.confPartida;
    }

    public void setConfPartida(int[] miConfPartida) {
        this.confPartida = miConfPartida;
    }

    public void agregarJugador(Jugador miJugador) {
        /*agrega el jugador en la lista de jugadores */
        listaJugadores.add(miJugador);
        updateObserver();
    }

    public void eliminarJugador(Jugador j) {
        /*Elimina de la lista de jugadores, el jugador*/

        listaJugadores.remove(j);
        updateObserver();
    }

    public void modificaJugador(int posicion, String alias,
            String nombre, int edad) {
        /*Modifica de la lista de jugadores, el jugador cuya posición en la lista 
        se pasa por parámetros */

        Jugador miJugador = getListaJugadores().get(posicion);
        if (!(alias.equalsIgnoreCase(""))) {
            miJugador.setAlias(alias);
        }
        if (!(nombre.equalsIgnoreCase(""))) {
            miJugador.setNombre(nombre);
        }
        if (edad != 0) {
            miJugador.setEdad(edad);
        }
        updateObserver();
    }

    public ArrayList<Jugador> ordenarCrecienteJugador() {
        /*Para el Ranking, ordena los jugadores de manera creciente según 
        la cantidad de partidas de ganadas*/
        Collections.sort(this.getListaJugadores());
        return this.getListaJugadores();
    }

    public void updateObserver() {
        setChanged();
        notifyObservers();
    }

    public void persistirGuardar(Sistema sis) throws IOException {
         
        FileOutputStream f = new FileOutputStream("archivo");
        BufferedOutputStream b = new BufferedOutputStream(f);
        ObjectOutputStream s = new ObjectOutputStream(b);
        try {
            s.writeObject(sis);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("1G-" + e.getMessage());
        } catch (IOException e) {
            System.out.println("2G-"
                    + "-" + e.getMessage());
        }
        
    }
    
    public Sistema persistirLeer() throws IOException, ClassNotFoundException {
        FileInputStream ff = new FileInputStream ("archivo");
        BufferedInputStream bb = new BufferedInputStream(ff);
        ObjectInputStream ss = new ObjectInputStream(bb);
        Sistema sisRetorno = new Sistema();
        try {
            sisRetorno= (Sistema)ss.readObject();
            ss.close();
        } catch (FileNotFoundException e) {
            System.out.println("1L-" + e.getMessage());
        } catch (IOException e) {
            System.out.println("2L-"
                    + "-" + e.getMessage());
        }
        
        return sisRetorno;
    }
    
    public void leerTXT (File nombreArchivo) throws IOException{
        String aliasJB, aliasJN, configTablero;
        archivo.ArchivoLectura.leerArchivo(nombreArchivo);
        archivo.ArchivoLectura.cerrar();
    }

    public boolean isPartidaCargadaArchivo() {
        return this.partidaCargadaArchivo;
    }

    public void setPartidaCargadaArchivo(boolean partidaCargadaArchivo) {
        this.partidaCargadaArchivo = partidaCargadaArchivo;
    }
    
    
}
