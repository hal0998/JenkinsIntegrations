package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.testng.asserts.SoftAssert;

public class Tool_Box {

	static String filePath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "Book.xlsx";
	static XSSFWorkbook workbook = null;
	static XSSFSheet worksheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;

	public static Object[][] get_Exl_Data() {

		try {

			FileInputStream file = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(file);
			worksheet = workbook.getSheetAt(0);

		} catch (Exception e) {

			System.out.println("Please Set Correct Excel File Path !");
		}

		int rowCount = worksheet.getPhysicalNumberOfRows() - 1; // 5
		int cellCount = worksheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][rowCount];

		for (int row = 1; row <= rowCount; row++) {

			for (int column = 0; column < cellCount; column++) {

				data[row - 1][column] = worksheet.getRow(row).getCell(column);

			}
			System.out.println();
		}
		return data;
	}

	public static void content_soft_Assert(String expected, String Actual) {
		boolean result = Actual.contains(expected);
		SoftAssert sf = new SoftAssert();
		try {
			sf.assertTrue(result);
			sf.assertAll();
			if (result == false) {
			}
		} catch (AssertionError e) {
			e.getMessage();
			sf.fail("The Actual Result is : " + Actual + ", but You Were Expected : " + expected);

		}
	}

}
