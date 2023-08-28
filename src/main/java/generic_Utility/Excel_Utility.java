package generic_Utility;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Excel_Utility {

	@DataProvider(name="testData")
	public String[][] getExcelData(Method m) throws Throwable {
		
		 String sheet = m.getName();
		
		FileInputStream fes = new FileInputStream("./src/test/resources/SwagLabs_loginTable.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		Sheet sheetName = wb.getSheet(sheet);
		int lastrow = sheetName.getLastRowNum();
		int lastcell = sheetName.getRow(0).getLastCellNum();
		System.out.println("Total number of Rows: " + lastrow + "  Columns: " + lastcell);

		DataFormatter format = new DataFormatter();

		String[][] testData = new String[lastrow][lastcell];
		for (int i = 2; i < lastrow; i++) {
			for (int j = 0; j < lastcell; j++) {
				testData[i - 2][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;

	}

}