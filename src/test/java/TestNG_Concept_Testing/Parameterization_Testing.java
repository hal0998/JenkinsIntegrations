package TestNG_Concept_Testing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization_Testing {


	@Parameters({"username"})
	@Test
	public void single_param_Test(String name) {

		System.err.println("The Customer name is \t" + name);
	}
	
	@Parameters({"username","password","url","browser"})
	@Test
	public void multi_Param_test(String name, String pass, String url,String browser) {
		
		System.out.println("The User Name is :\t"+name+"\nThe Password is :\t"+pass+"\nThe URl is :\t"+url+"\nThe Browser Type is :\t"+browser);
	
		
	}

}
