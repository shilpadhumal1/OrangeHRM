package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite 
{
	public static String Read(int i,int j) throws IOException 
	{
		
			File source=new File("C:\\Users\\shahaji\\Desktop\\Test.xlsx");
			FileInputStream fis=new FileInputStream(source);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			String cell = sheet.getRow(i).getCell(j).toString();
			System.out.println(cell);
			return cell;		
		
	}
		public static void writeExcel(int i,int j,String teststatus ) throws IOException
		{
			File source=new File("C:\\Users\\shahaji\\Desktop\\Test.xlsx");
			FileInputStream fis=new FileInputStream(source);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			File source1=new File("C:\\Users\\shahaji\\Desktop\\Test.xlsx");
			FileOutputStream fout=new FileOutputStream(source1);
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell;
			if((row==null))
				row=sheet.createRow(i);				
			cell = row.getCell(j);
			if(cell==null)
				cell=row.createCell(j);
				cell.setCellValue(teststatus);			
			wb.write(fout);
			wb.close();
		}

	
	
}
