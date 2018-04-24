package backend.servlet;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.hibernate.Session;
import org.hibernate.query.Query;

import backend.DbSessionManager;
import backend.entities.Category;
import backend.entities.WaiterHelp;

@Path("WaiterHelpServlet")
public class WaiterHelpServlet {
	
	@POST
	public void payBill(@QueryParam("tableNumber") int tableNumber )
		
	{
		//code to send to manager app and watier.
	}
	
	public List<WaiterHelp> getAllWaiterHelpData()
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        
       
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(WaiterHelp.class);
        Root<WaiterHelp> root = criteria.from(WaiterHelp.class);
        Query query = session.createQuery(criteria);

        List<WaiterHelp> allWaiterHelp = query.getResultList();
 
  
		return allWaiterHelp;
	}
	public static void deleteWaiterHelp(WaiterHelp waiterHelp)
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        session.beginTransaction();
//       
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(WaiterHelp.class);
//        Root<WaiterHelp> root = criteria.from(WaiterHelp.class);
//        Query query = session.createQuery(criteria);
        session.delete(waiterHelp);
        session.getTransaction().commit();

        
	}
	

}
