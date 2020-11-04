package TestNG_Concept_Testing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_Json_File {

	public static void main(String[] args) throws Exception {

		FileReader read = null;
		String JSON_FILE = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "20:09.json";
		try {

			read = new FileReader(JSON_FILE);

		} catch (Exception e) {
		}
		JSONParser parser = new JSONParser();
		JSONArray objarr = (JSONArray) parser.parse(read);
		for (int size = 0; size < objarr.size(); size++) {

			JSONObject obj = (JSONObject) objarr.get(size);
			String first_name = obj.get("first_name").toString();
			String last_name = obj.get("last_name").toString();
			String city_name = obj.get("city_name").toString();
			String state_name = obj.get("city_name").toString();
			String phone_number = obj.get("phone_number").toString();
			System.out.println("The customer first name is : " + first_name + " last name is : " + last_name);
			System.out.println("Currently living " + city_name + ", " + state_name);
			System.out.println("The Contact phone number is : "+phone_number);
			System.out.println("\n========================================\n");
		}

	}

}
