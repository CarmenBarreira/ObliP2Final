package Dominio;

public class Tablero {

    //Atributos
    private char[][] tablero; //Matriz del tablero grande
    private int[] posHueco; // Array con Posiciones X([0]) e Y ([1])
    private char[][] hueco = new char[][]{{'X', 'X'}, {'X', 'X'}}; //Hueco definido con caracteres x
    private int opcionDeTablero; //tamaño del tablero

    //Constructor
    public Tablero(int size, int posHuecoInicio) {
        opcionDeTablero = size;
        int[] dimensiones = setTamanioTablero(opcionDeTablero); //SET TAMAÑO TABLERO ES UN METODO QUE TRAE LAS DIMENSIONES SEGUN LA OPCION SELECCIONADA!
        this.tablero = new char[dimensiones[0]][dimensiones[1]]; // CREO EL SUBTABLERO DE DIMENSIONES DADAS POR EL ARRAY DE ARRIBA
        rellenarTablero();//RELLENO EL SUBTABLERO DE CHARS VACIOS
        posHueco = setNumeroSubtablero(posHuecoInicio, size); //INICIALIZO LA POSICION DEL HUECO EN EL SUBTABLERO DADO
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

    //Metodo de seteo de tamaños
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

    //Metodo para extraer un subtablero (Ya sea para copiarlo, o para moverlo)
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
        char siHayGanador = 'E';
        for (int i = 0; i < this.getTablero().length - 1; i++) {
            for (int j = 0; j < this.getTablero()[0].length - 1; j++) {
                if (this.getTablero()[i][j] == this.getTablero()[i][j + 1]
                        && this.getTablero()[i + 1][j] == this.getTablero()[i + 1][j + 1]
                        && this.getTablero()[i][j] == this.getTablero()[i + 1][j]
                        && this.getTablero()[i][j] != ' ' && this.getTablero()[i][j] != 'X') {

                    siHayGanador = this.getTablero()[i][j];

                }
            }
        }
        return siHayGanador;
    }

    public boolean setFicha(int[] posFicha, char color) {
        //METODO PARA COLOCAR FICHA, RECIBO LA POSICION CON UN ARRAY DE [X,Y] y EL COLOR!!!
        //Si la posicion esta bien, setea el color y retorna true, sino retorna false

        boolean esAceptable = true;
        if ((this.tablero[posFicha[0]][posFicha[1]] != ' ')
                || //NO DEJO PONER FICHA EN EL HUECO
                (this.tablero[posFicha[0]][posFicha[1]] == 'B')
                || //No dejo poner ficha si hay una blanca
                (this.tablero[posFicha[0]][posFicha[1]] == 'N')) { //No dejo poner ficha si hay una negra
            esAceptable = false;

        } else {
            this.tablero[posFicha[0]][posFicha[1]] = color;
        }
        return esAceptable;
    }

    //DADO UN NUMERO DE SUBTABLERO, Y EL TAMANO DE UN TABLERO, RETORNO LAS COORDENADAS DE DICHO SUBTABLERO
    // EJ: QUIERO EL SUBTABLERO 4 DE UN TABLERO DE 4X6
    public int[] setNumeroSubtablero(int numeroSubtablero, int size) {

        int[] coordSubtablero = new int[2]; //INICIALIZO LA VARIABLE QUE VOY A DEVOLVER
        int[] sizeTablero = setTamanioTablero(size); //ME TRAIGO EL TAMAÑO DEL TABLERO
        int constanteColumna = sizeTablero[1] / 2; //CONSTANTE COLUMNA ES LA CANTIDAD DE COLUMNAS / 2, QUE ES CADA CUANTO HAY UN SUBTABLERO EJ EN UN 4x6 HAY 3 COLUMNAS DE SUBTABLEROS
        int fila = 0; //INICIALIZO LAS COORD DE LA FILA EN 0
        boolean encontreSubtablero = false;
        while (!encontreSubtablero) { //MIENTRAS NO HAYA ENCONTRADO EL SUBTABLERO
            if (numeroSubtablero <= constanteColumna) {//SI EL NUMERO DE SUBTABLERO ES <= A LA CANTIDAD DE COLUMNAS DE SUBTABLEROS(equivalen a 2 columnas Cada Una)
                coordSubtablero[0] = fila; // seteo fila
                coordSubtablero[1] = (2 * numeroSubtablero) - 2; // la columna es 2* el numero de subtablero -2 
                encontreSubtablero = true; //salgo del while
            }
            if (numeroSubtablero > constanteColumna) { //SI EL N DE SUBTABLERO ES MAS GRANDE! QUE LAS COLUMNAS /2 (la constante)
                fila = fila + 2; //BAJO A LA SIGUIENTE FILA
                numeroSubtablero = numeroSubtablero - constanteColumna; // Y LE RESTO EL NUMERO DE COLUMNAS A EL NUMERO DE SUBTABLERO (PARA ASI VOLVER A EMPEZAR CON UN N MAS CHICO EN LA SIGUIENTE FILA)
            }
        }

        return coordSubtablero;
    }

    public boolean posicionValidaTablero(char fila, char columna, int tamanioTablero) {
        boolean esValida = false;
        int auxFila, auxColumna;
        auxFila = (int) fila;
        auxColumna = (int) columna;
        switch (tamanioTablero) {
            case 1: //6*6
                if (((auxFila >= 65 && auxFila <= 70)|| (auxFila >= 97 && auxFila <= 102)) && (auxColumna >= 49 && auxColumna <= 54)) {
                    esValida = true;
                }
                break;
            case 2: //4*6
                if (((auxFila >= 65 && auxFila <= 68)|| (auxFila >= 97 && auxFila <= 100) ) && (auxColumna >= 49 && auxColumna <= 54)) {
                    esValida = true;
                }
                break;
            case 3: //6*4
                if (((auxFila >= 65 && auxFila <= 70)|| (auxFila >= 97 && auxFila <= 102)) && (auxColumna >= 49 && auxColumna <= 52)) {
                    esValida = true;
                }
                break;
            case 4: //8*8
                if (((auxFila >= 65 && auxFila <= 72)|| (auxFila >= 97 && auxFila <= 104)) && (auxColumna >= 49 && auxColumna <= 56)) {
                    esValida = true;
                }
                break;
        }

        return esValida;
    }

    public void moverHueco(int[] coordSubtablero) {

        char[][] aux = this.getSubtablero(coordSubtablero).clone();

        this.setSubtablero(coordSubtablero, hueco);

        this.setSubtablero(this.posHueco, aux);
        this.posHueco = coordSubtablero.clone();
    }
    
     

}
