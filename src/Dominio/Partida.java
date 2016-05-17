package Dominio;

public class Partida {

    //atributos
    private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    private Tablero tablero;
    private int posicionHuecoActual;
    private int cantidadFichas;
    private int deshacerMovPosHueco;
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

    public Partida(int[] configuracion) { // constructor con configuracion 
        Jugador aux = new Jugador();
        Tablero tab = new Tablero(configuracion[0], configuracion[1]);
        Jugador aux2 = new Jugador();
        this.jugadorBlanco = aux;
        this.jugadorNegro = aux2;
        this.posicionHuecoActual = configuracion[1];
        this.cantidadFichas = 0;
        this.tablero = tab;
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
}
