package ObligatorioDos;

import Dominio.Partida;
import Dominio.Sistema;
import Interfaz.VentanaMenuPrincipal;
import java.awt.Rectangle;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Sistema miSistema = new Sistema();
        int[] config = new int[2];
        VentanaMenuPrincipal menu = new VentanaMenuPrincipal(miSistema);
        Rectangle rct = menu.getGraphicsConfiguration().getBounds();
        menu.setLocation((rct.width - menu.getWidth()) / 2, (rct.height - menu.getHeight()) / 2);
        menu.setVisible(true);

        Partida partida = new Partida();

    }

}
