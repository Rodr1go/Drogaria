package br.com.drogaria.test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author stryker
 */
public class FuncionarioDAOTest {
    
    @Test
    @Ignore
    public void salvar(){
        Funcionario func1 = new Funcionario();
        
        func1.setNome("FUNCIONARIO C");
        func1.setCpf("222.222.222.22");
        func1.setSenha("qjc3fu7");
        func1.setFuncao("Auxiliar de escritório");
        
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.salvar(func1);
    }
    
    @Test
    @Ignore
    public void listar(){
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> funcionarios = dao.listar();
        System.out.println(funcionarios);
    }
    
    @Test
    @Ignore
    public void buscaPorCodigo(){
       FuncionarioDAO dao = new FuncionarioDAO();
       Funcionario func1 = dao.buscarPorCodigo(2L);
        System.out.println(func1);
    }
    
    @Test
    @Ignore
    public void excluir(){
       FuncionarioDAO dao = new FuncionarioDAO();
       Funcionario func1 = dao.buscarPorCodigo(1L);
       dao.excluir(func1);
    }
    
    @Test
    @Ignore
    public void editar(){
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario func1 = dao.buscarPorCodigo(4L);
        func1.setFuncao("secretário");
        dao.editar(func1);
    }
}
