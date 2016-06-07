package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoLectura {
    
    private static BufferedReader br;
    private static File archivo;
    private static FileReader fr;
    
    public static void leerArchivo(File nombreArchivo) throws IOException, FileNotFoundException {
        archivo = nombreArchivo;
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
    }
    
    public static boolean hayMasLineas() throws IOException, FileNotFoundException {
        return br.ready();
    }
    
    public static String linea() throws IOException {
        return br.readLine();
    }
    
    public static void cerrar() throws IOException {
        br.close();
        fr.close();
    }
    
    
}
