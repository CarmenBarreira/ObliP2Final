package Dominio;

import java.io.Serializable;

public class Tablero implements Serializable{

    //Atributos
    private char[][] tablero; //Matriz del tablero grande
    
    private int[] posHueco; // Array con Posiciones X([0]) e Y ([1])
    
    private char[][] hueco = new char[][]{{'X', 'X'}, {'X', 'X'}}; 
    //Hueco definido con caracteres x
    
    private int opcionDeTablero; //tamaño del tablero

    //Constructor
    public Tablero(int size, int posHuecoInicio) {
        opcionDeTablero = size;
        
        //SET TAMAÑO TABLERO ES UN METODO QUE TRAE LAS DIMENSIONES SEGUN LA OPCION SELECCIONADA!
        int[] dimensiones = setTamanioTablero(opcionDeTablero); 
        
        // CREA EL SUBTABLERO DE DIMENSIONES DADAS POR EL ARRAY DE ARRIBA
        this.tablero = new char[dimensiones[0]][dimensiones[1]]; 
        rellenarTablero();//RELLENO EL SUBTABLERO DE CHARS VACIOS
        
        //INICIALIZO LA POSICION DEL HUECO EN EL SUBTABLERO DADO
        posHueco = setNumeroSubtablero(posHuecoInicio, size); 
        setSubtablero(posHueco, hueco); //SETEO DEL HUECO EN LA POSICION DADA
    }

    //get's y set's
    public char[][] getTablero() {
        return this.tablero;
    }

    public void setTablero(char[][] miTablero) {
        this.tablero = miTablero;
    }

    public int[] getPosHueco() {
        return posHueco;
    }

    public void setPosHueco(int[] laPosHueco) {
        this.posHueco = laPosHueco;
    }

    public char[][] getHueco() {
        return this.hueco;
    }

    public int getOpcionDeTablero() {
        return opcionDeTablero;
    }

    public void setOpcionDeTablero(int opcionDeTablero) {
        this.opcionDeTablero = opcionDeTablero;
    }

    public void setHueco(char[][] elHueco) {
        this.hueco = elHueco;
    }

    //Método de seteo de tamaños
    public int[] setTamanioTablero(int size) {
        int[] tamanio = new int[2];

        switch (size) {
            //OPCION 6x6
            case 1:
                tamanio[0] = 6;
                tamanio[1] = 6;
                break;
            case 2:
                tamanio[0] = 4;
                tamanio[1] = 6;
                break;
            case 3:
                tamanio[0] = 6;
                tamanio[1] = 4;
                break;
            case 4:
                tamanio[0] = 8;
                tamanio[1] = 8;
                break;
        }

        return tamanio;
    }

    //Método para extraer un subtablero (Ya sea para copiarlo, o para moverlo)
    private char[][] getSubtablero(int[] coordSubtablero) {
        char[][] subTableroMatriz = new char[2][2];
        subTableroMatriz[0][0] = this.getTablero()[coordSubtablero[0]][coordSubtablero[1]];
        subTableroMatriz[0][1] = this.getTablero()[coordSubtablero[0]][coordSubtablero[1] + 1];
        subTableroMatriz[1][0] = this.getTablero()[coordSubtablero[0] + 1][coordSubtablero[1]];
        subTableroMatriz[1][1] = this.getTablero()[coordSubtablero[0] + 1][coordSubtablero[1] + 1];
        return subTableroMatriz;
    }

    //PASO UNA MATRIZ DE 2x2 Y LA SETEO EN EL LA POSICION DE SUBTABLERO DADA!
    private void setSubtablero(int[] coordSubtablero, char[][] subTablero) {
        this.getTablero()[coordSubtablero[0]][coordSubtablero[1]] = subTablero[0][0];
        this.getTablero()[coordSubtablero[0]][coordSubtablero[1] + 1] = subTablero[0][1];
        this.getTablero()[coordSubtablero[0] + 1][coordSubtablero[1]] = subTablero[1][0];
        this.getTablero()[coordSubtablero[0] + 1][coordSubtablero[1] + 1] = subTablero[1][1];
    }

    //RELLENO EL SUBTABLERO CON CHARS VACIOS
    private void rellenarTablero() {
        for (int i = 0; i < this.getTablero().length; i++) {
            for (int j = 0; j < this.getTablero()[0].length; j++) {
                this.getTablero()[i][j] = ' ';
            }
        }
    }

