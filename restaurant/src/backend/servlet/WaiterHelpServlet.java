package backend.servlet;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Swing.MangerBoardMenu;
import backend.DbSessionManager;
import backend.entities.Category;
import backend.entities.WaiterHelp;


//http://localhost:8080/yaakovRestaurant/rs/WaiterHelp
@Path("WaiterHelp")
public class WaiterHelpServlet {
	
//	@POST
//	public void payBill(@QueryParam("tableNumber") int tableNumber )
//		
//	{
//		saveWaiterHelp(tableNumber);
//
//        
//        updateWaiterHelpButton();
//        
//     //   return true;
//		//code to send to manager app and watier.
//	}
	
	//http://localhost:8080/yaakovRestaurant/rs/WaiterHelp?tableNumber=14
	@POST
	public void saveWaiterHelp(@QueryParam("tableNumber") int tableNumber) {
		System.out.println("Table number: "+tableNumber+" requested help");
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        WaiterHelp waiterhelp= new WaiterHelp();
        waiterhelp.setTableNumber(tableNumber);
        LocalDateTime localDateTime= LocalDateTime.now().withSecond(0).withNano(0);
        waiterhelp.setTime(localDateTime.toLocalTime().toString() );
	    session.beginTransaction();
	    session.save(waiterhelp);
	    session.getTransaction().commit();
		
	}

	private void updateWaiterHelpButton() {
		System.out.println("inside updateWaiterHelpButton");
		MangerBoardMenu window = MangerBoardMenu.getInstance();
//		System.out.println("window.getButtonHelp() from servlet"+window.getButtonHelp().hashCode());
//		window.getButtonHelp().setLabel("from servlet");
	//	MangerBoardMenu.getButtonHelp().setLabel("help (+"+getAllWaiterHelpData().size()+")");
	//	MangerBoardMenu.
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
