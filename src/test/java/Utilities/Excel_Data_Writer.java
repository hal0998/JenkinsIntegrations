package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data_Writer {

	static XSSFWorkbook workbook;
	static XSSFSheet worksheet;
	static XSSFRow workrow;

	public static void main(String[] args) throws Exception {

		workbook = new XSSFWorkbook();
		worksheet = workbook.createSheet("StudyList");

		Map<String, Object[]> course = new HashMap<String, Object[]>();
		course.put("front_end", new Object[] { "Java", "Selenium", "TestNG", "Cucumber", "Junit" });
		course.put("back_End", new Object[] { "Java", "RestAssured", "TestNG", "Cucumber", "Postman" });

		Set<String> key = course.keySet();
		int row = 0;

		for (String id : key) {

			workrow = worksheet.createRow(row++);

			Object[] object = course.get(id);
			int cell = 0;

			for (Object obj : object) {

				XSSFCell rowcell = workrow.createCell(cell++);

				rowcell.setCellValue(obj.toString());
			}
		}

		FileOutputStream file = new FileOutputStream(
				new File(System.getProperty("user.dir") + File.separator + "TestData") + File.separator + "out.xlsx");

		workbook.write(file);
		file.close();

	}

}
