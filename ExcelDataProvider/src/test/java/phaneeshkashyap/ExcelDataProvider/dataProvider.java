package phaneeshkashyap.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	
	
	
	@Test(dataProvider="driveTest")
	public void testCaseData(String name, String greet, String ID)
	{
		System.out.println(greet + " " + name + ", your ID is - " + ID);
	}
	
	
	//multiple sets of data to our test in multi-dimentional array
	@DataProvider(name="driveTest")
//	@DataProvider
	public Object[][] getData() throws IOException
	{
		//multi dimentional array
//		Object[][] data = {{"Phaneesh","Guten Morgen",1111},{"Ashwini","Good Morning",2222},{"Mahesh","Hola",3333}};
//		return data;
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\Users\\phane\\Documents\\"
				+ "04. Automation - new learning\\Selenium\\Projects\\ExcelDataProvider\\"
				+ "src\\test\\java\\phaneeshkashyap\\ExcelDataProvider\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Data");
//		XSSFSheet sheet = wb.getSheetAt(0);
		int rCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int cCount = row.getLastCellNum();
		
		Object Data[][] = new Object[rCount-1][cCount];
		for(int i=0 ; i<rCount-1;i++)
		{	
			row = sheet.getRow(i);
			for(int j=0;j<cCount;j++)
			{	
//				XSSFCell cell = row.getCell(j);
				Data[i][j] = formatter.formatCellValue(row.getCell(j));
			}
		}

		
		return Data;
		
	}
	
	
}
