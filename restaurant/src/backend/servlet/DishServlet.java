package backend.servlet;

import javax.ws.rs.Path;

import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.query.Query;



import backend.DbSessionManager;
import backend.entities.Dish;
import backend.entities.Order;
import backend.entities.WaiterHelp;





//http://localhost:8080/yaakovRestaurant/rs/dish
@Path("dish")
public class DishServlet {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allDishesOrderByCategory()
	{
		System.out.println("INSIDE allDishes()");
		
		return Response.ok(getAllDishes()).build();
		
	}
	/*
	http://localhost:8080/yaakovRestaurant/rs/dish?idCategory=1
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllDishsInCategory(@QueryParam("idCategory") int idCategory)
	{
		//SELECT * FROM DISH where idcategory=idCategory;
		DbSessionManager sessionManager = new DbSessionManager();
		Session session = sessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery <Dish> criteria= builder.createQuery(Dish.class);
        Root<Dish> root= criteria.from(Dish.class);
        
        criteria.where(builder.equal(root.get("idCategory"), idCategory));
        Query query = session.createQuery(criteria);
        List<Dish> allDishes = query.getResultList();
    //    Gson gson = new Gson();
        
        session.close();

		return gson.toJson(allDishes).toString(); //without the gson. the method will return the location in the memory.
	}
	*/
	
	@POST
	//@Consumes
	public void saveOrderInDB (@QueryParam("comment") String comment,
								@QueryParam("tableNumber") int tableNumber,
								@QueryParam("order") String orderString)
//	public void saveOrderInDB (@QueryParam("jsonOrder") String orderRequest)
	{
	
		   Order order= new Order();
		   order.setComment("this is a order from main");
		   order.setOrderDishes("1 pizza 2 water");
		   order.setPrice(10);
		   order.setTableNumber(12);
		   order.setTime("now");
		   
			DbSessionManager sessionManager = new DbSessionManager();
	     Session session = sessionManager.getSessionFactoryInstance().openSession();
	     session.beginTransaction();
	     session.save(order);
	     session.getTransaction().commit();
		
	}
	
	public static Order getOrderById(int id)
	{
		DbSessionManager sessionManager = new DbSessionManager();
		Session session = sessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery <Order> criteria= builder.createQuery(Order.class);
        Root<Order> root= criteria.from(Order.class);
        
        criteria.where(builder.equal(root.get("idOrder"), id));
        Query query = session.createQuery(criteria);
        List<Order> allOrder = query.getResultList();
        return allOrder.get(0);
        
	}
	

	public static  List<Dish> getAllDishes()
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        
       
        CriteriaBuilder builder = session.getCriteriaBuilder();
      
        CriteriaQuery criteria = builder.createQuery(Dish.class);
        Root<Dish> root = criteria.from(Dish.class);
        criteria.orderBy(     builder.desc(root.get("category")));
        Query query = session.createQuery(criteria);
        
        
 
     //   System.out.println("getAllDishes" );
        
      //  criteria.orderBy(builder.asc(root.get(Dish.)))
      
        
        List<Dish> allDishes = query.getResultList();
       // System.out.println("getAllDishes" +allWaiterHelp.size());
        
  
		return allDishes;
        
	}

	public static void updateAllDishes(ArrayList<Dish> allDishes) {
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        
        for(Dish dish: allDishes)
        {
        	session.beginTransaction();
        	session.saveOrUpdate(dish);

            session.getTransaction().commit();
    		
        }
	}
	
	public static void saveDish(Dish dish)
	{
		DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
    	session.beginTransaction();
    	session.saveOrUpdate(dish);

        session.getTransaction().commit();
	}
	
	

}
