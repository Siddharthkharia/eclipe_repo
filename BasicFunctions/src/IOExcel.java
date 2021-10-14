import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IOExcel {

	private static final String XSSFCellStyle = null;
	XSSFWorkbook workbook = null;
	Sheet sheet= null;
	File file = null;

	//Function to Read the Excel File and initiates workbook 
	/*public void getExcel(String x) throws FileNotFoundException {
		String fileName=x;

		file = new File(fileName);
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	 */

	public void getExcel(String x) throws FileNotFoundException {
		String fileName=x;
		try {
			//			ZipSecureFile.setMinInflateRatio(-1.0d);
			workbook = new XSSFWorkbook(new FileInputStream(fileName));
		} catch (EncryptedDocumentException | IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


	//to write excel sheet initializing new rows
	/**
	 * 
	 * @param output
	 * @param sheetName
	 * @param data
	 * @throws IOException
	 */
	public void writeExcel(String output, String sheetName, String data) throws IOException {

		getExcel(output);

		sheet=workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		//Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount+1);


		for (int i=1; i<10; i++) {

			for (int j=0;j<=i;j++) {

				Cell cell= newRow.createCell(j);
				cell.setCellValue(data);
			}
			rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			newRow = sheet.createRow(rowCount+1);

		}
	}


	//to read the data of complete sheet of an excel workbook
	public void readExcelData(String filePath, String sheetName) throws FileNotFoundException {

		getExcel(filePath);

		sheet=workbook.getSheet(sheetName);

		for (int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++) {

			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {	
				Row row = sheet.getRow(i);
				Cell cell= row.getCell(j);
				//System.out.println("("+i +","+ j +")");
				String a= cell.getStringCellValue();
				System.out.println(a);
			}
		}
	}


	//To Write in the last cell of an existing row 
	public void writeExcelCell(String outputFile, String sheetName,int rowNum, String dataToBeWritten) throws IOException {

		getExcel(outputFile);

		sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);

		System.out.println("Entering data in row: "+rowNum +":- col:- "+row.getLastCellNum() );

		int col=row.getLastCellNum();

		Cell cell = row.createCell(col);
		cell.setCellValue(dataToBeWritten);

		System.out.println(dataToBeWritten +" entered in location (row,col):- ("+ rowNum +","+ col+")");
		
	}

	public void setExcelCellBg(String filePath, String sheetName,XSSFColor color) throws IOException {

		getExcel(filePath);

		sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(sheet.getLastRowNum());

		int col=row.getLastCellNum();

		Cell cell = row.createCell(col);


		CellStyle cellStyle =workbook.createCellStyle();

		//XSSFColor color = new XSSFColor(new java.awt.Color(215,228,188));

		((XSSFCellStyle) cellStyle).setFillForegroundColor(color);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);

	}
	
	public void writeExcel(String filePath){
		

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(filePath));
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Write failed.... with filenotfound exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Write failed.... with IOexception");
			e.printStackTrace();
		}
		
	}
}






