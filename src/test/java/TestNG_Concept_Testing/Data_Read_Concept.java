package TestNG_Concept_Testing;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Read_Concept {

	static String filePath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "Book.xlsx";
	static XSSFWorkbook workbook = null;
	static XSSFSheet worksheet = null;

	public static void main(String[] args) {

		File filepath = new File(filePath);
		try {

			FileInputStream file = new FileInputStream(filepath);
			System.out.println(filePath);

			workbook = new XSSFWorkbook(file);
			worksheet = workbook.getSheetAt(0);

			int rowSize = worksheet.getPhysicalNumberOfRows() - 1;
			int columnSize = worksheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowSize][columnSize];

			for (int row = 1; row <= rowSize; row++) {

				// XSSFRow sheetrow = (XSSFRow) worksheet.getRow(row);

				for (int column = 0; column < columnSize; column++) {

					data[row - 1][column] = worksheet.getRow(row).getCell(column);
					System.out.print("\t" + worksheet.getRow(row).getCell(column));
				}
				System.out.println();
			}

		} catch (Exception e) {

		}

	}
}
