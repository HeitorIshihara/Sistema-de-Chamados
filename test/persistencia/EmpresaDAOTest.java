/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Persistencia.EmpresaDAO;
import entidade.Empresa;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

/**
 *
 * @author Heitor Ishihara
 */
public class EmpresaDAOTest {

    @Test
    public void inserirEmpresaTest() {
        Empresa novaEmpresa = new Empresa(123, "Mackenzie");
        EmpresaDAO empresadao = new EmpresaDAO();
        empresadao.put(novaEmpresa);

        Collection<Empresa> empresas = empresadao.getEmpresas();
        Empresa inserida = null;
        for (Empresa empresa : empresas) {
            if ((novaEmpresa.getNomeEmpresa().equals(empresa.getNomeEmpresa())) && (novaEmpresa.getNumeroContrato() == empresa.getNumeroContrato())) {
                assertEquals(empresa, novaEmpresa);
            }
        }
    }

    @Test(expected = Exception.class)
    public void inserirEmpresaNullTest() throws Exception {
        Empresa novaEmpresa = null;
        EmpresaDAO empresadao = new EmpresaDAO();
        empresadao.put(novaEmpresa);
    }

    @Test
    public void voltaEmpresaTest() {
        EmpresaDAO empresadao = new EmpresaDAO();
        assertTrue(empresadao.voltaEmpresa().size() > 0);
    }
}
