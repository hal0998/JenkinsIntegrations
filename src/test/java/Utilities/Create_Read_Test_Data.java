package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class Create_Read_Test_Data {

	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	XSSFRow sheetrow;
	XSSFCell rowcell;
	String FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "DummyData.xlsx";
	String SHEET_NAME = "Emplyee_List";

	@Test
	public void Write_Data() throws Exception {

		int dataCount = 10;
		Map<Object, Object[]> datamap = new HashMap<Object, Object[]>();

		for (int count = 1; count < dataCount; count++) {

			String firstname = new Faker().name().firstName();
			String lastname = new Faker().name().lastName();
			String phone = new Faker().phoneNumber().cellPhone().toString();
			String state = new Faker().address().state();
			String city = new Faker().address().cityName();
			String street = new Faker().address().streetName();
			street = street + " " + new Faker().address().streetSuffix();
			String stnumber = new Faker().address().streetAddressNumber();
			String zipcode = new Faker().address().zipCode();

			workbook = new XSSFWorkbook();
			worksheet = workbook.createSheet(SHEET_NAME);
//			XSSFFont font = workbook.createFont();
//			font.setFontHeightInPoints(height);
			datamap.put(count, new Object[] { firstname, lastname, phone, state, city, stnumber, street, zipcode });
			datamap.put(0, new Object[] { "First_Name", "Last_Name", "Contact_Info", "State", "City", "Street_number",
					"Street_Name", "Zip_Code" });

		}

		Set<Object> objkeys = datamap.keySet();
		int row = 0;

		for (Object id : objkeys) {

			sheetrow = worksheet.createRow(row++);
			Object[] dataObj = datamap.get(id);
			int cell = 0;

			for (Object value : dataObj) {

				rowcell = sheetrow.createCell(cell++);
				rowcell.setCellValue(value.toString());

			}

		}

		FileOutputStream file = new FileOutputStream(FILE_PATH);
		workbook.write(file);
		file.close();
	}

	@Test(dependsOnMethods = "Write_Data")
	public void Read_Data() throws Exception {

		FileInputStream file = new FileInputStream(FILE_PATH);

		workbook = new XSSFWorkbook(file);
		worksheet = workbook.getSheet(SHEET_NAME);

		int totalrow = worksheet.getPhysicalNumberOfRows();
		int totalcol = worksheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[totalrow][totalcol];

		for (int row = 0; row < totalrow; row++) {

			for (int col = 0; col < totalcol; col++) {

				data[row][col] = worksheet.getRow(row).getCell(col).getStringCellValue();

				System.out.print(data[row][col] + "\t");

			}
			System.out.println();
		}

	}

}
