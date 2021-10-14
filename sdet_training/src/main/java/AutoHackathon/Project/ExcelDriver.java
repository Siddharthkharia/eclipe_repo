package AutoHackathon.Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver 
{
	private Workbook oExcelWorkbook;
	private String sExcelFileName;
	private InputStream oFileReader;
	private OutputStream oFileWriter;
	
	
	
	public void openExcelWorkbook(String sExcelFileName) throws Exception
	{
		if ( !new File(sExcelFileName).exists() )
		{
			oExcelWorkbook = new XSSFWorkbook();
			oFileWriter = new FileOutputStream(sExcelFileName);
			oExcelWorkbook.write(oFileWriter);
			oFileWriter.close();
			oExcelWorkbook.close();
		}
		
		oFileReader = new FileInputStream(sExcelFileName);
		oExcelWorkbook = WorkbookFactory.create(oFileReader);
		this.sExcelFileName = sExcelFileName;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public void closeExcelWorkbook() throws Exception
	{
		oExcelWorkbook.close();
		oFileReader.close();
	}
	
	
	//---------------------------------------------------------------------------------------------------
	
	public void save() throws Exception
	{
		oFileWriter = new FileOutputStream(sExcelFileName);
		oExcelWorkbook.write(oFileWriter);
		oFileWriter.close();
	}
	
	
	//---------------------------------------------------------------------------------------------------
	
	public void saveAs(String sNewExcelFileName) throws Exception
	{
		oFileWriter = new FileOutputStream(sNewExcelFileName);
		oExcelWorkbook.write(oFileWriter);
		oFileWriter.close();
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public int getRowCount(String sSheetName)
	{
		try 
		{
			return oExcelWorkbook.getSheet(sSheetName).getLastRowNum()+1;
		} 
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public int getCellCount(String sSheetName, int iRow)
	{
		try 
		{
			return oExcelWorkbook.getSheet(sSheetName).getRow(iRow-1).getLastCellNum()+1;
		} 
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public String getCellData(String sSheetName, int iRow, int iColumn)
	{
		try 
		{
			return oExcelWorkbook.getSheet(sSheetName).getRow(iRow-1).getCell(iColumn-1).getStringCellValue();
		} 
		catch (Exception e) 
		{
			return "";
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public void setCellData(String sSheetName, int iRow, int iColumn, String sValue) throws Exception
	{
		Sheet oSheet;
		Row oRow;
		Cell oCell;
		
		oSheet = oExcelWorkbook.getSheet(sSheetName);
		if (oSheet == null)
		{
			oExcelWorkbook.createSheet(sSheetName);
			oSheet = oExcelWorkbook.getSheet(sSheetName);
		}
		
		
		oRow = oSheet.getRow(iRow-1);
		if (oRow == null)
		{
			oSheet.createRow(iRow-1);
			oRow = oSheet.getRow(iRow-1);
		}
		
		
		oCell = oRow.getCell(iColumn-1);
		if (oCell == null)
		{
			oRow.createCell(iColumn-1);
			oCell = oRow.getCell(iColumn-1);
		}
		
		oCell.setCellValue(sValue);
		
	}
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------
	
	
	
	
}
