/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ClienteEmpresaTest {

    /*Testes de Inicializacao*/
    @Test
    public void criarClienteEmpresa() {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        assertEquals(ce.getCodigo(), (Integer) 123);
        assertEquals(ce.getEmpresa(), em);
        assertEquals(ce.getCpf(), 11111111111L);
        assertEquals(ce.getNome(), p.getNome());
        assertEquals(ce.getTelefone(), p.getTelefone());
    }

    @Test(expected = Exception.class)
    public void criarCodigoInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(-123, em, 11111111111L, p.getNome(), p.getTelefone());
    }

    @Test(expected = Exception.class)
    public void criarEmpresaNull() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = null;

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());
    }

    @Test(expected = Exception.class)
    public void criarCpfInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, -11111111111L, p.getNome(), p.getTelefone());
    }

    @Test(expected = Exception.class)
    public void criarNomeNull() throws Exception {
        Pessoa p = new Pessoa(null, 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());
    }

    @Test(expected = Exception.class)
    public void criarTelefoneInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", -12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());
    }

    /*Testes de Alteração*/
    @Test
    public void alterarCodigo() {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setCodigo(321);
        assertEquals(ce.getCodigo(), (Integer) 321);
    }

    @Test
    public void alterarCPF() {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setCpf(22222222222L);
        assertEquals(ce.getCpf(), 22222222222L);
    }

    @Test
    public void alterarNome() {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setNome("Kenji");
        assertEquals(ce.getNome(), "Kenji");
    }

    @Test
    public void alterarTel() {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setTelefone(87654321);
        assertEquals(ce.getTelefone(), 87654321);
    }

    /*Teste de Alteração Invalido*/
    @Test(expected = Exception.class)
    public void alterarCodigoInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setCodigo(-123);
    }

    @Test(expected = Exception.class)
    public void alterarCPFInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setCpf(-11111111111L);
    }

    @Test(expected = Exception.class)
    public void alterarNomeNull() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setNome(null);
    }

    @Test(expected = Exception.class)
    public void alterarTelInvalido() throws Exception {
        Pessoa p = new Pessoa("Heitor", 12345678);
        Empresa em = new Empresa(12345, "Mackenzie");

        ClienteEmpresa ce = new ClienteEmpresa(123, em, 11111111111L, p.getNome(), p.getTelefone());

        ce.setTelefone(-12345678);
    }
}
