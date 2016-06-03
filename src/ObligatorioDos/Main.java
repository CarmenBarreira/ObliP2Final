package ObligatorioDos;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
import Interfaz.VentanaMenuPrincipal;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

//COLORES DE MENU
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BROWN = "\033[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Sistema miSistema = new Sistema();
        int[] config = new int[2];
        VentanaMenuPrincipal menu = new VentanaMenuPrincipal(miSistema);
        Rectangle rct = menu.getGraphicsConfiguration().getBounds();
        menu.setLocation((rct.width - menu.getWidth()) / 2, (rct.height - menu.getHeight()) / 2);
        menu.setVisible(true);
        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        //atributos
        String tecla;
        int opcion = -1;
        Partida partida = new Partida();

    }



//
//    public static int ingresoDeIntValido(String tipo) {
//        /*Verifica que se haya ingresado un valor válido, 
//        por ejemplo la edad de jugador debe ser mayor a 8 y menor a 100 */
//
//        //Scanner para leer datos ingresados por el usuario
//        Scanner in = new Scanner(System.in);
//        int retorno = 0;
//        boolean correcto = false;
//
//        while (!correcto) {
//            try {
//                retorno = in.nextInt();
//                if (tipo.toUpperCase().equals("edad".toUpperCase())) {//edad
//                    if (retorno < 8 || retorno > 100) {
//                        System.out.println("\n" + ANSI_RED + "La edad ingresada no es válida! "
//                                + "Debe ingresar una edad válida (entero entre 8 y 100)." + ANSI_RESET + "\n");
//                        System.out.println("Ingrese la edad nuevamente: ");
//                    } else {
//                        correcto = true;
//                    }
//                }
//
//            } catch (InputMismatchException e) {
//
//                if (tipo.toUpperCase().equalsIgnoreCase("edad")) {
//                    System.out.println("\n" + ANSI_RED + "La edad ingresada no es válida. "
//                            + "Debe ingresar una edad válida (entero entre 8 y 100)." + ANSI_RESET + "\n");
//                    System.out.println("Ingrese la edad nuevamente: ");
//                }
//                in.next();
//            }
//        }
//
//        return retorno;
//    }
//
//    public static void jugarPartida(Sistema miSistema) {
//        // Este metodo configura la partida por defecto en caso de que no se haya configurado antes.
//        // Y juega el juego
//        Partida p = new Partida(miSistema.getConfPartida());
//        miSistema.setPartidaActual(p);
//        int posHuecoAnt = p.getPosicionHuecoActual();
//        boolean abandono = false;
//        boolean hayGanador = false;
//        int cantFichasTotal;
//        boolean confirmoSalida = false;
//        int posHuecoNuevo;
//        int posJugador1Elegido, posJugador2Elegido; //posiciones de los jugadores en la lista de jugadores
//        Jugador j1, j2;
//
//        cantFichasTotal = (p.getTablero().getTablero().length) * (p.getTablero().getTablero()[0].length) - 4;
//        System.out.println("\n \n");
//        System.out.println(ANSI_BLUE + "*** La partida ha sido creada ***" + ANSI_RESET);
//        System.out.println(ANSI_GREEN + "    " + p.getJugadorBlanco().getAlias()
//                + " juega con fichas color BLANCO." + ANSI_RESET);
//        System.out.println(ANSI_GREEN + "    " + p.getJugadorNegro().getAlias()
//                + " juega con fichas color NEGRO." + ANSI_RESET + "\n \n");
//        System.out.println("El tablero para comenzar a jugar es el siguiente: \n");
//        imprimirTablero(p.getTablero());
//        while (p.getTablero().encontroGanador() == 'E'
//                && cantFichasTotal > 0 && !abandono) {
//            //Mientras No encontro ganador, Hay fichas y no abandono nadie
//            System.out.println("\n\n" + ANSI_GREEN + "<--- Jugar Turno para "
//                    + p.getJugadorBlanco().getAlias()
//                    + " con fichas BLANCAS: (para abandonar la partida debe "
//                    + "ingresar 'X')---> " + ANSI_RESET + "\n");
//            abandono = pedirUbicacionFicha(p, 'B');
//
//            //Paso la partida y el color de ficha
//            cantFichasTotal--;
//            while (abandono == true && !confirmoSalida) {
//                if (seguroAbandonaPartida()) {
//                confirmoSalida = true;
//                 hayGanador = determinarGanador('N', p);
//
//                } // Si Abandono entonces determino ganador a Jugador Negro
//                else {
//                    abandono = pedirUbicacionFicha(p, 'B');
//
//                }
//            }
//
//            if (p.getTablero().encontroGanador() == 'E' && !abandono) {
//                //no gano con el movimiento o salio
//                System.out.println("\n");
//                posHuecoNuevo = obtenerPosHueco(p.getTablero(), 2, posHuecoAnt,
//                        p.getDeshacerMovPosHueco());
//                p.setDeshacerMovPosHueco(posHuecoAnt);
//                posHuecoAnt = posHuecoNuevo;
//                p.getTablero().moverHueco(p.getTablero().setNumeroSubtablero(posHuecoNuevo,
//                        p.getTablero().getOpcionDeTablero()));
//                imprimirTableroHueco(p.getTablero());
//                System.out.println("\n");
//                //imprimirTablero(p.getTablero());
//                if (p.getTablero().encontroGanador() == 'E') {//no hay ganador
//                    //TURNO JUGADOR 2
//                    System.out.println("\n\n" + ANSI_GREEN + "<--- Jugar Turno para "
//                            + p.getJugadorNegro().getAlias()
//                            + " con fichas NEGRAS: (para abandonar la partida "
//                            + "debe ingresar 'X')--->" + ANSI_RESET + "\n");
//
//                    abandono = pedirUbicacionFicha(p, 'N');
//
//                    cantFichasTotal--;
//
//                    while (abandono == true && !confirmoSalida) {
//                        if (seguroAbandonaPartida()) {
//                            confirmoSalida = true;
//                            hayGanador = determinarGanador('B', p);
//
//                        } // Si Abandono entonces determino ganador a Jugador Blanco
//                        else {
//                            abandono = pedirUbicacionFicha(p, 'N');
//
//                        }
//                    }
//                    if (p.getTablero().encontroGanador() == 'E' && !abandono) {// si con el movimiento no hay ganador
//                        //mueve el hueco
//                        posHuecoNuevo = obtenerPosHueco(p.getTablero(), 2, posHuecoAnt, p.getDeshacerMovPosHueco());
//                        p.setDeshacerMovPosHueco(posHuecoAnt);
//                        posHuecoAnt = posHuecoNuevo;
//                        p.getTablero().moverHueco(p.getTablero().setNumeroSubtablero(posHuecoNuevo,
//                                p.getTablero().getOpcionDeTablero()));
//                        System.out.println("\n");
//                        imprimirTablero(p.getTablero());
//                    }
//                }
//            }
//        }
//        determinarGanador(p.getTablero().encontroGanador(), p);
//        if ((cantFichasTotal == 0 && p.getTablero().encontroGanador() == 'E')
//                || (p.getTablero().encontroGanador() == 'A')) {
//            // Empate porque se terminaron las fichas ó encuentra a los 2 jugadores ganadores
//            System.out.println("\n \n" + ANSI_BLUE + " EMPATE!!!" + ANSI_RESET + " \n");
//            p.getJugadorBlanco().setCantidadPartidasEmpatadas(p.getJugadorBlanco().getCantidadPartidasEmpatadas() + 1);
//            p.getJugadorNegro().setCantidadPartidasEmpatadas(p.getJugadorNegro().getCantidadPartidasEmpatadas() + 1);
//        }
//    }
//
//    public static boolean determinarGanador(char jugador, Partida p) {
//        boolean hayGanador = false;
//        if (jugador == 'B') {
//            System.out.println("\n\n" + ANSI_BLUE + " FELICITACIONES "
//                    + p.getJugadorBlanco().getAlias() + " GANASTE! " + ANSI_RESET + "\n\n");
//            p.getJugadorBlanco().setCantidadPartidasGanadas(p.getJugadorBlanco().getCantidadPartidasGanadas() + 1);
//            p.getJugadorNegro().setCantidadPartidasPerdidas(p.getJugadorNegro().getCantidadPartidasPerdidas() + 1);
//            hayGanador = true;
//        }
//        if (jugador == 'N') {
//            System.out.println("\n\n" + ANSI_BLUE + " FELICITACIONES "
//                    + p.getJugadorNegro().getAlias() + " GANASTE! " + ANSI_RESET + "\n\n");
//            p.getJugadorNegro().setCantidadPartidasGanadas(p.getJugadorNegro().getCantidadPartidasGanadas() + 1);
//            p.getJugadorBlanco().setCantidadPartidasPerdidas(p.getJugadorBlanco().getCantidadPartidasPerdidas() + 1);
//            hayGanador = true;
//        }
//        return hayGanador;
//    }
//
//    public static boolean pedirUbicacionFicha(Partida p, char colorJugador) {
//        //Este metodo pide la ubicacion de una ficha y valide el formato 
//
//        //Scanner para leer datos ingresados por el usuario
//        Scanner in = new Scanner(System.in);
//
//        int[] ubicacion = new int[2];
//        String retorno;
//        boolean correcto = false;
//        boolean espaciosVacios;
//        boolean partidaAbandonada = false;
//        System.out.println("\nElija la ubicación donde quiere ubicar su ficha\n");
//        System.out.println("-- El formato de ingreso es por ejemplo : A1 -> Fila A, Columna 1 --");
//
//        while (!correcto && !partidaAbandonada) {
//            try {
//                retorno = in.nextLine();
//                espaciosVacios = retorno.contains(" "); //contiene espacios
//                if (retorno.isEmpty() || espaciosVacios || retorno.length() > 2) {
//                    //el string está vacio o empieza con espacio o tiene más de 2 caracteres
//                    System.out.println("\n" + ANSI_RED + "Debe ingresar una posición correcta! "
//                            + "Vuelva a intentarlo: " + ANSI_RESET + "\n");
//
//                } else if (retorno.charAt(0) == 'x' || retorno.charAt(0) == 'X') {
//                    //abandona partida
//                    partidaAbandonada = true;
//                } else if (p.getTablero().posicionValidaTablero(retorno.charAt(0), retorno.charAt(1),
//                        p.getTablero().getOpcionDeTablero())) {
//                    ubicacion[0] = letraAnum(retorno); // en ubicacion de 0, pongo la fila 
//                    ubicacion[1] = Character.getNumericValue(retorno.charAt(1)) - 1;
//
//                    if (p.getTablero().setFicha(ubicacion, colorJugador)) {
//                        correcto = true;
//                        imprimirTablero(p.getTablero());
//                    } else {
//                        System.out.println(ANSI_RED + "Debe ingresar una posición correcta! "
//                                + "Vuelva a intentarlo: " + ANSI_RESET + "\n");
//                    }
//                } else {
//                    System.out.println(ANSI_RED + "Debe ingresar una posición correcta! "
//                            + "Vuelva a intentarlo: " + ANSI_RESET + "\n");
//                }
//            } catch (Exception e) {
//                System.out.println(ANSI_RED + "Debe ingresar una posición correcta! "
//                        + "Vuelva a intentarlo:" + ANSI_RESET + " \n");
//            }
//        }
//        return partidaAbandonada;
//    }
//
//  

