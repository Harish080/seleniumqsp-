package testNg;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class New {

	
	
	@Test(invocationCount = 0)
	public void createproduct()
	{
		System.out.println("product is created");
		
	}
	
	@Test(dependsOnMethods="createproduct")
	public void modifyproduct()
	
	{
		
		System.out.println("product is modified");
		
	}
	
	@Test(dependsOnMethods = {"createproduct","modifyproduct"})   
	public void deleteproduct()
	{
		System.out.println("product is deleted");
		
	}
	
	
	
	
	
	
}
	

