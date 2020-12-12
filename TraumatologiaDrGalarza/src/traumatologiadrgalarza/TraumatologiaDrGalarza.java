/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traumatologiadrgalarza;

import Views.adminIngreso;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Dell
 */
public class TraumatologiaDrGalarza {
    public static void main(String[] args) throws IOException {
        adminIngreso entra = new adminIngreso();
        entra.show();
    }
    
}
