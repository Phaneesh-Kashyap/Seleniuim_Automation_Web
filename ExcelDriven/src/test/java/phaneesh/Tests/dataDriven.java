package phaneesh.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	
	public ArrayList<String> getData(String testcasename) throws IOException
	{
		
		//identify test cases col by scanning the entire 1st row
				//scan first column to get row for purchase test case
				// pull all the row data in that purchase test row and feed it into test
				
				
				ArrayList<String> a = new ArrayList();
				
				//accepts file arg
				FileInputStream fis = new FileInputStream("C:\\Users\\phane\\Documents\\"
						+ "04. Automation - new learning\\Selenium\\Projects\\ExcelDriven\\"
						+ "src\\test\\java\\phaneesh\\TestData\\Data.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				int sheets = wb.getNumberOfSheets();
				
				for(int i=0 ; i<sheets ; i++)
				{
					if(wb.getSheetName(i).toLowerCase().equalsIgnoreCase("data"))
					{
						XSSFSheet sheet = wb.getSheetAt(i);
						
						//identify test cases col by scanning the entire 1st row
						Iterator<Row> rows = sheet.rowIterator();
						Row firstrow = rows.next();
						Iterator<Cell> cel = firstrow.cellIterator();
						
						
						//scan first column to get row for purchase test case
						
						int colind = 0;
						int k = 0;
						
						while(cel.hasNext())
						{
							Cell val = cel.next();
							if(val.getStringCellValue().equalsIgnoreCase("Test Cases"))
							{
								colind = k;
							}
							k++;
						}
						
//						System.out.println(colind);
						// pull all the row data in that purchase test row and feed it into test
						while(rows.hasNext())
						{
							Row r = rows.next();
							if (r.getCell(colind).getStringCellValue().toLowerCase().equalsIgnoreCase("purchase"))
							{
								Iterator<Cell> cVal = r.cellIterator();
								while(cVal.hasNext())
								{
//									a.add(cVal.next().getStringCellValue().toString());
									
//									if the value is numeric use NumberToTextConverter mothod
//									a.add(cVal.next().getCellTypeEnum()==CellType.STRING ?
//											cVal.next().getStringCellValue() :
//										NumberToTextConverter.toText(cVal.next().getNumericCellValue()));
									
									Cell c= cVal.next();
									if(c.getCellType()==CellType.STRING)
									{
										a.add(c.getStringCellValue());
										
										
									}
									else
									{
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
									}
									
									
									
								}
							}
							
						}
					}
					
				}
				return a;
		
	}
	
	
	
	
	

}
