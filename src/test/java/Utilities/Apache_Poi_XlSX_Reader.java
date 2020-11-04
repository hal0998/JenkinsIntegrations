package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Apache_Poi_XlSX_Reader {

	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	XSSFRow workrow;
	XSSFCell workcell;

	String file = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "Testing.xlsx";
	String sheet_name = "Test_Data";

	@Test(priority = 0, dependsOnMethods = "Write_Excel_Sheet", enabled = true)
	public void Read_Excell_Sheet() {

		try {

			FileInputStream file = new FileInputStream(this.file);
			workbook = new XSSFWorkbook(file);
			worksheet = workbook.getSheet(this.sheet_name);

		} catch (Exception e) {

			System.out.println("No Such File ! ");

		}

		int totalrow = worksheet.getPhysicalNumberOfRows();
		int totalcol = worksheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalrow][totalcol];

		for (int row = 0; row < totalrow; row++) {

			for (int col = 0; col < totalcol; col++) {

				data[row][col] = worksheet.getRow(row).getCell(col).getStringCellValue().toString();
				String value = worksheet.getRow(row).getCell(col).getStringCellValue().toString();
				System.out.print(value + "\t");

			}
			System.out.println();

		}
	}

	@Test
	public void Write_Excel_Sheet() throws Exception {

		workbook = new XSSFWorkbook();
		worksheet = workbook.createSheet(this.sheet_name);

		Map<String, Object[]> data = new HashMap<String, Object[]>();
		data.put("1", new Object[] { "Halmurat", "Muhtar", "571-888-6661", "IT", "Developer" });
		data.put("2", new Object[] { "Dilyar", "Arkin", "571-987-9897", "IT", "QA Automation Engineer" });
		data.put("3", new Object[] { "Elyar", "Emin", "571-898-3723", "IT", "QA Tester" });
		data.put("0", new Object[] { "First_Name", "Last_Name", "Contact_Info", "Job_Title", "Profile" });

		Set<String> data_set = data.keySet();
		int row = 0;

		for (String id : data_set) {

			workrow = worksheet.createRow(row++);
			Object[] data_obj = data.get(id);
			int cell = 0;

			for (Object obj : data_obj) {

				workcell = workrow.createCell(cell++);
				workcell.setCellValue(obj.toString());

			}
		}

		FileOutputStream file = new FileOutputStream(new File(this.file));
		workbook.write(file);
		file.close();

	}

}
