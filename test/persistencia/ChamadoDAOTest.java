/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Persistencia.ChamadoDAO;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.SistemaOperacional;
import entidade.Tecnico;
import entidade.TipoConexao;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ChamadoDAOTest {
    
    @Test
    public void cashChamadoNullTest(){
        ChamadoDAO dao = new ChamadoDAO();
        Chamado c = dao.get(null);
        assertNull(c);
    }
    
    @Test
    public void incluirChamadoTest(){
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cr = new Chamado(157,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        
        ChamadoDAO dao = new ChamadoDAO();
        dao.put(cr);
        Chamado c = dao.get(cr.getCodigo());
        assertEquals(cr,c);
    }
    
    @Test
    public void incluirRegistroTest(){
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cr = new Chamado(157,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        RegistroChamado r = new RegistroChamado("Problema com Servidor", cr, tecnico);
        ChamadoDAO dao = new ChamadoDAO();
        
        dao.putRegistro(r);
        Collection<RegistroChamado> reg = dao.getRegistros();
        boolean b = reg.contains(r);
        assertNotNull(b);
        
    }
    
    @Test
    public void tamanhoHashMapChamadoTest(){
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cr = new Chamado(157,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        
        ChamadoDAO dao = new ChamadoDAO();
        dao.put(cr);
        assertTrue(dao.getChamados().size() > 0);
    }
    
    @Test
    public void tamanhoHashMapRegistroTest(){
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cr = new Chamado(157,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        RegistroChamado r = new RegistroChamado("Problema com Servidor", cr, tecnico);
        ChamadoDAO dao = new ChamadoDAO();
        
        dao.putRegistro(r);
        assertTrue(dao.getRegistros().size() > 0);
    }
    
    
}
