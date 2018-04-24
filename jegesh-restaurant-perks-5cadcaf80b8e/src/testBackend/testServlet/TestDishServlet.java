package testBackend.testServlet;

import static org.junit.Assert.*;

import javax.ws.rs.QueryParam;

import org.junit.Test;

import backend.servlet.DishServlet;

public class TestDishServlet {

	@Test
	public void testAllDishsInCategory() {
		//test of method:
		//public String getAllDishsInCategory(@QueryParam("idCategory") int idCategory)
		DishServlet dishServlet= new DishServlet();
		int idCategory=1;
		String assume="[{\"idDish\":1,\"available\":true,\"price\":20.0,\"info\":\"This French omelete recipe is a classic\",\"idCategory\":1,\"name\":\"omelet\"},{\"idDish\":2,\"available\":true,\"price\":30.0,\"info\":\"This simple and delicious pancake is perfect for weekend breakfast\\u0027s\",\"idCategory\":1,\"name\":\"pancake\"},{\"idDish\":3,\"available\":false,\"price\":15.0,\"info\":\"Porridge is a good staple breakfast; it’s cheap, it’s filling and it’s nutritious\",\"idCategory\":1,\"name\":\"banana \\u0026 cinnamon porridge\"}]";
	
		String result=dishServlet.getAllDishsInCategory(idCategory);
		assertEquals(assume, result);
		
		idCategory=2;
		assume="[{\"idDish\":4,\"available\":true,\"price\":33.0,\"info\":\"Pasta with tomato cream sauce, ridiculously yummy\",\"idCategory\":2,\"name\":\"pasta rose\"}]";
		result=dishServlet.getAllDishsInCategory(idCategory);
		assertEquals(assume, result);
		
	}

}
