/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import controle.ControleChamados;
import entidade.BancoDeDados;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.SistemaOperacional;
import entidade.Status;
import entidade.Tecnico;
import entidade.TipoConexao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ControleChamadosTest {
    
    @Test
    public void alterarChamadoAlteradoTest(){
        ControleChamados cc = new ControleChamados();
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        
        cc.setChamadoAlterado(cd);
        assertEquals(cd,cc.getChamadoAlterado());
    }
    
    @Test (expected = Exception.class)
    public void alterarChamadoAlteradoNullTest(){
        ControleChamados cc = new ControleChamados();
        cc.setChamadoAlterado(null);
    }
    
    @Test
    public void alterarChamadoTest(){
        ControleChamados cc = new ControleChamados();
        
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        //Novo chamado de Desempenho
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        
        Chamado c = cc.InserirChamadoDesempenho(cd.getTitulo(), cd.getDescricao(), cd.getPrioridade(), cd.getTecnico(), cd.getCliente(), cd.getSistemaOperacional(), cd.getVersaoSO(), cd.getOperacao(), cd.getDuracaoOperacao());
        cc.alterarChamado(c, ""+Status.em_atendimento, "O HD está quase cheio", "Realizar limpeza de Disco");
        assertEquals(c.getCausaProblema(), "O HD está quase cheio");
        assertEquals(c.getSolucaoProblema(), "Realizar limpeza de Disco");
        assertEquals(c.getStatus(), "em_atendimento"); 
    }
    
    @Test (expected = Exception.class)
    public void chamadoNullnoAlterarChamadoTest() throws Exception{
        ControleChamados cc = new ControleChamados();
        cc.alterarChamado(null, ""+Status.encerrado, "O HD está quase cheio", "Realizar limpeza de Disco");
    }
    
    @Test (expected = Exception.class)
    public void statusNullnoAlterarChamadoTest(){
        ControleChamados cc = new ControleChamados();
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        cc.alterarChamado(cd, null, "O HD está quase cheio", "Realizar limpeza de Disco");
    }
    
    @Test (expected = Exception.class)
    public void causaNullnoAlterarChamadoTest(){
        ControleChamados cc = new ControleChamados();
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        cc.alterarChamado(cd, ""+Status.encerrado, null, "Realizar limpeza de Disco");
    }
    
    @Test (expected = Exception.class)
    public void solucaoNullnoAlterarChamadoTest(){
        ControleChamados cc = new ControleChamados();
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        cc.alterarChamado(cd, ""+Status.encerrado, "O HD está quase cheio", null);
    }
    
    @Test
    public void inserirChamadoRedeTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cr = new Chamado(157,"Falha na conexão local","Cliente não consegue acessar a internet",5,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.Radio,"198.161.0.1");
        
        Chamado cr2 = cc.InserirChamadoRede(cr.getTitulo(), cr.getDescricao(), cr.getPrioridade(), cr.getTecnico(), cr.getCliente(), cr.getSistemaOperacional(), cr.getVersaoSO(), cr.getTipoConexao(), cr.getEnderecoRede());
        Chamado c = cc.buscaPeloCodigo(cr2.getCodigo());
        assertTrue(cr.getTitulo().equals(c.getTitulo()));
        assertTrue(cr.getDescricao().equals(c.getDescricao()));
        assertSame(cr.getPrioridade(), c.getPrioridade());
        assertEquals(cr.getTecnico(),c.getTecnico());
        assertEquals(cr.getCliente(),c.getCliente());
        assertEquals(cr.getSistemaOperacional(),c.getSistemaOperacional());
        assertEquals(cr.getVersaoSO(),c.getVersaoSO());
        assertEquals(cr.getTipoConexao(),c.getTipoConexao());
        assertEquals(cr.getEnderecoRede(),c.getEnderecoRede());
    }
    
    @Test
    public void inserirChamadoBancodeDadosTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cbd = new Chamado("Usuário não encontrado","O referido usuário não está registrado no banco de dados",2,tecnico,clienteEmpresa,""+SistemaOperacional.WINDOWS,"XP",""+BancoDeDados.Oracle);
        
        Chamado cbd2 = cc.InserirChamadoBancoDeDados(cbd.getTitulo(), cbd.getDescricao(), cbd.getPrioridade(), cbd.getTecnico(), cbd.getCliente(), cbd.getSistemaOperacional(), cbd.getVersaoSO(), cbd.getBancoDeDados());
        Chamado c = cc.buscaPeloCodigo(cbd2.getCodigo());
        assertTrue(cbd.getTitulo().equals(c.getTitulo()));
        assertTrue(cbd.getDescricao().equals(c.getDescricao()));
        assertSame(cbd.getPrioridade(), c.getPrioridade());
        assertEquals(cbd.getTecnico(),c.getTecnico());
        assertEquals(cbd.getCliente(),c.getCliente());
        assertEquals(cbd.getSistemaOperacional(),c.getSistemaOperacional());
        assertEquals(cbd.getVersaoSO(),c.getVersaoSO());
        assertEquals(cbd.getBancoDeDados(),c.getBancoDeDados());   
    }
    
    @Test
    public void inserirChamadoDesempenhoTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cd = new Chamado("Lentidão ao navegar","O SO está muito lento e travando muito",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        
        Chamado cd2 = cc.InserirChamadoDesempenho(cd.getTitulo(), cd.getDescricao(), cd.getPrioridade(), cd.getTecnico(), cd.getCliente(), cd.getSistemaOperacional(), cd.getVersaoSO(), cd.getOperacao(), cd.getDuracaoOperacao());
        Chamado c = cc.buscaPeloCodigo(cd2.getCodigo());
        assertTrue(cd.getTitulo().equals(c.getTitulo()));
        assertTrue(cd.getDescricao().equals(c.getDescricao()));
        assertSame(cd.getPrioridade(), c.getPrioridade());
        assertEquals(cd.getTecnico(),c.getTecnico());
        assertEquals(cd.getCliente(),c.getCliente());
        assertEquals(cd.getSistemaOperacional(),c.getSistemaOperacional());
        assertEquals(cd.getVersaoSO(),c.getVersaoSO());
        assertEquals(cd.getOperacao(),c.getOperacao());
        assertSame(cd.getDuracaoOperacao(),c.getDuracaoOperacao());
    }
    
    @Test
    public void inserirRegistroTest(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado cd = new Chamado(12,"Lentidão ao navegar","O SO está muito lento e travando muito",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu",""+TipoConexao.CaboModen,"123.231.0.1");
        
        RegistroChamado r = new RegistroChamado("Problema com Servidor", cd, tecnico);
        RegistroChamado r2 = cc.inserirRegistroChamado(r.getAssunto(), r.getChamado(), r.getTecnico());
        
        assertEquals(r.getAssunto(),r2.getAssunto());
        assertTrue(r.getChamado().equals(r2.getChamado()));
        assertTrue(r.getTecnico().equals(r2.getTecnico()));
    }
    
    @Test
    public void obterDetalhesChamado(){
        ControleChamados cc = new ControleChamados();
        
        Tecnico tecnico = new Tecnico("Pedro",46612321);
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Chamado c = new Chamado("Lentidão ao navegar","O SO está muito lento e travando muito",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        
        
        String detalhes = "\n" + "--------" + "\n" + "Data de abertura do chamado: "
                + c.getData() + "\n" + "Hororio de abertura do chamado: " + c.getHora() + "\n"
                + "Titulo do chamado: " + "Lentidão ao navegar" + "\n" + "Descri��o do chamado: " + "O SO está muito lento e travando muito" + "\n"
                + "Prioridade do chamado" + 3 + "\n" + "Status do chamado: " + "Iniciado" + "\n"
                + "Tipo de problema do chamado: " + "Problema de Desempenho" + "\n" + "Tecnico responsovel pelo chamado: "
                + "Pedro" + "\n" + "Cliente requisitor do chamado: " + "Heitor" + "\n";
        
        assertEquals(cc.retornaDetalhesChamado(c),detalhes);
    }
    
    //
    //Alterações inválidas
    //
    
    @Test (expected = Exception.class) 
    public void alterarStatusNullTest() throws Exception{
        ControleChamados cc = new ControleChamados();
        Empresa empresa = new Empresa(1,"Twitter");
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(123, empresa, 12345678912L, "Heitor", 59205920);
        Tecnico tecnico = new Tecnico("Pedro",46612321);
       
        Chamado cd = new Chamado("titulo","descrição",3,tecnico,clienteEmpresa,""+SistemaOperacional.LINUX,"Ubuntu","operação",10.5);
        
        Chamado c = cc.InserirChamadoDesempenho(cd.getTitulo(), cd.getDescricao(), cd.getPrioridade(), cd.getTecnico(), cd.getCliente(), cd.getSistemaOperacional(), cd.getVersaoSO(), cd.getOperacao(), cd.getDuracaoOperacao());
        
        cc.alterarChamado(c, null, "O HD está quase cheio", "Realizar limpeza de Disco");   
    }
    
}
