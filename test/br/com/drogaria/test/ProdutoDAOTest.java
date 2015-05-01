package br.com.drogaria.test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author stryker
 */
public class ProdutoDAOTest {
    @Test
    @Ignore
    public void salvar(){
        FabricanteDAO fabricanteDAO = new FabricanteDAO();
        Fabricante fabricante = fabricanteDAO.buscarPorCodigo(3L);
        
        Produto produto = new Produto();
        produto.setDescricao("DESCRICAOZ");
        produto.setPreco(new BigDecimal(17.63D));
        produto.setQuantidade(10);
        produto.setFabricante(fabricante);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto);
    }
    
    @Test
    @Ignore
    public void buscarPorCodigo(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        Produto produto = produtoDAO.buscarPorCodigo(2L);
        System.out.println(produto);
    }
    
    @Test
    @Ignore
    public void listar(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();
        System.out.println(produtos);
    }
    
    @Test
    @Ignore
    public void excluir(){
        ProdutoDAO prodrutoDAO = new ProdutoDAO();
        Produto produto = prodrutoDAO.buscarPorCodigo(1L);
        prodrutoDAO.excluir(produto);
    }
    
    @Test
    @Ignore
    public void editar(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarPorCodigo(2L);
        
        produto.setDescricao("DESCRICAOA");
        produto.setPreco(new BigDecimal(6.37D));
        produto.setQuantidade(9);
        
        FabricanteDAO fabricanteDAO = new FabricanteDAO();
        Fabricante fabricante = fabricanteDAO.buscarPorCodigo(2L);
        produto.setFabricante(fabricante);
        
        produtoDAO.editar(produto);
    }
}