    public char encontroGanador() {
        /*Retorna E -> si no hay ganador
        Retorna A -> si ganaron los 2
        Retorna B -> Si gano jugador blanco
        Retorna N -> si gano el jugador negro
        */
        
        int pos =0;
        char[] ganadores= {'E', 'E'};
        
        char siHayGanador = 'E';
        
        for (int i = 0; i < this.getTablero().length - 1; i++) {
            for (int j = 0; j < this.getTablero()[0].length - 1; j++) {
                if (this.getTablero()[i][j] == this.getTablero()[i][j + 1]
                        && this.getTablero()[i + 1][j] == this.getTablero()[i + 1][j + 1]
                        && this.getTablero()[i][j] == this.getTablero()[i + 1][j]
                        && this.getTablero()[i][j] != ' ' && this.getTablero()[i][j] != 'X') {

                    siHayGanador = this.getTablero()[i][j];
                    if(siHayGanador=='B'){
                        ganadores[0]='B';
                    }
                    if(siHayGanador=='N'){
                        ganadores[1]='N';
                    }
                }
            }
        }
        if((ganadores[0]=='B') && (ganadores[1]=='N')){
            siHayGanador='A';
        }
        
        
        return siHayGanador;
    }

    public boolean setFicha(int[] posFicha, char color) {
    /*METODO PARA COLOCAR FICHA, RECIBO LA POSICION CON UN ARRAY DE [X,Y] y EL COLOR!
     Si la posicion esta bien, setea el color y retorna true, sino retorna false*/

        boolean esAceptable = true;
        if ((this.tablero[posFicha[0]][posFicha[1]] != ' ')
                || //NO DEJO PONER FICHA EN EL HUECO
                (this.tablero[posFicha[0]][posFicha[1]] == 'B')
                || //No dejo poner ficha si hay una blanca
                //No dejo poner ficha si hay una negra
                (this.tablero[posFicha[0]][posFicha[1]] == 'N')) { 
            esAceptable = false;
        } else {
            this.tablero[posFicha[0]][posFicha[1]] = color;
        }
        return esAceptable;
    }

    /*DADO UN NUMERO DE SUBTABLERO, Y EL TAMANO DE UN TABLERO, 
    RETORNO LAS COORDENADAS DE DICHO SUBTABLERO
    EJ: QUIERO EL SUBTABLERO 4 DE UN TABLERO DE 4X6*/
    public int[] setNumeroSubtablero(int numeroSubtablero, int size) {

        //INICIALIZO LA VARIABLE QUE VOY A DEVOLVER
        int[] coordSubtablero = new int[2]; 
        //ME TRAIGO EL TAMAÑO DEL TABLERO
        int[] sizeTablero = setTamanioTablero(size); 
        /*CONSTANTE COLUMNA ES LA CANTIDAD DE COLUMNAS / 2, 
        QUE ES CADA CUANTO HAY UN SUBTABLERO EJ EN UN 4x6 HAY 3 COLUMNAS DE SUBTABLEROS*/
        int constanteColumna = sizeTablero[1] / 2; 
        int fila = 0; //INICIALIZO LAS COORD DE LA FILA EN 0
        boolean encontreSubtablero = false;
    
        while (!encontreSubtablero) { //MIENTRAS NO HAYA ENCONTRADO EL SUBTABLERO
            
            //SI EL NUMERO DE SUBTABLERO ES <= A LA CANTIDAD DE COLUMNAS DE SUBTABLEROS(equivalen a 2 columnas cada Una)
            if (numeroSubtablero <= constanteColumna) {
                coordSubtablero[0] = fila; // seteo fila
                coordSubtablero[1] = (2 * numeroSubtablero) - 2; //la columna es 2* el numero de subtablero -2 
                encontreSubtablero = true; //salgo del while
            }
            //SI EL N DE SUBTABLERO ES MAS GRANDE! QUE LAS COLUMNAS /2 (la constante)
            if (numeroSubtablero > constanteColumna) { 
                fila = fila + 2; //BAJO A LA SIGUIENTE FILA
                /* Y LE RESTO EL NUMERO DE COLUMNAS A EL NUMERO DE SUBTABLERO (
               PARA ASI VOLVER A EMPEZAR CON UN N MAS CHICO EN LA SIGUIENTE FILA)*/
                numeroSubtablero = numeroSubtablero - constanteColumna; 
            }
        }
        return coordSubtablero;
    }

