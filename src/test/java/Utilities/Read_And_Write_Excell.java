package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Read_And_Write_Excell {

	@Test
	public void Read_And_Wright() throws Exception {

		String FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
				+ "DummyData.xlsx";
		FileInputStream file = new FileInputStream(new File(FILE_PATH));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet worksheet = workbook.getSheetAt(0);

		int totalrow = worksheet.getPhysicalNumberOfRows();
		int totalcol = worksheet.getRow(0).getLastCellNum();

		for (int row = 0; row < totalrow; row++) {

			for (int col = 0; col < totalcol; col++) {

				String value = worksheet.getRow(row).getCell(col).getStringCellValue();
				System.out.println("The Value is : " + value);
				System.out.println("The current row is " + row + " And column is " + col);
				if (!value.equalsIgnoreCase("Country") && row == 0) {

					System.out.println("Creating the cells ");
					XSSFRow sheetrow = worksheet.getRow(row);
					XSSFCell rowcell = sheetrow.createCell(worksheet.getRow(row).getLastCellNum());
					rowcell.setCellValue("Country");

				}

			}

		}

	}

}
