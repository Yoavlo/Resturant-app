package testBackend.testServlet;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDishServlet.class, TestHomePageServlet.class })
public class AllTests {

}