    public boolean posicionValidaTablero(char fila, char columna, int tamanioTablero) {
        //valida que la posición de ingreso de la ficha sea valida
        
        boolean esValida = false;
        int auxFila, auxColumna;
        auxFila = (int) fila;
        auxColumna = (int) columna;
        switch (tamanioTablero) {
            case 1: //6*6
                if (((auxFila >= 65 && auxFila <= 70)|| (auxFila >= 97 && 
                        auxFila <= 102)) && (auxColumna >= 49 && auxColumna <= 54)) {
                    esValida = true;
                }
                break;
            case 2: //4*6
                if (((auxFila >= 65 && auxFila <= 68)|| (auxFila >= 97 && 
                        auxFila <= 100) ) && (auxColumna >= 49 && auxColumna <= 54)) {
                    esValida = true;
                }
                break;
            case 3: //6*4
                if (((auxFila >= 65 && auxFila <= 70)|| (auxFila >= 97 && 
                        auxFila <= 102)) && (auxColumna >= 49 && auxColumna <= 52)) {
                    esValida = true;
                }
                break;
            case 4: //8*8
                if (((auxFila >= 65 && auxFila <= 72)|| (auxFila >= 97 && 
                        auxFila <= 104)) && (auxColumna >= 49 && auxColumna <= 56)) {
                    esValida = true;
                }
                break;
        }

        return esValida;
    }

    public void moverHueco(int[] coordSubtablero) {
        //mueve el hueco
        char[][] aux = this.getSubtablero(coordSubtablero).clone();

        this.setSubtablero(coordSubtablero, hueco);

        this.setSubtablero(this.posHueco, aux);
        this.posHueco = coordSubtablero.clone();
    }
        
    public boolean validarPosicionHueco(int posHuecoAnt,
            int posHuecoNueva, int posDeshacerMov) {
        /* posHuecoAnt = posicion donde se encuentra el hueco, 
        antes de moverlo hacia posHuecoNueva */

        boolean esValido = false;
        int horizontal = 0, vertical = 0;
        switch (opcionDeTablero) {
            case 1: //tablero 6*6
                horizontal = 3;
                vertical = 9;
                break;
            case 2: //tablero 4*6
                horizontal = 3;
                vertical = 6;
                break;
            case 3: //tablero 6*4
                horizontal = 2;
                vertical = 6;
                break;
            case 4: //tablero 8*8
                horizontal = 4;
                vertical = 16;
                break;
        }

        if ((((posHuecoAnt + 1 == posHuecoNueva) || (posHuecoAnt - 1 == posHuecoNueva))
                && calculaFila(posHuecoAnt, horizontal) == calculaFila(posHuecoNueva, horizontal))
                && (posHuecoNueva > 0) && (posHuecoAnt != posHuecoNueva)
                && (posDeshacerMov != posHuecoNueva)) {
            esValido = true;
        }

        if (((posHuecoAnt + horizontal == posHuecoNueva)
                || (posHuecoAnt - horizontal == posHuecoNueva))
                && (posHuecoNueva <= vertical && posHuecoNueva > 0)
                && (posHuecoAnt != posHuecoNueva) && (posDeshacerMov != posHuecoNueva)) {
            esValido = true;
        }

        return esValido;

    }
    
