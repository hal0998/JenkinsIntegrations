package TestNG_Concept_Testing;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Priority_Test {
	
	
	
	@Test(priority = 0, description="Open Door Test")
	public void open_the_door() {
		
		System.out.println("opening the door");
		
	}
	
	
	@Test(priority = 1,description="Close Door Test")
	public void close_the_door() {
		System.out.println("Closing The Door");
		
	}
	
	@Test(priority=2,description="Seat On Chair Test")
	public void seat_on_chair() {
		
		System.out.println("Seating On The Chair");
		
	}

}
