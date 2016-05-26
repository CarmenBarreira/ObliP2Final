package archivo;

public class Archivo {
    private static String nombre;
    private static int tamanio;
    private static String ubicacion;
    
    public Archivo(String nombreArchivo) {
        nombre = nombreArchivo;
        tamanio = 0;
        ubicacion = "";
    }
    
    public String getNombre() {
        return nombre;
    }
}
