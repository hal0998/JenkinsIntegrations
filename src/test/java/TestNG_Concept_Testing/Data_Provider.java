package TestNG_Concept_Testing;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {

	static XSSFWorkbook workbook;
	static XSSFSheet worksheet;
	static XSSFRow sheetrow;
	static XSSFCell rowcell;
	static String FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "Book.xlsx";

	public static Object[][] Get_Excel_Data() {
		FileInputStream file;
		try {

			file = new FileInputStream(new File(FILE_PATH));
			workbook = new XSSFWorkbook(file);

		} catch (Exception e) {
			System.out.println("Please define correct xsxl path, the current path is" + FILE_PATH);
		}

		worksheet = workbook.getSheetAt(0);

		int totalcell = worksheet.getRow(0).getLastCellNum();
		int totalphytow = worksheet.getPhysicalNumberOfRows() - 1;

		Object[][] data = new Object[totalphytow][totalcell];

		for (int row = 1; row <= totalphytow; row++) {

			for (int cell = 0; cell < totalcell; cell++) {

				data[row - 1][cell] = worksheet.getRow(row).getCell(cell).getStringCellValue();
			
			}

		}

		return data;
	}
	// what is purpose of being QA tester

	@DataProvider
	public Object[][] get_data() {

		Object[][] data = Data_Provider.Get_Excel_Data();
		return data;

	}

	@Test(dataProvider = "get_data")
	public void datadriven_Testing(String firName, String lasname, String Phone, String city, String state) {

		System.out.println("The Customer First Name is\t" + firName + "\nLast Name is\t" + lasname);
		System.out.println("Phone Number is\t" + Phone + "\nliving in " + city + ", " + state + "\n");

	}

}
