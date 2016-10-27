/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleTest;

import controle.ControleClientes;
import controle.ControleClientes;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ControleClientesTest {
    
    @Test
    public void clienteDAONullTest(){
        ControleClientes cc = new ControleClientes();
        assertNotNull(cc.getClienteDAO());
    }
    
    @Test
    public void incluiNovoClienteTest(){
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        
        ClienteEmpresa cli2 = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
        assertTrue((cli.getNome().equals(cli2.getNome()))&&(cli.getCpf()==cli2.getCpf())&&(cli.getTelefone()==cli2.getTelefone())&&(cli.getEmpresa().equals(cli2.getEmpresa())));
    }
    
    @Test (expected = Exception.class)
    public void empresaNullnoincluiNovoClienteTest() throws Exception{
        ControleClientes cc = new ControleClientes();
        ClienteEmpresa cli = new ClienteEmpresa(123, null, 12345678912L, "Heitor", 59205920);
        ClienteEmpresa cli2 = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
    }
    
    @Test (expected = Exception.class)
    public void nomeNullnoincluiNovoClienteTest() throws Exception{
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, null, 59205920);
        ClienteEmpresa cli2 = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
    }
    
    @Test (expected = Exception.class)
    public void cpfInvalidonoincluiNovoClienteTest() throws Exception{
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, -12345678912L, "Heitor", 59205920);
        ClienteEmpresa cli2 = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
    }
    
    @Test (expected = Exception.class)
    public void telefoneInvalidonoincluiNovoClienteTest() throws Exception{
        ControleClientes cc = new ControleClientes();
        Empresa empresa = new Empresa(2,"JJBenites");
        ClienteEmpresa cli = new ClienteEmpresa(123, empresa, 12345678912L, "Pedro", -59205920);
        ClienteEmpresa cli2 = cc.incluiNovoCliente(cli.getEmpresa(), cli.getCpf(), cli.getNome(), cli.getTelefone());
    }
    
}
