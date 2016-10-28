/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Persistencia.ClienteDAO;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ClienteDAOTest {
    
    @Test
    public void validarCPFTest(){
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        ClienteDAO dao = new ClienteDAO();
        dao.put(cli);
        assertFalse(dao.validarCPF(cli.getCpf()));
    }
    
    @Test
    public void validarCPFInexistente(){
        ClienteDAO dao = new ClienteDAO();
        assertTrue(dao.validarCPF(95748603569L));
    }
    
    @Test
    public void voltaCashClienteTest(){
        ClienteDAO dao = new ClienteDAO();
        HashMap h = dao.voltaCashCliente();
        assertNotNull(h);
    }
    
    @Test
    public void gerarCodigoTest(){
        ClienteDAO dao = new ClienteDAO();
        assertNotNull(dao.gerarCodigo());
    }
    
    @Test
    public void incluirNoHashMapClienteTest(){
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        ClienteDAO dao = new ClienteDAO();
        dao.put(cli);
        ClienteEmpresa cli2 = dao.get(cli.getCpf());
        assertEquals(cli,cli2);
    }
    
    
    
}
