package Selenium_Interview;

public class pallindromeTest {
	
	public static void main(String[] args) {
		
		String pallin = "levell";
		
		String result = "";
		
		for(int i = pallin.length()-1; i >=0; i-- ) {
			
			result += pallin.charAt(i);
		}
			
			if(pallin.equals(result)) {
				
				System.out.println("this is pallindrome");
			}else {
				System.out.println("not pallindrome");
			}
					
		
	}

}
