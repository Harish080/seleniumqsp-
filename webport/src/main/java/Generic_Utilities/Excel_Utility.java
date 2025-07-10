package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String SheetName,int rowNum,int cellNum) throws Throwable {
		// Enter product name
		FileInputStream fes = new FileInputStream("./src/test/resources/exceldata.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);

		// step 4:- Navigates into mentioned rowNum
		Row row = sheet.getRow(rowNum);

		// step 5:- Navigates into mentioned cellNum
		Cell cell = row.getCell(cellNum);

		// step6:- fetch the cell value
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}
}
 

