package br.com.drogaria.main;

import br.com.drogaria.util.HibernateUtil;

/**
 *
 * @author stryker
 */
public class GeraTabela {

    public static void main(String[] args){
         HibernateUtil.getSessionFactory();
         HibernateUtil.getSessionFactory().close();
    }
}
