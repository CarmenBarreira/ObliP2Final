
package Dominio;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
    //atributos
    private ArrayList<Jugador> listaJugadores;
    private Partida partidaActual;
    private int[] confPartida = {1,5};

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
    
    public void agregarJugador(Jugador miJugador){
        /*agrega el jugador en la lista de jugadores */
        listaJugadores.add(miJugador);     
    }
    
    public ArrayList<Jugador> ordenarCrecienteJugador(){  
        /*Para el Ranking, ordena los jugadores de manera creciente según 
        la cantidad de partidas de ganadas*/
         Collections.sort(this.getListaJugadores());
         return this.getListaJugadores();
    }    

}