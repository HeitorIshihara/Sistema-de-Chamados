/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Tecnico;
import java.text.DateFormat;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heitor Ishihara
 */
public class ChamadoTest {

    /*Teste de Inicialização*/
    @Test
    public void criarChamadoProblemaRede() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        assertEquals(c.getCodigo(), 123);
        assertEquals(c.getTitulo(), "Chamado1");
        assertEquals(c.getDescricao(), "TesteChamado1");
        assertEquals(c.getPrioridade(), 10);
        assertEquals(c.getTecnico(), tec);
        assertEquals(c.getCliente(), ce);
        assertEquals(c.getSistemaOperacional(), "LINUX");
        assertEquals(c.getVersaoSO(), "Ubuntu 16");
        assertEquals(c.getTipoConexao(), "CaboModen");
        assertEquals(c.getEnderecoRede(), "172.16.0.0");
        assertEquals(c.getHora(), hora);
        assertEquals(c.getData(), data);
        assertEquals(c.getStatus(), status);
        assertEquals(c.getTipoProblema(), tipoProblema);
    }

    @Test
    public void criarChamadoProblemBancoDados() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        assertEquals(c.getTitulo(), "Chamado1");
        assertEquals(c.getDescricao(), "TesteChamado1");
        assertEquals(c.getPrioridade(), 10);
        assertEquals(c.getTecnico(), tec);
        assertEquals(c.getCliente(), ce);
        assertEquals(c.getSistemaOperacional(), "LINUX");
        assertEquals(c.getVersaoSO(), "Ubuntu 16");
        assertEquals(c.getHora(), hora);
        assertEquals(c.getData(), data);
        assertEquals(c.getTipoProblema(), tipoProblema);
        assertEquals(c.getStatus(), status);
        assertEquals(c.getBancoDeDados(), "SqlServer");

    }

    @Test
    public void criarChamadoProblemaDesempenho() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        assertEquals(c.getTitulo(), "Chamado1");
        assertEquals(c.getDescricao(), "TesteChamado1");
        assertEquals(c.getPrioridade(), 10);
        assertEquals(c.getTecnico(), tec);
        assertEquals(c.getCliente(), ce);
        assertEquals(c.getSistemaOperacional(), "LINUX");
        assertEquals(c.getVersaoSO(), "Ubuntu 16");
        assertEquals(c.getHora(), hora);
        assertEquals(c.getData(), data);
        assertEquals(c.getTipoProblema(), tipoProblema);
        assertEquals(c.getStatus(), status);
        assertEquals(c.getOperacao(), op);
        assertEquals(c.getDuracaoOperacao(), tempoOperacao, 0);
    }

    /*-----TESTES DE INICIALIZACAO INVALIDA-----*/
 /*Teste de Inicialização Invalido - Problema de Rede*/
    @Test(expected = Exception.class)
    public void criarProblemaRedeCodigoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado(-123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeTituloInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeDescricaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeTecnicoInvalido() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeClienteInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeSistemaOperacionalInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeVersaoSOInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeTipoConexaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", null, "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void criarProblemaRedeEnderecoRede() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", null);
    }

    /*Teste de Inicialização Invalido - Problema de Banco de Dados*/
    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosTituloInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado(null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosDescricaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosTecnicoInvalido() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosClieteEmpresaInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosSistemaOperacionalInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", "SqlServer");

    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosVersaoSOInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, "SqlServer");
    }

    @Test(expected = Exception.class)
    public void criarProblemaBancoDadosInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", null);
    }

    /*Teste de Inicialização Invalido - Problema de Desempenho*/
    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoTituloInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado(null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoDescricaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoTecnicoInvalido() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoClienteEmpresaInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoSistemaOperacionalInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoVersaoSOInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoOperacaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = null;
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    @Test(expected = Exception.class)
    public void criarProblemaDesempenhoTempoOperacaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = -5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);

    }

    /*-----FIM TESTES DE INICIALIZACAO INVALIDA-----*/

 /*-----TESTES DE ALTERAÇÃO-----*/
 /*Teste Alteração - Problema Rede*/
    @Test
    public void alterarChamadoProblemaRedeCodigo() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        ce.setCodigo(321);
        assertEquals(ce.getCodigo(), (Integer) 321);
    }

    @Test
    public void alterarChamadoProblemaRedeTitulo() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setTitulo("Chamado2");
        assertEquals(c.getTitulo(), "Chamado2");
    }

    @Test
    public void alterarChamadoProblemaRedeDescricao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setDescricao("TesteChamado2");
        assertEquals(c.getDescricao(), "Chamado2");

    }

    @Test
    public void alterarChamadoProblemaRedePrioridade() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setPrioridade(100);
        assertEquals(c.getPrioridade(), 100);

    }

    @Test
    public void alterarChamadoProblemaRedeTecnico() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Tecnico tec2 = new Tecnico("Kenji", 87654321);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setTecnico(tec2);
        assertEquals(c.getTecnico(), tec2);

    }

    @Test
    public void alterarChamadoProblemaRedeCliente() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        ClienteEmpresa ce2 = new ClienteEmpresa(1234, e, 22222222222L, "Kenji", 87654321);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setCliente(ce2);
        assertEquals(c.getCliente(), ce2);
    }

    @Test
    public void alterarChamadoProblemaRedeSistemaOperacional() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setSistemaOperacional("Windows");
        assertEquals(c.getSistemaOperacional(), "Windows");

    }

    @Test
    public void alterarChamadoProblemaRedeSOVersao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setVersaoSO("XP");
        assertEquals(c.getVersaoSO(), "XP");
    }

    @Test
    public void alterarChamadoProblemaRedeTipoConexao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setTipoConexao("Radio");
        assertEquals(c.getTipoConexao(), "Radio");

    }

    @Test
    public void alterarChamadoProblemaRedeEnderecoRede() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";

        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        c.setEnderecoRede("255.255.0.0");
        assertEquals(c.getEnderecoRede(), "255.255.0.0");
    }

    /*Testes de Alteracao - Banco de Dados*/
    @Test
    public void alterarChamadoProblemBancoDadosTitulo() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setTitulo("Chamado2");
        assertEquals(c.getTitulo(), "Chamado2");
    }

    @Test
    public void alterarChamadoProblemBancoDadosDescricao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setDescricao("TesteChamado2");
        assertEquals(c.getDescricao(), "TesteChamado2");

    }

    @Test
    public void alterarChamadoProblemBancoDadosPrioridade() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setPrioridade(100);
        assertEquals(c.getPrioridade(), 100);

    }

    @Test
    public void alterarChamadoProblemBancoDadosTecnico() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Tecnico tec2 = new Tecnico("Heitor2", 87654321);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setTecnico(tec2);
        assertEquals(c.getTecnico(), tec2);

    }

    @Test
    public void alterarChamadoProblemBancoDadosCliente() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        ClienteEmpresa ce2 = new ClienteEmpresa(1234, e, 22222222222L, "Kenji", 87654321);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setCliente(ce2);
        assertEquals(c.getCliente(), ce2);

    }

    @Test
    public void alterarChamadoProblemBancoDadosSistemaOperacional() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setSistemaOperacional("Windows");
        assertEquals(c.getSistemaOperacional(), "Windows");

    }

    @Test
    public void alterarChamadoProblemBancoDadosVersaoSO() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setVersaoSO("XP");
        assertEquals(c.getVersaoSO(), "XP");

    }

    @Test
    public void alterarChamadoProblemBancoDados() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
        c.setBancoDeDados("Oracle");
        assertEquals(c.getBancoDeDados(), "Oracle");

    }

    /*Testes de Alteracao - Problema de Desempenho*/
    @Test
    public void alterarChamadoProblemaDesempenhoTitulo() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        c.setTitulo("Chamado2");
        assertEquals(c.getTitulo(), "Chamado2");
    }

    @Test
    public void alterarChamadoProblemaDesempenhoDescricao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        c.setDescricao("TesteChamado2");
        assertEquals(c.getDescricao(), "TesteChamado2");

    }

    @Test
    public void alterarChamadoProblemaDesempenhoPrioridade() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 100, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        c.setPrioridade(100);
        assertEquals(c.getPrioridade(), 100);

    }

    @Test
    public void alterarChamadoProblemaDesempenhoTecnico() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Tecnico tec2 = new Tecnico("Heitor2", 87654321);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        c.setTecnico(tec2);
        assertEquals(c.getTecnico(), tec2);

    }

    @Test
    public void alterarChamadoProblemaDesempenhoClienteEmpresa() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        ClienteEmpresa ce2 = new ClienteEmpresa(1234, e, 22222222222L, "Heitor2", 123456789);

        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        c.setCliente(ce2);
        assertEquals(c.getCliente(), ce2);

    }

    @Test
    public void alterarChamadoProblemaDesempenhoSO() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "Windows", "Ubuntu 16", op, tempoOperacao);
        assertEquals(c.getSistemaOperacional(), "Windows");

    }

    @Test
    public void alterarChamadoProblemaDesempenhoVersao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 15", op, tempoOperacao);
        assertEquals(c.getVersaoSO(), "Ubuntu 15");

    }

    @Test
    public void alterarChamadoProblemaDesempenhoOperacao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "exclusao";
        double tempoOperacao = 5.25;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        assertEquals(c.getOperacao(), op);

    }

    @Test
    public void alterarChamadoProblemaDesempenhoTempoOperacao() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 6;

        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
        assertEquals(c.getDuracaoOperacao(), tempoOperacao);

    }

    /*-----FIM TESTES DE ALTERACAO-----*/

 /*-----ALTERAÇÕES INVALIDAS-----*/
 /*-----REDE-----*/
    @Test(expected = Exception.class)
    public void alterarChamadoRedeTituloNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeDescricaoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeTecNull() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeClienteEmpresaNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeVersaoSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, "CaboModen", "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeTipoConexaoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", null, "172.16.0.0");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoRedeEnderecoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", null);
    }

    /*-----BANCO DE DADOS------*/
    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosTituloNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado(null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");
    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosDescricaoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");

    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosTecNull() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");

    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosClienteEmpresaNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");

    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", "SqlServer");

    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosVersaoSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, "SqlServer");

    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemBancoDadosTipoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", null);

    }

    /*----DESEMPENHO-----*/
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoTituloNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado(null, "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }

    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoDescricaoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", null, 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoTecInvalido() throws Exception {
        Tecnico tec = null;
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoClienteEmpresaInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = null;
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, null, "Ubuntu 16", op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoVersaoSONull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", null, op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoOperacaoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = null;
        double tempoOperacao = 5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }
    
    @Test(expected = Exception.class)
    public void alterarChamadoProblemaDesempenhoDuracaoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Desempenho";
        String op = "cadastro";
        double tempoOperacao = -5.25;
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", op, tempoOperacao);
    }
    /*-----FIM ALTERAÇÕES INVALIDAS-----*/
}
