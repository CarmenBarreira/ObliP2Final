package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
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
        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        //atributos
        String tecla;
        int opcion = -1;
        Partida partida = new Partida();

        System.out.println("");
        System.out.println(ANSI_CYAN + "***   ***   ***   ***   ***   ***   ***" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "***************************************" + ANSI_RESET);
        System.out.println(ANSI_RED + "****** BIENVENID@ A 4enCuadrado *******" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "***************************************" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "***   ***   ***   ***   ***   ***   ***" + ANSI_RESET);
        System.out.println(ANSI_BLACK + "* Presione una tecla para continuar...*" + ANSI_RESET);

        tecla = in.nextLine();

        //para "limpiar" la pantalla 
        System.out.println("\n \n");
        System.out.println(ANSI_BLUE + "*** *** *** *** 4 en CUADRADO *** *** *** ***" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "---------------------------------------------" + ANSI_RESET);

        while (opcion != 0) {
            System.out.println("\n");
            System.out.println(ANSI_BLUE + "*** ***   Seleccione lo que desea hacer :   **  ***" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "*** *** 1 - Registrar jugador               **  ***" + ANSI_RESET);
            System.out.println(ANSI_BROWN + "*** *** 2 - Configurar Partida              **  ***" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "*** *** 3 - Jugar con última configuración  **  ***" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "*** *** 4 - Ranking                         **  ***" + ANSI_RESET);
            System.out.println(ANSI_BLACK + "*** *** 0 - Salir del Sistema               **  ***\n" + ANSI_RESET);

            try {
                opcion = in.nextInt();
            } catch (InputMismatchException e) {
                in.next();
                opcion = -1;
            }

            switch (opcion) {
                case 1: //altajugador 
                    altaJugador(miSistema);
                    break;
                case 2: //Configurar partida
                    miSistema.setConfPartida(configurarPartida());
                    break;
                case 3:  //jugar con ultima configuración guardada
                    if (miSistema.getListaJugadores().size() >= 2) {

                        jugarPartida(miSistema);
                    } else {
                        System.out.println("\n " + ANSI_RED + "Debe ingresar al menos 2 jugadores previamente (opción 1 del menú)" + ANSI_RESET);
                    }
                    break;
                case 4:  //Ranking
                    if (!miSistema.getListaJugadores().isEmpty()) {
                        imprimirRankingJugadores(miSistema);
                    } else {
                        System.out.println("\n " + ANSI_RED + "No hay jugadores ingresados en el sistema." + "(para ingresarlos -> Opción 1 del menú)" + ANSI_RESET);
                    }
                    break;
                case 0:
                    System.out.println(ANSI_GREEN + "Gracias por utilizar 4enCuadrado!" + ANSI_RESET);
                    break;
                default:
                    System.out.println("\n" + ANSI_RED + "El valor ingresado no es correcto. "
                            + "Debe ingresar una opción válida (entero de 0 a 4) :" + ANSI_RESET + "\n \n");
                    break;
            }
        }

    }

    public static String ingresoString(String tipo) {
        /*Este método tomará el ingreso de un String, y validará no sea vacío. 
        Ejemplos de su uso: Nombre, alias, etc  */

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        //atributos
        String retorno = "";
        boolean correcto = false;
        boolean espaciosVacios;

        while (!correcto) {
            try {
                retorno = in.nextLine();
                espaciosVacios = retorno.charAt(0) == ' '; //empieza con espacio
                if (retorno.isEmpty() || espaciosVacios) {
                    //el string esta vacio o empieza con espacio
                    if (tipo.toUpperCase().equals("nombre".toUpperCase())) {
                        System.out.println(ANSI_RED + "Debe ingresar un nombre correctamente."
                                + "Vuelva a intentarlo." + ANSI_RESET + "\n");
                    } else { // es alias
                        System.out.println(ANSI_RED + "Debe ingresar un alias correctamente."
                                + "Vuelva a intentarlo: " + ANSI_RESET + "\n");
                    }
                } else {
                    correcto = true;
                }

            } catch (Exception e) {
                if (tipo.toUpperCase().equals("nombre".toUpperCase())) {
                    System.out.println(ANSI_RED + "Debe ingresar un nombre correctamente (No puede ser vacio ni contener espacios)."
                            + "Vuelva a intentarlo:" + ANSI_RESET + "\n");
                } else { // es alias
                    System.out.println(ANSI_RED + "Debe ingresar un alias correctamente (No puede ser vacio ni contener espacios)."
                            + "Vuelva a intentarlo:" + ANSI_RESET + "\n");
                }
            }
        }

        return retorno;
    }

    public static void imprimirTablero(Tablero tab) {
        System.out.print("   ");
        boolean stop = false;
        //IMPRIMO LOS NUMEROS DE LAS CELDAS, CADA DOS LUGARES, K y K+1
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print(" " + k + "   " + (k + 1) + "  ");
        }
        System.out.println(""); //ESPACIO
        //EMPIEZO A RECORRER LA MATRIZ PRINCIPAL
        for (int i = 0; i <= tab.getTablero().length; i++) {
            //SI ES DIVISOR DE 2 PONGO ASTERISCOS YA QUE SOLO PASA CUANDO HAY UN SUBTABLERO
            if (i % 2 == 0) {
                //SI ES EL PRIMER LUGAR DEJO UN ESPACIO (PARA QUE QUEDE EN LUGAR CON LAS LETRAS DE ABAJO) Y PONGO ASTERISCOS
                System.out.print("  ********");

                //EN OTRO CASO IMPRIMO TODO SEGUIDO (SINO QUEDARIA UN ESPACIO EN CADA SEPARACION DE SUBTABLERO)
                for (int k = 4; k <= tab.getTablero()[0].length; k = k + 2) {
                    System.out.print("********");
                }
                //EN EL FINAL PONGO UN ASTERISCO YA QUE SINO SE PASABA SI LO PONIA EN EL ANTERIOR FOR
                System.out.println("*");
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(((char) ('A' + (i))) + " ");
            }
            //SEPARACION ENTRE LOS NUMEROS ES CON |, VALIDO QUE SI NO ES DIVISIBLE ENTRE 2 LA POSICION PONGA ASTERISCO
            for (int j = 0; j < tab.getTablero()[0].length && i < tab.getTablero().length; j++) {
                if (j % 2 == 0) {
                    //MANEJO CON CUIDADO LOS ESPACIOS
                    if (j != 0) {
                        System.out.print(" " + tab.getTablero()[i][j] + " | ");
                    }
                    if (j == 0) {
                        System.out.print("* " + tab.getTablero()[i][j] + " | ");
                    }
                } else {
                    System.out.print(tab.getTablero()[i][j] + " *");
                }
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(" " + ((char) ('A' + (i))));
            }
            //INDENTADOR DE LINEAS (Este ln)
            if (i + 1 <= tab.getTablero().length) {
                System.out.println("");
            }

            //SEPARADOR DE LAS FICHAS DENTRO DE LOS SUBCONJUNTOS
            if (i % 2 == 0 && i < tab.getTablero().length) {
                System.out.print("  ");
                for (int k = 2; k <= tab.getTablero()[0].length; k = k + 2) {
                    if (k == tab.getTablero()[0].length) {
                        System.out.print("*---+---*");
                    } else {
                        System.out.print("*---+---");
                    }
                }
                System.out.println("");
            }
        }
        System.out.print("  ");
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print("  " + k + "   " + (k + 1) + " ");
        }
    }

    public static void imprimirTableroHueco(Tablero tab) {
        System.out.print("   ");
        boolean stop = false;
        int contadorSubtablero = 1;
        //IMPRIMO LOS NUMEROS DE LAS CELDAS, CADA DOS LUGARES, K y K+1
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print(" " + k + "   " + (k + 1) + "  ");
        }
        System.out.println(""); //ESPACIO
        //EMPIEZO A RECORRER LA MATRIZ PRINCIPAL
        for (int i = 0; i <= tab.getTablero().length; i++) {
            //SI ES DIVISOR DE 2 PONGO ASTERISCOS YA QUE SOLO PASA CUANDO HAY UN SUBTABLERO
            if (i % 2 == 0) {
                //SI ES EL PRIMER LUGAR DEJO UN ESPACIO (PARA QUE QUEDE EN LUGAR CON LAS LETRAS DE ABAJO) Y PONGO ASTERISCOS
                System.out.print("  ********");

                //EN OTRO CASO IMPRIMO TODO SEGUIDO (SINO QUEDARIA UN ESPACIO EN CADA SEPARACION DE SUBTABLERO)
                for (int k = 4; k <= tab.getTablero()[0].length; k = k + 2) {
                    System.out.print("********");
                }
                //EN EL FINAL PONGO UN ASTERISCO YA QUE SINO SE PASABA SI LO PONIA EN EL ANTERIOR FOR
                System.out.println("*");
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(((char) ('A' + (i))) + " ");
            }
            //SEPARACION ENTRE LOS NUMEROS ES CON |, VALIDO QUE SI NO ES DIVISIBLE ENTRE 2 LA POSICION PONGA ASTERISCO
            for (int j = 0; j < tab.getTablero()[0].length && i < tab.getTablero().length; j++) {
                if (j % 2 == 0) {
                    //MANEJO CON CUIDADO LOS ESPACIOS
                    if (j != 0) {
                        System.out.print(" " + tab.getTablero()[i][j] + " | ");
                    }
                    if (j == 0) {
                        System.out.print("* " + tab.getTablero()[i][j] + " | ");
                    }
                } else {
                    System.out.print(tab.getTablero()[i][j] + " *");
                }
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(" " + ((char) ('A' + (i))));
            }
            //INDENTADOR DE LINEAS (Este ln)
            if (i + 1 <= tab.getTablero().length) {
                System.out.println("");
            }

            //SEPARADOR DE LAS FICHAS DENTRO DE LOS SUBCONJUNTOS
            if (i % 2 == 0 && i < tab.getTablero().length) {
                System.out.print("  ");

                for (int k = 2; k <= tab.getTablero()[0].length; k = k + 2) {
                    if (k == tab.getTablero()[0].length) {
                        if (contadorSubtablero < 10) {
                            System.out.print("*---" + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "---*");
                        } else {
                            System.out.print("*--" + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "---*");
                        }
                    } else if (contadorSubtablero < 10) {
                        System.out.print("*---" + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "---");
                    } else {
                        System.out.print("*--" + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "---");
                    }
                    contadorSubtablero++;
                }
                System.out.println("");
            }
        }
        System.out.print("  ");
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print("  " + k + "   " + (k + 1) + " ");
        }
    }

    public static void imprimirTableroDeSubtableros(Tablero tab) {
        System.out.print("   ");
        boolean stop = false;
        int contadorSubtablero = 1;
        //IMPRIMO LOS NUMEROS DE LAS CELDAS, CADA DOS LUGARES, K y K+1
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print(" " + k + "   " + (k + 1) + "  ");
        }
        System.out.println(""); //ESPACIO
        //EMPIEZO A RECORRER LA MATRIZ PRINCIPAL
        for (int i = 0; i <= tab.getTablero().length; i++) {
            //SI ES DIVISOR DE 2 PONGO ASTERISCOS YA QUE SOLO PASA CUANDO HAY UN SUBTABLERO
            if (i % 2 == 0) {
                //SI ES EL PRIMER LUGAR DEJO UN ESPACIO (PARA QUE QUEDE EN LUGAR CON LAS LETRAS DE ABAJO) Y PONGO ASTERISCOS
                System.out.print("  ********");

                //EN OTRO CASO IMPRIMO TODO SEGUIDO (SINO QUEDARIA UN ESPACIO EN CADA SEPARACION DE SUBTABLERO)
                for (int k = 4; k <= tab.getTablero()[0].length; k = k + 2) {
                    System.out.print("********");
                }
                //EN EL FINAL PONGO UN ASTERISCO YA QUE SINO SE PASABA SI LO PONIA EN EL ANTERIOR FOR
                System.out.println("*");
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(((char) ('A' + (i))) + " ");
            }
            //SEPARACION ENTRE LOS NUMEROS ES CON |, VALIDO QUE SI NO ES DIVISIBLE ENTRE 2 LA POSICION PONGA ASTERISCO

            for (int j = 0; j < tab.getTablero()[0].length && i < tab.getTablero().length; j++) {
                if (j % 2 == 0) {
                    //MANEJO CON CUIDADO LOS ESPACIOS
                    if (j != 0) {
                        System.out.print("  " + "   ");
                    }
                    if (j == 0) {
                        System.out.print("*     ");
                    }
                } else {
                    System.out.print("  *");
                }
            }
            //IMPRIMO LAS LETRAS
            if (i + 1 <= tab.getTablero().length) {
                System.out.print(" " + ((char) ('A' + (i))));
            }
            //INDENTADOR DE LINEAS (Este ln)
            if (i + 1 <= tab.getTablero().length) {
                System.out.println("");
            }

            //SEPARADOR DE LAS FICHAS DENTRO DE LOS SUBCONJUNTOS
            if (i % 2 == 0 && i < tab.getTablero().length) {
                System.out.print("  ");

                for (int k = 2; k <= tab.getTablero()[0].length; k = k + 2) {
                    if (k == tab.getTablero()[0].length) {
                        if (contadorSubtablero < 10) {
                            System.out.print("*   " + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "   *");
                        } else {
                            System.out.print("*  " + ANSI_PURPLE + contadorSubtablero + ANSI_RESET + "   *");
                        }
                    } else if (contadorSubtablero < 10) {
                        System.out.print("*   " + ANSI_PURPLE + contadorSubtablero + "   " + ANSI_RESET);
                    } else {
                        System.out.print("*  " + ANSI_PURPLE + contadorSubtablero + "   " + ANSI_RESET);
                    }
                    contadorSubtablero++;
                }
                System.out.println("");
            }
        }
        System.out.print("  ");
        for (int k = 1; k <= tab.getTablero()[0].length; k = k + 2) {
            System.out.print("  " + k + "   " + (k + 1) + " ");
        }
    }

    public static void altaJugador(Sistema miSistema) {
        /*Pide los datos del Jugador, los valida, y llama agregarJugador para dar
        el alta del mismo, y agregarlo en la lista de Jugadores*/

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        //atributos
        String alias;
        String nombre;
        int edad;
        boolean edadOk = false;

        System.out.println("\n \n \n"); //limpiar pantalla
        System.out.println(ANSI_CYAN + "*** ************ ***" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "*** ALTA JUGADOR ***" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "*** ************ ***" + ANSI_RESET);

        System.out.println("Ingrese el alias del Jugador/a:");
        alias = ingresoString("alias");
        System.out.println("Ingrese la nombre del Jugador/a:");
        nombre = ingresoString("alias");
        System.out.println("Ingrese la edad del Jugador/a:");
        edad = ingresoDeIntValido("edad");

        Jugador aux = new Jugador(alias, nombre, edad);

        while (miSistema.getListaJugadores().indexOf(aux) != -1) {
            System.out.println("\n" + ANSI_RED + "Ya existe un jugador/a con el mismo alias!" + ANSI_RESET + "\n \n");
            System.out.println("Ingrese el alias del Jugador/a:");
            alias = ingresoString("alias");
            aux.setAlias(alias);
        }

        if (miSistema.getListaJugadores().indexOf(aux) == -1) {//ingreso un alias correcto
            miSistema.agregarJugador(aux);
            System.out.println("\n" + ANSI_BLUE + "Se dió de alta el/la Jugador/a: " + aux.getAlias() + " correctamente! \n" + ANSI_RESET);
        }

    }

    public static void listarJugadores(ArrayList<Jugador> listaJugadores) {
        /*Lista todos los Jugadores que hayan hasta ahora en el Sistema*/

        int contador = 0;
        if (listaJugadores.isEmpty()) {
            System.out.println(ANSI_RED + "No existen jugadores ingresados!\n n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "*** LISTA DE JUGADORES ***" + ANSI_RESET);
            Iterator<Jugador> it = listaJugadores.iterator();

            while (it.hasNext()) {
                Jugador aux = it.next();
                System.out.println(ANSI_GREEN + (contador + 1) + " - " + ANSI_RESET + aux.toString());
                contador++;
            }
        }
        System.out.println("\n");
    }

    public static int ingresoDeIntValido(String tipo) {
        /*Verifica que se haya ingresado un valor valido, 
        por ejemplo la edad de jugador debe ser mayor a 8 y menor a 100 */

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);
        int retorno = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                retorno = in.nextInt();
                if (tipo.toUpperCase().equals("edad".toUpperCase())) {//edad
                    if (retorno < 8 || retorno > 100) {
                        System.out.println("\n" + ANSI_RED + "La edad ingresada no es válida! "
                                + "Debe ingresar una edad válida (entero entre 8 y 100)." + ANSI_RESET + "\n");
                        System.out.println("Ingrese la edad nuevamente: ");
                    } else {
                        correcto = true;
                    }
                }

            } catch (InputMismatchException e) {

                if (tipo.toUpperCase().equalsIgnoreCase("edad")) {
                    System.out.println("\n" + ANSI_RED + "La edad ingresada no es válida. "
                            + "Debe ingresar una edad válida (entero entre 8 y 100)." + ANSI_RESET + "\n");
                    System.out.println("Ingrese la edad nuevamente: ");
                }
                in.next();
            }
        }

        return retorno;
    }

    public static int obtenerJugadorElegidoDeLista(Sistema miSistema) {
        //retorna la posicion del Jugador elegido de la lista

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        //atributos
        int retorno = 0;
        int cantJugadores;
        boolean ingresoOK = false;

        cantJugadores = miSistema.getListaJugadores().size();

        while (!ingresoOK) {
            listarJugadores(miSistema.getListaJugadores());

            try {
                retorno = in.nextInt();
            } catch (InputMismatchException e) {
                in.next();
                retorno = -1;
            }

            if (retorno <= 0 || retorno > cantJugadores) {
                System.out.println(ANSI_RED + "El jugador ingresado no es correcto! Debe ingresar un valor válido (entre : 1 y "
                        + (cantJugadores) + " )." + ANSI_RESET + "\n");
            } else { // el jugador esta en posicion = opcion
                ingresoOK = true;

            }
        }
        return retorno;
    }

    public static int obtenerTamanoTablero() {
        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        int retorno = -1;
        boolean opcionValida = false;

        System.out.println("\nSeleccione el tamaño del tablero: ");
        System.out.println("1 -> 6*6");
        System.out.println("2 -> 4*6");
        System.out.println("3 -> 6*4");
        System.out.println("4 -> 8*8");

        while (!opcionValida) {
            try {
                retorno = in.nextInt();
            } catch (InputMismatchException e) {
                in.next();
                retorno = -1;
            }
            if (retorno < 1 || retorno > 4) {
                System.out.println(ANSI_RED + "La opción ingresada no es válida. Debe ingresar entero positivo entre 1 y 4."
                        + ANSI_RESET + "\n" + ANSI_RED + "Vuelva a ingresar: " + ANSI_RESET);
            } else {
                opcionValida = true;
            }
        }
        return retorno;
    }

    public static int obtenerPosHueco(Tablero tab, int opcion, int posHuecoAnt, int posDeshacerMov) {
        //obtiene posicion hueco, la valida y la retorna 

        int numeroDeSub;  //cantidad de subtableros
        int posHuecoIngresada = -1;
        boolean opcionValida = false;

        int[] dimensionSubtableroElegido = tab.setTamanioTablero(tab.getOpcionDeTablero());
        numeroDeSub = (dimensionSubtableroElegido[0] / 2) * (dimensionSubtableroElegido[1] / 2);

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        if (opcion == 1) { //FUNCION PARA PONER EL HUECO EN ALGUN LADO
            System.out.println("Seleccione el lugar donde estará el hueco: ");
            imprimirTableroDeSubtableros(tab);

            System.out.println("");
            while (!opcionValida) {
                try {
                    posHuecoIngresada = in.nextInt();
                    if ((posHuecoIngresada <= numeroDeSub && posHuecoIngresada > 0)) {
                        opcionValida = true;

                    } else {
                        System.out.println(ANSI_RED + "Opción de subtablero incorrecta. Ingrese número válido (entero entre 1 y " + numeroDeSub + "):" + ANSI_RESET);
                    }
                } catch (InputMismatchException e) {
                    in.next();
                    System.out.println(ANSI_RED + "Opción de subtablero incorrecta. Ingrese número válido (entero entre 1 y " + numeroDeSub + "):" + ANSI_RESET);
                }

            }
        }
        if (opcion == 2) {//FUNCION PARA MOVER EL HUECO 
            System.out.println("Seleccione el lugar a donde quiere mover el hueco: ");
            imprimirTableroHueco(tab);

            System.out.println("");
            while (!opcionValida) {
                try {
                    posHuecoIngresada = in.nextInt();
                    if ((posHuecoIngresada <= numeroDeSub && posHuecoIngresada > 0) && (validarPosicionHueco(posHuecoAnt, posHuecoIngresada, tab.getOpcionDeTablero(), posDeshacerMov))) {
                        opcionValida = true;

                    } else {
                        System.out.println(ANSI_RED + "Opción de subtablero incorrecta. Ingrese número válido (entero entre 1 y " + numeroDeSub + "):" + ANSI_RESET);
                    }
                } catch (InputMismatchException e) {
                    in.next();
                    System.out.println(ANSI_RED + "Opción de subtablero incorrecta. Ingrese número válido (entero entre 1 y " + numeroDeSub + "):" + ANSI_RESET);
                }

            }
        }

        return posHuecoIngresada;
    }

    public static int[] configurarPartida() {
        //configura la partida, es decir, el tablero y la posición del hueco.
        //Y agrega la misma a Sistema
        int tamanioTablero;
        int posHueco;
        int[] config = new int[2]; // Posicion 0 es POS de HUECO, pos 1 es TAMANO TABLERO  
        tamanioTablero = obtenerTamanoTablero();
        Tablero tabTemporal = new Tablero(tamanioTablero, 5);
        System.out.println("\n \n ");
        posHueco = obtenerPosHueco(tabTemporal, 1, 0, -1);
        System.out.println("");
        Tablero tab = new Tablero(tamanioTablero, posHueco);
        imprimirTablero(tab);
        config[0] = tamanioTablero;
        config[1] = posHueco;

        return config;

    }

    public static void jugarPartida(Sistema miSistema) {
        // Este metodo comienza el juego 
        Partida p = new Partida(miSistema.getConfPartida());
        miSistema.setPartidaActual(p);
        int posHuecoAnt = miSistema.getPartidaActual().getPosicionHuecoActual();
        boolean abandono = false;
        boolean hayGanador = false;
        int cantFichasTotal;
        int posHuecoNuevo;
        int posJugador1Elegido, posJugador2Elegido; //posiciones de los jugadores en la lista de jugadores
        Jugador j1, j2;


        System.out.println("\n" + "Seleccione el primer jugador para comenzar a jugar: ");
        posJugador1Elegido = obtenerJugadorElegidoDeLista(miSistema);
        j1 = miSistema.getListaJugadores().get(posJugador1Elegido - 1);
        p.setJugadorBlanco(j1);
        System.out.println("\nSeleccione el segundo jugador para comenzar a jugar: ");
        posJugador2Elegido = obtenerJugadorElegidoDeLista(miSistema);
        while (posJugador1Elegido == posJugador2Elegido) { // para que no se elija el mismo jugador 2 veces
            System.out.println("\n\n" + ANSI_RED + "El segundo jugador debe ser diferente al primero. Por favor, seleccione otro: " + ANSI_RESET + "\n");
            posJugador2Elegido = obtenerJugadorElegidoDeLista(miSistema);
        }
        j2 = miSistema.getListaJugadores().get(posJugador2Elegido - 1);
        p.setJugadorNegro(j2);

        cantFichasTotal = (p.getTablero().getTablero().length) * (p.getTablero().getTablero()[0].length) - 4;
        System.out.println("\n \n");
        System.out.println(ANSI_BLUE + "*** La partida ha sido creada ***" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "    " + p.getJugadorBlanco().getAlias() + " juega con fichas color BLANCO." + ANSI_RESET);
        System.out.println(ANSI_GREEN + "    " + p.getJugadorNegro().getAlias() + " juega con fichas color NEGRO." + ANSI_RESET + "\n \n");
        System.out.println("El tablero para comenzar a jugar es el siguiente: \n");
        imprimirTablero(p.getTablero());
        p.getJugadorBlanco().setCantidadPartidasJugadas(p.getJugadorBlanco().getCantidadPartidasJugadas() + 1);
        p.getJugadorNegro().setCantidadPartidasJugadas(p.getJugadorNegro().getCantidadPartidasJugadas() + 1);
        while (p.getTablero().encontroGanador() == 'E' && cantFichasTotal > 0 && !abandono) { //Mientras No encontro ganador, Hay fichas y no abandono nadie
            System.out.println("\n\n" + ANSI_GREEN + "<--- Jugar Turno para " + p.getJugadorBlanco().getAlias() + " con fichas BLANCAS: (para abandonar la partida debe ingresar 'X')---> " + ANSI_RESET + "\n");
            abandono = pedirUbicacionFicha(p, 'B'); //Paso la partida y el color de ficha
            if (abandono == true) {
                hayGanador = determinarGanador('N', p); // Si Abandono entonces determino ganador a Jugador Negro
            }
            if (p.getTablero().encontroGanador() == 'E' && !abandono) {//no gano con el movimiento o salio
                imprimirTablero(p.getTablero());
                System.out.println("\n");
                posHuecoNuevo = obtenerPosHueco(p.getTablero(), 2, posHuecoAnt, p.getDeshacerMovPosHueco());
                p.setDeshacerMovPosHueco(posHuecoAnt);
                posHuecoAnt = posHuecoNuevo;
                p.getTablero().moverHueco(p.getTablero().setNumeroSubtablero(posHuecoNuevo, p.getTablero().getOpcionDeTablero()));
                imprimirTableroHueco(p.getTablero());
                System.out.println("\n");
                //imprimirTablero(p.getTablero());
                if (p.getTablero().encontroGanador() == 'E') {//no hay ganador
                    //TURNO JUGADOR 2
                    System.out.println("\n\n" + ANSI_GREEN + "<--- Jugar Turno para Jugador 2: (para abandonar la partida debe ingresar 'X')--->" + ANSI_RESET + "\n");
                    abandono = pedirUbicacionFicha(p, 'N');
                    if (abandono == true) {
                        hayGanador = determinarGanador('B', p);
                    }
                    if (p.getTablero().encontroGanador() == 'E' && !abandono) {// si con el movimiento no hay ganador
                        //mueve el hueco
                        posHuecoNuevo = obtenerPosHueco(p.getTablero(), 2, posHuecoAnt, p.getDeshacerMovPosHueco());
                        p.setDeshacerMovPosHueco(posHuecoAnt);
                        posHuecoAnt = posHuecoNuevo;
                        p.getTablero().moverHueco(p.getTablero().setNumeroSubtablero(posHuecoNuevo, p.getTablero().getOpcionDeTablero()));
                        System.out.println("\n");
                        imprimirTablero(p.getTablero());
                    }
//                    else {
//                        imprimirTablero(p.getTablero());
//                        hayGanador = determinarGanador(p.getTablero().encontroGanador(), p);
//                    }
                }

            } else { // hay ganador
//                hayGanador = determinarGanador(p.getTablero().encontroGanador(), p);
            }

            p.setCantidadFichas(p.getCantidadFichas() - 2);
        }

        determinarGanador(p.getTablero().encontroGanador(), p);
    }

    public static boolean determinarGanador(char jugador, Partida p) {
        boolean hayGanador = false;
        if (jugador == 'B') {
            System.out.println("\n\n" + ANSI_BLUE + " FELICITACIONES " + p.getJugadorBlanco().getAlias() + " GANASTE! " + ANSI_RESET + "\n\n");
            p.getJugadorBlanco().setCantidadPartidasGanadas(p.getJugadorBlanco().getCantidadPartidasGanadas() + 1);
            p.getJugadorNegro().setCantidadPartidasPerdidas(p.getJugadorNegro().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
        }
        if (jugador == 'N') {
            System.out.println("\n\n" + ANSI_BLUE + " FELICITACIONES " + p.getJugadorNegro().getAlias() + " GANASTE! " + ANSI_RESET + "\n\n");
            p.getJugadorNegro().setCantidadPartidasGanadas(p.getJugadorBlanco().getCantidadPartidasGanadas() + 1);
            p.getJugadorBlanco().setCantidadPartidasPerdidas(p.getJugadorNegro().getCantidadPartidasPerdidas() + 1);
            hayGanador = true;
        }
        return hayGanador;
    }

    public static boolean pedirUbicacionFicha(Partida p, char colorJugador) {
        //Este metodo pide la ubicacion de una ficha y valide el formato 

        //Scanner para leer datos ingresados por el usuario
        Scanner in = new Scanner(System.in);

        int[] ubicacion = new int[2];
        String retorno;
        boolean correcto = false;
        boolean espaciosVacios;
        boolean partidaAbandonada = false;
        System.out.println("\nElija la ubicación donde quiere ubicar su ficha\n");
        System.out.println("-- El formato de ingreso es por ejemplo : A1 -> Fila A, Columna 1 --");

        while (!correcto && !partidaAbandonada) {
            try {
                retorno = in.nextLine();
                espaciosVacios = retorno.contains(" "); //contiene espacios
                if (retorno.isEmpty() || espaciosVacios || retorno.length() > 2) {
                    //el string esta vacio o empieza con espacio o tiene mas de 2 caracteres
                    System.out.println("\n" + ANSI_RED + "Debe ingresar una posición correcta! Vuelva a intentarlo: " + ANSI_RESET + "\n");

                } else if (retorno.charAt(0) == 'x' || retorno.charAt(0) == 'X') {
                    partidaAbandonada = true;

                } else if (p.getTablero().posicionValidaTablero(retorno.charAt(0), retorno.charAt(1),
                        p.getTablero().getOpcionDeTablero())) {
                    ubicacion[0] = letraAnum(retorno); // en ubicacion de 0, pongo la fila 
                    ubicacion[1] = Character.getNumericValue(retorno.charAt(1)) - 1;

                    if (p.getTablero().setFicha(ubicacion, colorJugador)) {
                        correcto = true;
                    } else {
                        System.out.println(ANSI_RED + "Debe ingresar una posición correcta! Vuelva a intentarlo: " + ANSI_RESET + "\n");
                    }
                } else {
                    System.out.println(ANSI_RED + "Debe ingresar una posición correcta! Vuelva a intentarlo: " + ANSI_RESET + "\n");
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Debe ingresar una posición correcta! Vuelva a intentarlo:" + ANSI_RESET + " \n");
            }
        }
        return partidaAbandonada;
    }

    public static int letraAnum(String letra) {
        letra = letra.toUpperCase();
        char let = letra.charAt(0);
        int coordRetorno = 0;
        switch (let) {
            case 'A':
                coordRetorno = 0;
                break;
            case 'B':
                coordRetorno = 1;
                break;
            case 'C':
                coordRetorno = 2;
                break;
            case 'D':
                coordRetorno = 3;
                break;
            case 'E':
                coordRetorno = 4;
                break;
            case 'F':
                coordRetorno = 5;
                break;
            case 'G':
                coordRetorno = 6;
                break;
            case 'H':
                coordRetorno = 7;
                break;
        }
        return coordRetorno;
    }

    public static void imprimirRankingJugadores(Sistema miSistema) {
        ArrayList<Jugador> listaJugadores;
        listaJugadores = miSistema.ordenarCrecienteJugador();
        listarJugadores(listaJugadores);
    }

    public static boolean validarPosicionHueco(int posHuecoAnt, int posHuecoNueva, int tamanioTablero, int posDeshacerMov) {
        /*
        posHuecoAnt = posicion donde se encuentra le hueco, antes de moverlo hacia posHuecoNueva
         */

        boolean esValido = false;
        int horizontal = 0, vertical = 0;
        switch (tamanioTablero) {
            case 1: //tablero 6*6
                horizontal = 3;
                vertical = 9;
                break;
            case 2: //tablero 4*6
                horizontal = 2;
                vertical = 6;
                break;
            case 3: //tablero 6*4
                horizontal = 3;
                vertical = 6;
                break;
            case 4: //tablero 8*8
                horizontal = 4;
                vertical = 12;
                break;
        }
        if (((posHuecoAnt + 1 == posHuecoNueva) || (posHuecoAnt - 1 == posHuecoNueva)) && (posHuecoNueva > 0) && (posHuecoAnt != posHuecoNueva) && (posDeshacerMov != posHuecoNueva)) {
            esValido = true;
        }

        if (((posHuecoAnt + horizontal == posHuecoNueva) || (posHuecoAnt - horizontal == posHuecoNueva)) && (posHuecoNueva <= vertical && posHuecoNueva > 0) && (posHuecoAnt != posHuecoNueva) && (posDeshacerMov != posHuecoNueva)) {
            esValido = true;
        }

        return esValido;

    }

}