//    public static void imprimirRankingJugadores(Sistema miSistema) {
//        //ordena los jugadores de manera creciente según la cantidad de partidas ganadas
//        ArrayList<Jugador> listaJugadores;
//        listaJugadores = miSistema.ordenarCrecienteJugador();
//        listarJugadores(listaJugadores, "ranking", "puesto");
//    }
//
//    public static boolean seguroAbandonaPartida() {
//        boolean abandona = false;
//        boolean correcto = false;
//        int opcion = 0;
//
//        //Scanner para leer datos ingresados por el usuario
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("\n");
//        System.out.println(ANSI_GREEN + "¿Seguro desea abandonar la partida?" + ANSI_RESET);
//        System.out.println(ANSI_GREEN + "    1 - SI  " + ANSI_RESET);
//        System.out.println(ANSI_GREEN + "    2 - NO  " + ANSI_RESET);
//
//        while (!correcto) {
//            try {
//                opcion = in.nextInt();
//                if (opcion != 1 && opcion != 2) {
//                    System.out.println("");
//                    System.out.println(ANSI_RED + "La opción ingresada no es válida!"
//                            + " Ingrese opción valida (entero 1 o 2):" + ANSI_RESET);
//                } else {
//                    correcto = true;
//                }
//
//            } catch (Exception e) {
//                System.out.println("");
//                System.out.println(ANSI_RED + "La opción ingresada no es válida!"
//                        + " Ingrese opción valida (entero 1 o 2):" + ANSI_RESET);
//                in.next();
//            }
//        }
//        switch (opcion) {
//            case 1:
//                abandona = true;
//                break;
//            case 2:
//                abandona = false;
//                break;
//        }
//
//        return abandona;
//    }
}
