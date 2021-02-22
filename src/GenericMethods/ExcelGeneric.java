package GenericMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class ExcelGeneric implements Auto_constant {
	public static void Excelwritegm(String sheet, int rw, int cell,String value) 
	{
		try{
		FileInputStream fin= new FileInputStream(Excel_path);
		Workbook wb=WorkbookFactory.create(fin);
		 Cell cel = wb.getSheet(sheet).getRow(rw).createCell(cell);
		//Row row = sh.getRow(rw);
		//Cell cel = row.createCell(cell);
		cel.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(Excel_path);
		wb.write(fout);
		System.out.println("Status has been written to the excel");
		}
		catch(Exception e)
		{
			System.out.println("Could'nt write status to the excel sheet");
		}
	}
public static String Excelread(String sheet, int row, int cell)
{
	String val="";
	try{
	FileInputStream fin= new FileInputStream(Excel_path);
	Workbook wb=WorkbookFactory.create(fin);
	Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
	val = c.getStringCellValue();
		}
	catch(Exception e)
	{
		Reporter.log("Failed to read excel data",true);
	}
	return val;
	}
}



