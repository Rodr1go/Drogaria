package br.com.drogaria.test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author stryker
 */
public class FabricanteDAOTest {
  @Test
  @Ignore
  public void salvar(){
      Fabricante f1 = new Fabricante();
      f1.setDescricao("DESCRICAO A");
      
      Fabricante f2 = new Fabricante();
      f2.setDescricao("DESCRICAO B");
      
      FabricanteDAO dao = new FabricanteDAO();
      dao.salvar(f1);
      dao.salvar(f2);
  } 
  
  @Test
  @Ignore
  public void listar(){
      FabricanteDAO dao = new FabricanteDAO();
      List<Fabricante> fabricantes = dao.listar();
  
      for(Fabricante fabricante : fabricantes){
          System.out.println(fabricante);
      }
  }
  
  @Test
  @Ignore
  public void buscarPorCodigo(){
      FabricanteDAO dao = new FabricanteDAO();
      
      Fabricante f1 = dao.buscarPorCodigo(4L);
      System.out.println(f1);
  }
  
  @Test
  @Ignore
  public void excluir(){
      
       FabricanteDAO dao = new FabricanteDAO();
       Fabricante fabricante = dao.buscarPorCodigo(7L);
       dao.excluir(fabricante);
  }
  
  @Test
  @Ignore
  public void editar(){
      FabricanteDAO dao = new FabricanteDAO();
       Fabricante fabricante = dao.buscarPorCodigo(37L);
       fabricante.setDescricao("DESCRICAOX");
       dao.editar(fabricante);
  } 
}
