package TestNG_Concept_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider_Test {

	static XSSFWorkbook workbook;
	static XSSFSheet worksheet;
	static String EXSL_FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "Book.xlsx";
	static String JSON_FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData";

	public static void main(String[] args) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("HH:MM");
		String filename = format.format(new Date()).toString() + ".json";

		JSONArray jsonarr = new JSONArray();
		Object[][] data = Data_Provider_Test.Read_Exl();

		for (int row = 0; row < data.length; row++) {

			JSONObject json = new JSONObject();

			for (int col = 0; col < data[row].length; col++) {

				if (row < data.length && col < data[row].length) {

					switch (col) {

					case 0: {

						json.put("first_name", data[row][col].toString());
						break;
					}
					case 1: {

						json.put("last_name", data[row][col].toString());
						break;
					}
					case 2: {

						json.put("phone_number", data[row][col].toString());
						break;
					}
					case 3: {

						json.put("city_name", data[row][col].toString());
						break;
					}
					case 4: {

						json.put("state_name", data[row][col].toString());
						break;
					}
					default:
						System.out.println("The two dimention arry row count is " + row + " column count is : " + col);
					}
				}
			}
			jsonarr.add(json);
		}
		FileWriter file=new FileWriter(JSON_FILE_PATH+"/"+filename);
		file.write(jsonarr.toJSONString());
		file.flush();
		System.out.println(jsonarr.toJSONString());

	}

	public static Object[][] Read_Exl() {

		File filepath = new File(EXSL_FILE_PATH);

		try {

			FileInputStream file = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(file);
			worksheet = workbook.getSheetAt(0);

		} catch (Exception e) {
			System.out.println("Unable To load Excel File !");
		}

		int totalRow = worksheet.getPhysicalNumberOfRows() - 1; // 5
		int totalCol = worksheet.getRow(0).getLastCellNum(); // 5

		// Object[][] data = new Object[5][5];

		Object[][] data = new Object[totalRow][totalCol];
		for (int row = 1; row <= totalRow; row++) {

			for (int col = 0; col < totalCol; col++) {

				// 0 0 // 1 0
				data[row - 1][col] = worksheet.getRow(row).getCell(col).getStringCellValue();
			}
		}
		return data;
	}

	@DataProvider
	public Object[][] data_Injector() {

		Object[][] data = Data_Provider_Test.Read_Exl();
		return data;

	}

	@Test(dataProvider = "data_Injector", enabled = false)
	public void Read_Data_Test(String fir_name, String las_name, String phone, String city, String state) {

		System.out.println("=========================");
		System.out.println("\nThe first name is : " + fir_name + "\nThe last name is : " + las_name);
		System.out.println(
				"The phone number is : " + phone + "\nThe city name is : " + city + "\nThe state name is : " + state);

	}
}