package backend.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.query.Query;

import backend.DbSessionManager;
import backend.entities.Category;
import backend.entities.Dish;

//http://localhost:8080/yaakovRestaurant/rs/HomePage
@Path("HomePage")
public class HomePageServlet{
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<String> getAllCategories()
	{
		ArrayList<String> allCategorys= new ArrayList();
 		ArrayList <Dish> allDishes=(ArrayList)DishServlet.getAllDishes();
		for(Dish dish: allDishes)
		{
			if(!allCategorys.contains(dish.getCategory()))
			{
				allCategorys.add(dish.getCategory());
		
			}
			
		}
		return allCategorys;
		
//		DbSessionManager sessionManager = new DbSessionManager();
//        Session session = sessionManager.getSessionFactoryInstance().openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
//        Root<Category> root = criteria.from(Category.class);
//        criteria.select( root );
//        Query query = session.createQuery(criteria);
//        List<Category> categories = query.getResultList(); //a list of all categorys.=
//       String allCategories="";
//       
//        for(Category category: categories )
//        {
//       allCategories+= category.getCategory()+" ";	
//        }
//        session.close();
//		return allCategories;
	}
	
	
	
//	
	@POST
	public void waiterComeHelp(@QueryParam("tableNumber") int tableNumber)
	{
		System.out.println("Table number: "+tableNumber+" requested help");
		
		
		//send to manger app the request

	//	return allCategories;
	}
	

}
