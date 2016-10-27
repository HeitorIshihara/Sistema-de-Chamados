/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import controle.ControleEmpresas;
import controle.ControleEmpresas;
import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ControleEmpresasTest {
    
    @Test
    public void retornaTest(){
     ControleEmpresas ce = new ControleEmpresas();
     Empresa empresa = new Empresa(2,"JJBenites");
     
     Empresa e = ce.retorna(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
     assertEquals(empresa.getNomeEmpresa(), e.getNomeEmpresa());
     assertEquals(empresa.getNumeroContrato(),e.getNumeroContrato());
    }
    
    @Test (expected = Exception.class)
    public void nmrInvalidoNoretornaTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(-123, "Allianz");
    }
    
    @Test (expected = Exception.class)
    public void nomeNullNoretornaTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(123, null);
    }
    
    @Test
    public void retornaNullTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = ce.retorna(123, "empresa que não existe");
        assertNull(e);
    }
    
    @Test
    public void inserirEmpresaInexistenteTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(2,"JJBenites");
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        
        assertNotNull(e);
        assertSame(empresa.getNumeroContrato(), e.getNumeroContrato());
        assertEquals(empresa.getNomeEmpresa(),e.getNomeEmpresa());
        
    }
    
    @Test
    public void inserirEmpresaExistenteTest(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(2,"JJBenites");
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        Empresa e2 = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        
        assertNull(e2); /*Como uma empresa de mesmo nome e nºcontrato (e) foi inserida anteriormente,
                          o retorno do método inserir deve ser nulo, caso não seja, o teste falhará.
                         */
    }
    
    @Test (expected = Exception.class)
    public void contratoInvalidonoInserir() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(-30,"JJBenites");
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
    }
    
    @Test (expected = Exception.class)
    public void nomeInvalidonoInserir() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(30,null);
        
        Empresa e = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
    }
    
    
    @Test
    public void validarContratoeNomeExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(300, "SBT");
        int valida = ce.validar(300, "SBT");
        assertEquals(1,valida);  
    }
    
    @Test
    public void validarNomeExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(300, "SBT");
        int valida = ce.validar(967, "SBT");
        assertEquals(2,valida);  
    }
    
    @Test
    public void validarContratoExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(300, "SBT");
        int valida = ce.validar(300, "Globo");
        assertEquals(3,valida);  
    }
    
    @Test
    public void validarNenhumAtributoExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        ce.inserir(300, "SBT");
        int valida = ce.validar(967, "Globo");
        assertEquals(4,valida);  
    }
    
    @Test (expected = Exception.class)
    public void contratoInvalidoNoValidarTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        int valida = ce.validar(-891, "Extra");
    }
    
    @Test (expected = Exception.class)
    public void empresaNullNoValidarTest() throws Exception{
        ControleEmpresas ce = new ControleEmpresas();
        int valida = ce.validar(-891, null);
    }
    
    @Test
    public void checarEmpresaExistente(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa empresa = new Empresa(2,"JJBenites");
        Empresa emp = ce.inserir(empresa.getNumeroContrato(), empresa.getNomeEmpresa());
        boolean e = ce.checar(emp.getNumeroContrato(), emp.getNomeEmpresa());
        assertTrue(e); //A empresa foi inserida, então checar tem que dar True
    }
    
    @Test
    public void checarEmpresaInexistente(){
        ControleEmpresas ce = new ControleEmpresas();
        Empresa emp = new Empresa(54,"MM");
        boolean e = ce.checar(emp.getNumeroContrato(), emp.getNomeEmpresa());
        assertFalse(e); //A empresa não foi inserida, então checar tem que dar Falso
    }
    
    @Test (expected = Exception.class)
    public void contratoInvalidonoChecar() throws Exception{
         ControleEmpresas ce = new ControleEmpresas();
        Empresa emp = new Empresa(-234,"JJBenites");
        boolean e = ce.checar(emp.getNumeroContrato(), emp.getNomeEmpresa());
    }
    
    @Test (expected = Exception.class)
    public void nomeNullnoChecar() throws Exception{
         ControleEmpresas ce = new ControleEmpresas();
        Empresa emp = new Empresa(256,null);
        boolean e = ce.checar(emp.getNumeroContrato(), emp.getNomeEmpresa());
    }
    
}