    public static int calculaFila(int subTablero, int tamanio) {
        //dada la posicion de subtablero que se pasa y el tamañio de tablero
        //retorna la fila en la que se encuentra el subtablero en el tablero.
        int fila = -1;
        if (subTablero <= tamanio) {
            fila = 1;
        }

        if (subTablero > tamanio && subTablero <= tamanio * 2) {
            fila = 2;
        }

        if (subTablero > tamanio * 2 && subTablero <= tamanio * 3) {
            fila = 3;
        }
        if (subTablero > tamanio * 3 && subTablero <= tamanio * 4) {
            fila = 4;
        }
        return fila;
    }
    
    
    public int getPosHuecoCargar(int tamañoTablero, int[] comienzoSubtablero ){
        //comienzoSubtablero es la primer posicion de donde arranca el subtablero
               
        int subtablero =0;
        
        if (comienzoSubtablero[0]==0 && comienzoSubtablero[1]==0){
            /*el subtablero 1 siempre esta no importa el tamaño del tablero 
            y la primer posicion siempre es [0][0]*/
             subtablero=1;
        }
        else{
            if (comienzoSubtablero[0]==0 && comienzoSubtablero[1]==2){
                /*el subtablero 2 siempre esta no importa el tamaño del tablero 
                y la primer posicion siempre es [0][2]*/
                subtablero =2;
            }
            else{
                if ((comienzoSubtablero[0]==0 && comienzoSubtablero[1]==4 && 
                     (tamañoTablero ==1 || tamañoTablero == 2 || tamañoTablero==4))
                    || (tamañoTablero ==3 && comienzoSubtablero[0]==2 && comienzoSubtablero[1]==0)){
                 /*Si es la posicion 04 y tamaño tablero es 1,2,4 O 
                    posicion 20 y tamaño tablero 3 = 6*4  */   
                    subtablero =3;
                }
                else{
                    if ((comienzoSubtablero[0]==0 && comienzoSubtablero[1]==6 && tamañoTablero ==4)
                            || (comienzoSubtablero[0]==2 && comienzoSubtablero[1]==2 && tamañoTablero==3)
                            || (comienzoSubtablero[0]==2 && comienzoSubtablero[1]==0 && tamañoTablero ==1)
                            || (comienzoSubtablero[0]==2 && comienzoSubtablero[1]==0 && tamañoTablero == 2)){
                        subtablero =4;
                    }
                    else{
                        if ((comienzoSubtablero[0]==2 && comienzoSubtablero[1]==0 && tamañoTablero==4)
                            || (comienzoSubtablero[0]==2 && comienzoSubtablero[1]==2 && (tamañoTablero ==1
                            || tamañoTablero == 2))
                            || (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==4) && tamañoTablero==3 ){
                            subtablero = 5;
                        }
                        else{
                            if ((comienzoSubtablero[0]==2 && comienzoSubtablero[1]==2 && tamañoTablero==4)
                               || (comienzoSubtablero[0]==2 && comienzoSubtablero[1]==4 && 
                                    (tamañoTablero==1 || tamañoTablero==2))
                               || (tamañoTablero ==3 && comienzoSubtablero[0]==4 && comienzoSubtablero[1]==2)){
                                 subtablero = 6;
                            }
                            else{
                                if ((comienzoSubtablero[0]==2 && comienzoSubtablero[1]==4 && tamañoTablero == 4)
                                    || (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==0 && tamañoTablero==1)){
                                     subtablero = 7;
                                }
                                else{
                                    if ((comienzoSubtablero[0]==2 && comienzoSubtablero[1]==6 && tamañoTablero==4)
                                        || (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==2 && tamañoTablero==1) ){
                                        subtablero = 8;
                                    }
                                    else{
                                        if ((comienzoSubtablero[0]==4 && comienzoSubtablero[1]==0 && tamañoTablero==4)
                                          || (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==4 && tamañoTablero==1)){
                                            subtablero = 9;
                                            }
                                            else{
                                                if ((comienzoSubtablero[0]==4 && comienzoSubtablero[1]==2 && tamañoTablero==4)){
                                                    subtablero = 10;
                                                }
                                                else{
                                                    if (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==4 && tamañoTablero ==4){
                                                        subtablero = 11;
                                                    }
                                                    else{
                                                        if (comienzoSubtablero[0]==4 && comienzoSubtablero[1]==6){
                                                             subtablero=12;
                                                         }
                                                         else{
                                                             if (comienzoSubtablero[0]==6 && comienzoSubtablero[1]==0){
                                                                subtablero=13;
                                                            }
                                                             else{
                                                                  if (comienzoSubtablero[0]==6 && comienzoSubtablero[1]==2){
                                                                        subtablero=14;
                                                                    }
                                                                  else{
                                                                      if (comienzoSubtablero[0]==6 && comienzoSubtablero[1]==4){
                                                                        subtablero=15;
                                                                     }
                                                                      else
                                                                          subtablero=16;
                                                                  }
                                                             }
                                                     }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
                  
        }   
       
        
        return subtablero;
    }
}
