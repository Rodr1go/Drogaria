package br.com.drogaria.test;

import br.com.drogaria.util.HibernateUtil;
import org.junit.Test;

/**
 *
 * @author stryker
 */
public class GerarTabelasTest {
    @Test
   public void gerar(){
       HibernateUtil.getSessionFactory();
       HibernateUtil.getSessionFactory().close();
   }    
}
