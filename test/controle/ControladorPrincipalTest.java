/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import controle.ControladorPrincipal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ControladorPrincipalTest {
    
    public ControladorPrincipalTest() {
    }
    
    @Test
    public void iniciarControladoresTest(){
        ControladorPrincipal cp = new ControladorPrincipal();
        assertNotNull(cp.getCtrChamados());
        assertNotNull(cp.getCtrTecnicos());
        assertNotNull(cp.getCtrClientes());
        assertNotNull(cp.getCtrEmpresa());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    }
}
