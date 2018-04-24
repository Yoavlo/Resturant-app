package backend;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbSessionManager {
    private static SessionFactory sessionFactory;

    public DbSessionManager(){
        setupSession();
    }

    public void setupSession(){
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() //StandardServiceRegistry= Ã—Â©Ã—â€¢Ã—Å“Ã—Ëœ Ã—Â¢Ã—Å“ Ã—â€ºÃ—Å“ Ã—â€�Ã—â€œÃ—â€˜Ã—Â¨Ã—â„¢Ã—ï¿½ Ã—Å¾Ã—â€¢Ã—Å“ Ã—â€�DB
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory(); //sessionFactory== Ã—Å¾Ã—â„¢Ã—â„¢Ã—Â¦Ã—Â¨ Ã—ï¿½Ã—Âª Ã—â€�Ã—â€”Ã—â„¢Ã—â€˜Ã—â€¢Ã—Â¨ Ã—Å“DB
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
            throw new ExceptionInInitializerError(e);
        }
    }

    public void tearDownSession() throws Exception {  //Ã—Â¤Ã—â€¢Ã—Â Ã—Â§Ã—Â¦Ã—â„¢Ã—â€� Ã—â€“Ã—â€¢ Ã—Â¢Ã—â€¢Ã—â€˜Ã—â€œÃ—Âª Ã—â€ºÃ—ï¿½Ã—Â©Ã—Â¨ Ã—â„¢Ã—â€¢Ã—Â¦Ã—ï¿½Ã—â„¢Ã—ï¿½ Ã—Å¾Ã—â€�Ã—ï¿½Ã—Â¤Ã—Å“Ã—â„¢Ã—Â§Ã—Â¦Ã—â„¢Ã—â€�. Ã—â€�Ã—â€”Ã—â„¢Ã—â€˜Ã—â€¢Ã—Â¨ Ã—Å“db Ã—Â Ã—Â¡Ã—â€™Ã—Â¨
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactoryInstance(){
        return sessionFactory;
    }


}
