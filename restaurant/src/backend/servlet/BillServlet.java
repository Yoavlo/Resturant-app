package backend.servlet;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.POST;

//http://localhost:8080/yaakovRestaurant/rs/bill
@Path("bill")
public class BillServlet {
	
	
	@POST
	public void payBill(@QueryParam("tableNumber") int tableNumber )
		
	{
		System.out.println("TableNumber: "+ tableNumber + "has requesed the bill");
		//code to send to manager app and watier.
	}
	
	

}
