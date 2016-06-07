package Dominio;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable{

    //atributos
    private String alias;
    private String nombre;
    private int edad;
    private int cantidadPartidasGanadas;
    private int cantidadPartidasPerdidas;
    private int cantidadPartidasEmpatadas;

    //Constructores
    public Jugador() {
        this.alias = " ";
        this.nombre = " ";
        this.edad = -1;
        this.cantidadPartidasGanadas = 0;
        this.cantidadPartidasEmpatadas = 0;
        this.cantidadPartidasPerdidas = 0;
    }

    public Jugador(String alias) {
        this.alias = alias;
        this.nombre = "Sin nombre ";
        this.edad = -1;
        this.cantidadPartidasGanadas = 0;
        this.cantidadPartidasEmpatadas = 0;
        this.cantidadPartidasPerdidas = 0;
    }
    
    public Jugador(String elAlias, String elNombre, int laEdad) {
        this.alias = elAlias;
        this.nombre = elNombre;
        this.edad = laEdad;
        this.cantidadPartidasGanadas = 0;
        this.cantidadPartidasEmpatadas = 0;
        this.cantidadPartidasPerdidas = 0;
    }

    public Jugador(String elAlias, String elNombre, int laEdad, int pPer, int pGan, int pEmpa) {
        this.alias = elAlias;
        this.nombre = elNombre;
        this.edad = laEdad;
        this.cantidadPartidasGanadas = pGan;
        this.cantidadPartidasEmpatadas = pEmpa;
        this.cantidadPartidasPerdidas = pPer;
    }

    // get's y set's    
    public String getAlias() {
        return this.alias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getCantidadPartidasGanadas() {
        return this.cantidadPartidasGanadas;
    }

    public int getCantidadPartidasEmpatadas() {
        return cantidadPartidasEmpatadas;
    }

    public void setAlias(String elAlias) {
        this.alias = elAlias;
    }

    public void setNombre(String elNombre) {
        this.nombre = elNombre;
    }

    public void setEdad(int laEdad) {
        this.edad = laEdad;
    }

    public int getCantidadPartidasPerdidas() {
        return this.cantidadPartidasPerdidas;
    }

    public void setCantidadPartidasGanadas(int laCantidadPartidasGanadas) {
        this.cantidadPartidasGanadas = laCantidadPartidasGanadas;
    }

    public void setCantidadPartidasPerdidas(int laCantidadPartidasPerdidas) {
        this.cantidadPartidasPerdidas = laCantidadPartidasPerdidas;
    }

    public void setCantidadPartidasEmpatadas(int laCantidadPartidasEmpatadas) {
        this.cantidadPartidasEmpatadas = laCantidadPartidasEmpatadas;
    }

    //toString
    @Override
    public String toString() {
        return "ALIAS: " + this.getAlias() + "\n      Nombre=" + this.getNombre()
                + "\n      Edad=" + this.getEdad() + "\n"
                + "      Cantidad partidas ganadas: " + this.getCantidadPartidasGanadas()
                + "\n      Cantidad partidas perdidas: " + this.getCantidadPartidasPerdidas()
                + "\n      Cantidad partidas empatadas: " + this.getCantidadPartidasEmpatadas();
    }

    @Override
    public boolean equals(Object o) {
        return (this.getAlias().equalsIgnoreCase(((Jugador) o).getAlias()));
    }

    @Override
    public int compareTo(Jugador o) {
        int retorno = 0;
        retorno = (int) (o.getCantidadPartidasGanadas() - this.getCantidadPartidasGanadas());
        return retorno;
    }

}
