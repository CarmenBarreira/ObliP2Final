package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Sistema extends Observable {

    //atributos
    private ArrayList<Jugador> listaJugadores;
    private Partida partidaActual;
    private int[] confPartida = {1, 5}; // CONFIGURACION POR DEFECTO, PRIMER NUMERO ES OPCIOND E TABLERO, SEGUNDO ES OPCION DE HUECO

    //Constructor
    public Sistema() {
        listaJugadores = new ArrayList<Jugador>();
        partidaActual = new Partida();
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

}
