package testBackend.testServlet;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.servlet.HomePageServlet;

public class TestHomePageServlet {
	
	@Test
	public void testGetAllCategories() {
		//test of method:
		//public String getAllCategories()
		HomePageServlet homePageServlet= new HomePageServlet();
		String result= homePageServlet.getAllCategories();
		String expected="breakfast lunch wine ";
		assertEquals(expected, result);
	}

}
