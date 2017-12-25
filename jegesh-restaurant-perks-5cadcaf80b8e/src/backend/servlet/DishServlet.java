package backend.servlet;

import javax.ws.rs.Path;

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

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import backend.DbSessionManager;
import backend.entities.Dish;
import backend.entities.Order;

import org.json.*;



//http://localhost:8080/yaakovRestaurant/rs/dish
@Path("dish")
public class DishServlet {
	
	//http://localhost:8080/yaakovRestaurant/rs/dish?idCategory=1
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
        Gson gson = new Gson();
        
        session.close();

		return gson.toJson(allDishes).toString(); //without the gson. the method will return the location in the memory.
	}
	
	@POST
	//@Consumes
	public void saveOrderInDB (@QueryParam("comment") String comment,
								@QueryParam("tableNumber") int tableNumber,
								@QueryParam("order") String order)
//	public void saveOrderInDB (@QueryParam("jsonOrder") String orderRequest)
	{
		Order or= new Order();
		
		System.out.println("comment: "+comment + "tableNumber: "+tableNumber +" TimeOfOrder:" +new Date()
				+" order: "+order);
		or.setComment(comment);
		or.setTableNumber(tableNumber);
		or.setTimeOfOrder(""+new Date());
		//or.setOrder(order);
		or.setOrder("this is a order");
	
		DbSessionManager sessionManager = new DbSessionManager();
	    Session session = sessionManager.getSessionFactoryInstance().openSession();
		session.save(or);
		session.close();
		
		//TODO dont send String, but all the peremeters.
//		System.out.println("trying to save order to db");
//	//	System.out.println("json"+json);
//		System.out.println("*********************");
//		System.out.println("0 orderRequest: "+orderRequest);
//		System.out.println("*********************");
//		
//		orderRequest= orderRequest.substring(0,orderRequest.length()-4)+orderRequest.substring(orderRequest.length()-3);
//		System.out.println(" 0.5 orderRequest: "+orderRequest);
//		Gson gson = new Gson();
//		orderRequest= gson.toJson(orderRequest);
//		System.out.println(" 1 orderRequest: "+orderRequest);
//		//orderRequest= orderRequest.substring(1,orderRequest.length()-1);
//		orderRequest="{"+orderRequest+"}";
//		System.out.println(" 2 orderRequest: "+orderRequest);
//		System.out.println("order length: "+orderRequest.length());
//    	JSONObject json = new JSONObject(orderRequest);
//		String comment= json.getString("comment");
//		String tableNumber= json.getString("tableNumber");
		
		// gson.toJson(orderRequest);
	//	;
		//orderRequest="{'comment': 'comment'}";
	
	//	String comment= gson.fromJson("comment", String.class);
	//	String tableNumber= gson.fromJson("tableNumber", String.class);
		//System.out.println("*********************");
	//	System.out.println("comment: "+comment + " tableNumber: "+tableNumber);
	
		//String json= gson.toJson(orderJson);
		
	//	JSONObject orderJson= new JsonObject(order);
		//System.out.println("comment"+orderJson["comment"]);
		
		
		
		//order.setComment(comment);
		//order.setTableNumber(tableNumber);
	//	order.setTimeOfOrder(new Date());
	//	order.setIdOrder(idOrder);


	//	DbSessionManager sessionManager = new DbSessionManager();
		//Session session = sessionManager.getSessionFactoryInstance().openSession();
	//	session.save(orderJson);
		//System.out.println("saved order was save to db successfully");
		//session.close();

		
	}

}
