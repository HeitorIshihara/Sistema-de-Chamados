/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.text.DateFormat;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class RegistroChamadoTest {

    /*Testes de Criacao*/
    @Test
    public void criarRegistroChamadoRede() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());

        assertEquals(rc.getAssunto(), "Assunto");
        assertEquals(rc.getTecnico(), c.getTecnico());
    }

    @Test
    public void criarRegistroChamadoBancoDados() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Banco de Dados";
        Chamado c = new Chamado("Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "SqlServer");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        assertEquals(rc.getAssunto(), "Assunto");
        assertEquals(rc.getTecnico(), c.getTecnico());
    }

    @Test
    public void criarRegistroChamadoDesempenho() {
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

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());

        assertEquals(rc.getAssunto(), "Assunto");
        assertEquals(rc.getTecnico(), c.getTecnico());
    }

    /*-----Testes de Criacao Invalido-----*/
    @Test(expected = Exception.class)
    public void criarRegistroChamadoAssuntoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado(null, c, c.getTecnico());

    }
    
    @Test(expected = Exception.class)
    public void criarRegistroChamadoChamadoNull() throws Exception {
        Chamado c = null;

        RegistroChamado rc = new RegistroChamado("Assunto", null, c.getTecnico());

    }
    
    @Test(expected = Exception.class)
    public void criarRegistroChamadoTecnicoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, null);

    }

    /*-----Testes de Alteração-----*/
    @Test
    public void alterarRegistroChamadoAssunto() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setAssunto("Assunto2");
        assertEquals(rc.getAssunto(), "Assunto2");
    }

    @Test
    public void alterarRegistroChamadoChamado() {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");
        Chamado c2 = new Chamado((Integer) 123, "Chamado2", "TesteChamado2", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setChamado(c2);
        assertEquals(rc.getChamado(), c2);
    }

    @Test
    public void alterarRegistroChamadoTecnico() {
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

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setTecnico(tec2);
        assertEquals(rc.getTecnico(), tec2);
    }

    /*-----Testes de Alteração Invalida-----*/
    @Test(expected = Exception.class)
    public void alterarRegistroChamadoAssuntoNull() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setAssunto(null);
    }

    @Test(expected = Exception.class)
    public void alterarRegistroChamadoNull() throws Exception {
        Chamado c = null;

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setChamado(c);
    }

    @Test(expected = Exception.class)
    public void alterarRegistroChamadoTecnicoInvalido() throws Exception {
        Tecnico tec = new Tecnico("Heitor", 12345678);
        Empresa e = new Empresa(123, "Mackenzie");
        ClienteEmpresa ce = new ClienteEmpresa(123, e, 11111111111L, "Heitor", 12345678);
        Calendar cal = Calendar.getInstance();
        String hora = DateFormat.getTimeInstance().format(cal.getTime());
        String data = DateFormat.getDateInstance().format(cal.getTime());
        String status = "Iniciado";
        String tipoProblema = "Problema de Rede";
        Chamado c = new Chamado((Integer) 123, "Chamado1", "TesteChamado1", 10, tec, ce, "LINUX", "Ubuntu 16", "CaboModen", "172.16.0.0");

        RegistroChamado rc = new RegistroChamado("Assunto", c, c.getTecnico());
        rc.setTecnico(null);
    }

}
