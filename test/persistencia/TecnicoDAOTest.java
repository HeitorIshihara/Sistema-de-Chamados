/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Tecnico;
import Persistencia.TecnicoDAO;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heitor Ishihara
 */
public class TecnicoDAOTest {

    @Test
    public void persistirTecnicoTest() {
        Tecnico novoTecnico = new Tecnico("heitor", 12345678);
        TecnicoDAO tecnicodao = new TecnicoDAO();
        tecnicodao.put(novoTecnico);
        Tecnico tecnicoBanco = tecnicodao.get(tecnicodao.gerarCodigo() - 1);
        assertEquals(novoTecnico.getTelefone(), tecnicoBanco.getTelefone());
        assertEquals(novoTecnico.getNome(), tecnicoBanco.getNome());
    }

    @Test(expected = Exception.class)
    public void persistirTecnicoNullTest() throws Exception {
        Tecnico novoTecnico = null;
        TecnicoDAO tecnicodao = new TecnicoDAO();
        tecnicodao.put(novoTecnico);
    }

    @Test
    public void gerarCodigoTest() {
        TecnicoDAO tecdao = new TecnicoDAO();
        int codigo = tecdao.gerarCodigo();
        assertTrue(codigo > 0);
    }

    @Test
    public void voltaCashTecnicoTest() {
        Tecnico tecnico = new Tecnico("Heitor", 12345678);
        TecnicoDAO tecnicodao = new TecnicoDAO();
        HashMap<Integer, Tecnico> tecnicos;
        assertTrue(tecnicodao.voltaCashTecnico().size() > 0);
    }

}
