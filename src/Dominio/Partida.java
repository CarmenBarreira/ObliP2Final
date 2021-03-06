package Dominio;

import java.awt.Image;
import java.io.Serializable;
import java.util.Observable;

public class Partida extends Observable implements Serializable {

    //atributos
    private transient Jugador jugadorBlanco;
    private transient Jugador jugadorNegro;
    private transient Tablero tablero;
    private int posicionHuecoActual;
    private transient int cantidadFichas;
    private transient int deshacerMovPosHueco;
    private transient Image fichaJBlanco;
    private transient Image fichaJNegro;
    private transient Image fichaHueco;

    //Variable que guarda el anterior movimiento para no deshacer movimientos
    //constructor
    public Partida() { // constructor vacio
        Jugador aux = new Jugador();
        Jugador aux2 = new Jugador();
        this.jugadorBlanco = aux;
        this.jugadorNegro = aux2;
        this.posicionHuecoActual = -1;
        this.cantidadFichas = 0;

    }

    public Partida(int[] configuracion, Jugador jBlanco, Jugador jNegro, 
            Image jBlancoImg, Image jNegroImg, Image huecoImg) { // constructor con configuracion 
        Tablero tab = new Tablero(configuracion[0], configuracion[1]);
        this.jugadorBlanco = jBlanco;
        this.jugadorNegro = jNegro;
        this.posicionHuecoActual = configuracion[1];
        this.tablero = tab;
        this.deshacerMovPosHueco = -1;
        this.fichaJBlanco = jBlancoImg;
        this.fichaHueco = huecoImg;
        this.fichaJNegro = jNegroImg;
    }

    public Partida(int posHueco, Tablero tab, Jugador jBlanco, Jugador jNegro,
            Image jBlancoImg, Image jNegroImg, Image huecoImg) { // constructor con configuracion 
        this.jugadorBlanco = jBlanco;
        this.jugadorNegro = jNegro;
        this.posicionHuecoActual = posHueco;
        this.tablero = tab;
        this.deshacerMovPosHueco = -1;
        this.fichaJBlanco = jBlancoImg;
        this.fichaHueco = huecoImg;
        this.fichaJNegro = jNegroImg;
    }

    //get's y set's 
    public void setJugadorBlanco(Jugador elJugadorBlanco) {
        this.jugadorBlanco = elJugadorBlanco;
    }

    public void setJugadorNegro(Jugador elJugadorNegro) {
        this.jugadorNegro = elJugadorNegro;
    }

    public void setCantidadFichas(int laCantidadFichas) {
        this.cantidadFichas = laCantidadFichas;
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void setTablero(Tablero miTablero) {
        this.tablero = miTablero;
    }

    public int getPosicionHuecoActual() {
        return this.posicionHuecoActual;
    }

    public void setPosicionHuecoActual(int laPosicionHuecoActual) {
        this.posicionHuecoActual = laPosicionHuecoActual;
    }

    public Jugador getJugadorBlanco() {
        return this.jugadorBlanco;
    }

    public Jugador getJugadorNegro() {
        return this.jugadorNegro;
    }

    public int getCantidadFichas() {
        return this.cantidadFichas;
    }

    public int getDeshacerMovPosHueco() {
        return this.deshacerMovPosHueco;
    }

    public void setDeshacerMovPosHueco(int miDeshacerMovPosHueco) {
        this.deshacerMovPosHueco = miDeshacerMovPosHueco;
    }

    public boolean isEmpty() {
        return this.getPosicionHuecoActual() == -1;
    }

    public Image getFichaJBlanco() {
        return fichaJBlanco;
    }

    public void setFichaJBlanco(Image laFichaJBlanco) {
        this.fichaJBlanco = laFichaJBlanco;
        updateObserver();
    }

    public Image getFichaJNegro() {
        return this.fichaJNegro;
    }

    public void setFichaJNegro(Image laFichaJNegro) {
        this.fichaJNegro = laFichaJNegro;
        updateObserver();
    }

    public Image getFichaHueco() {
        return this.fichaHueco;
    }

    public void setFichaHueco(Image laFichaHueco) {
        this.fichaHueco = laFichaHueco;
    }

    public void updateObserver() {
        setChanged();
        notifyObservers();
    }
}
