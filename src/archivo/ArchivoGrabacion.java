package archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArchivoGrabacion {
    private static File archivo;
    private static FileWriter fw;
    private static BufferedWriter bw;
    private static PrintWriter pw;
    
    public static void crear(String nombreArchivo) throws IOException {
     //   archivo = new File(nombreArchivo);
        fw = new FileWriter(nombreArchivo);
        bw = new BufferedWriter(fw);       
    }
    
    public static void grabar(String nuevaLinea) throws IOException {
        bw.write(nuevaLinea);
        bw.newLine();

    }
    
    public static void cerrar() throws IOException {
        bw.close();
    }
}
