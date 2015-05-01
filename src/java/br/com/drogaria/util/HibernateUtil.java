
package br.com.drogaria.util;

/**
 *
 * @author stryker
 */

//import javax.imageio.spi.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
         
        //########### código padrão (COM ERRO)#############
            //return new Configuration().configure().buildSessionFactory(
		//	    new StandardServiceRegistryBuilder().build() ); 
        //-------------------------------------------------------    
            
        // Cria um SessionFactory a partir do hibernate.cfg.xml
        //************* (NOVA CONFIGURAÇÃO)***********************
            Configuration configuration = new Configuration();
            configuration.configure();
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                             .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            return sessionFactory;
        //-------------------------------------------------------*/
                
        } catch (Throwable ex) {
            // Exibe uma mensagem de erro
            System.err.println("Falha ao tentar criar um SesscionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}


