package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import backend.entities.*;

//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//
//import javax.persistence.criteria.*;
//import java.util.List;
//
//import backend.dao.Category;

public class Main {
	

	

   public static void main(String[] args) {
	   
	  test
		DbSessionManager sessionManager = new DbSessionManager();
	   Order or= new Order();
		or.setComment("comment");
		or.setTableNumber(18);
    	or.setTimeOfOrder("time");
		or.setOrder("order");
	
	
		Session session = sessionManager.getSessionFactoryInstance().openSession();
		session.save(or);
		session.close();
		
	   
	   /*
	   
		DbSessionManager sessionManager = new DbSessionManager();
		Dish dish= new Dish();
       dish.setAvailable(true);
       dish.setName("steak");
       dish.setInfo("This steak recipe is a classic");
		dish.setIdCategory(2);
		dish.setPrice(50);
		Session session = sessionManager.getSessionFactoryInstance().openSession();
       session.save(dish);
       session.close();
       
       */
	   
	   
	   
	  // String bla= "0123456789";
	 //  bla= bla.substring(1);
	  // bla= bla.substring(0,bla.length()-4)+bla.substring(bla.length()-3);

	 //  System.out.println("bla: "+bla);
	 //  String orderRequest="{orderId:null ,tableNumber:18}";
		//String orderRequest="{\"orderId\":\"null\" ,\"tableNumber\":\"18\"}";
//		System.out.println(" 1 orderRequest: "+orderRequest);
	   
	   
	//	JSONArray array= new JSONArray();
	//	Gson gson = new Gson();
		//orderRequest= gson.toJson(orderRequest);
	//	System.out.println(" 0 orderRequest: "+orderRequest);
	//	JSONObject json = new JSONObject(orderRequest);
		//String comment= json.getString("orderId");
		//String tableNumber= json.getString("tableNumber");
		//System.out.println("comment: "+comment+" tableNumber: "+tableNumber);
		
   }
	   
	   
	   
	  
	   
	   /*
	    * 
	    * Please try this code:

(This code will get you the sum of the of the primary numbers, not the average)

    public static double checkPrimeAVG2DArray(int[][] arr) {
    int sum =0;
    ArrayList <Integer> notPrimeNumber= new ArrayList<>();
    for (int i=0; i< arr.length; i++ ) {
        for (int j=0; j<arr.length; j++) {

            for (int temp=2; temp < arr[i][j]; temp++ ) {
                if ( arr[i][j] % temp == 0) { 
                    temp++;
                    System.out.println(arr[i][j] + " is not prime number");
                    notPrimeNumber.add(arr[i][j]);
                    break;
            } 
    }
    }}
    for (int i=0; i< arr.length; i++ ) {
        for (int j=0; j<arr.length; j++) {
        	if(!(notPrimeNumber.contains(arr[i][j])))
        	{
        		 sum = sum + arr[i][j];
        	}
        }
    }
    return sum;
}


Using  `if ( arr[i][j] % temp == 0)`you successfully get the not primary number.
So i add this numbers(all the not primary number) to a List: 

    ArrayList <Integer> notPrimeNumber= new ArrayList<>();
    notPrimeNumber.add(arr[i][j]);

This lanes of code check if the number is in the `notPrimeNumber` list, if not the number is a primary number and added to the sum:

    for (int i=0; i< arr.length; i++ ) {
        for (int j=0; j<arr.length; j++) {
            if(!(notPrimeNumber.contains(arr[i][j])))
            {
                 sum = sum + arr[i][j];
            }
        }

*/
	  
	   
		
   

		//get dishes by category
		//SELECT * FROM DISH where idcategory=1;
//		DbSessionManager sessionManager = new DbSessionManager();
//		Session session = sessionManager.getSessionFactoryInstance().openSession();
//        CriteriaBuilder builder= session.getCriteriaBuilder();
//        CriteriaQuery <Dish> criteria= builder.createQuery(Dish.class);
//        Root<Dish> root= criteria.from(Dish.class);
//        
//        criteria.where(builder.equal(root.get("idCategory"), 1));
//        Query query = session.createQuery(criteria);
//        List<Dish> allDishes = query.getResultList();
//        
//        for(Dish dish: allDishes)
//        {
//        	System.out.println("dish.getName " +dish.getInfo());
//        }
//   
      
       
      

     //   criteria.where(builder.ge(root.get("idcategory")))
		
		
		/*add Dish to db.
		DbSessionManager sessionManager = new DbSessionManager();
		Dish dish= new Dish();
        dish.setAvailable(true);
        dish.setName("omelet");
        dish.setInfo("This French omelete recipe is a classic");
		dish.setIdCategory(1);//breakfast
		dish.setPrice(20);
		Session session = sessionManager.getSessionFactoryInstance().openSession();
        session.save(dish);
        session.close();
		*/
		
		
		
		

		
//		  System.out.println("27 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//			DbSessionManager sessionManager = new DbSessionManager();
//		     System.out.println("29 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//	        Session session = sessionManager.getSessionFactoryInstance().openSession();
//	        System.out.println("31 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//	        CriteriaBuilder builder = session.getCriteriaBuilder();
//	        CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
//	        Root<Category> root = criteria.from(Category.class);
//	        criteria.select( root );
//
//	        Query query = session.createQuery(criteria);
//	        List<Category> categorys = query.getResultList();
//	        System.out.println("getting all caterorys");
//	        String jsonOfCategory="";
//	        
//	        for(Category category: categorys )
//	        {
//	        	System.out.println(category.getCategory());
//	        	jsonOfCategory+=category.getCategory();
//	        }
	

}
