package backend.servlet;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.hibernate.Session;
import org.hibernate.query.Query;

import backend.DbSessionManager;
import backend.entities.Check;
import backend.entities.Order;
import backend.entities.WaiterHelp;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.POST;

//http://localhost:8080/yaakovRestaurant/rs/check
@Path("check")
public class CheckServlet {
	
	
	@POST
	public void payBill(@QueryParam("tableNumber") int tableNumber, @QueryParam("order") Order orderParam  )
		
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        Check check= new Check();
        Order order= orderParam;
        
       ///check.setOrder(order);
        LocalDateTime localDateTime= LocalDateTime.now().withSecond(0).withNano(0); 
        check.setTime(localDateTime.toLocalTime().toString());
        
	    session.beginTransaction();
	    session.save(check);
	    session.getTransaction().commit();
		//code to send to manager app and watier.
	}
	
	public static List<Check> getAllChecks()
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        
       
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Check.class);
        Root<Check> root = criteria.from(Check.class);
        Query query = session.createQuery(criteria);

        List<Check> allCheck = query.getResultList();
 
  
		return allCheck;
	}
	
	public static void deleteCheck( Check check)
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        session.beginTransaction();
        session.delete(check);
        session.getTransaction().commit();
	}
	
	

}
