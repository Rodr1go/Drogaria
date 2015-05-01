package br.com.drogaria.dao;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author stryker
 */
public class ProdutoDAO {
   public void salvar(Produto produto){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
       Transaction transacao = null;
       
       try{
         transacao = sessao.beginTransaction();
         sessao.save(produto);
         transacao.commit();
       }catch(RuntimeException ex){
           if(transacao != null){
             transacao.rollback();
           }
           throw ex;
       }finally{
           sessao.close();
       }
   }
   
   public List<Produto> listar(){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
       List<Produto> produtos = null;
       
       try{
         Query consulta = sessao.getNamedQuery("Produto.listar");
         produtos = consulta.list();
       }catch(RuntimeException ex){
           throw ex;
       }finally{
           sessao.close();
       }
      return produtos;
   }
   
   public Produto buscarPorCodigo(long codigo){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
       Produto produto = null;
       
       try{
         Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
         consulta.setLong("codigo", codigo);
         
         produto = (Produto) consulta.uniqueResult();
       }catch(RuntimeException ex){
           throw ex;
       }finally{
           sessao.close();
       }
      return produto;
   }
   
   public void excluir(Produto produto){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
       Transaction transacao = null;
       
       try{
         transacao = sessao.beginTransaction();
         sessao.delete(produto);
         transacao.commit();
       }catch(RuntimeException ex){
           if(transacao != null){
             transacao.rollback();
           }
           throw ex;
       }finally{
           sessao.close();
       }
   }
   
   public void editar(Produto produto){
       Session sessao = HibernateUtil.getSessionFactory().openSession();
       Transaction transacao = null;
       
       try{
         transacao = sessao.beginTransaction();
         sessao.update(produto);
         transacao.commit();
       }catch(RuntimeException ex){
           if(transacao != null){
             transacao.rollback();
           }
           throw ex;
       }finally{
           sessao.close();
       }
   }
}
