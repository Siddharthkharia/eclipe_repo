import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFColor;

public class ExcelTest {

	
	
	
	/**
	 * Open the file given in the file address, if found
	 * @param fileAddress
	 * @return true if file exist and successfully opened it; false otherwise
	 */
	public  boolean openFile(String fileAddress) {
		
			File file = new File (fileAddress);
			//			file.setReadOnly();
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		IOExcel obj = new IOExcel();
		String data21="nadsasdsadasd";
		String outputFile="C:\\Users\\siddhakh\\eclipse-workspace\\BasicFunctions\\src\\input - Copy.xlsx";
		
		String sheetName ="Sheet1";
		XSSFColor color= new XSSFColor(new java.awt.Color(125,0,125));
		
		//obj.getExcel(inputFile);
		//obj.writeExcel(outputFile, sheetName, data);
		//obj.readExcelData(outputFile,sheetName);
		//obj.writeExcelCell(outputFile, sheetName, 1, data2);
		//obj.ReadTxt(inputFile);
		obj.setExcelCellBg(outputFile, sheetName,color);
		obj.writeExcel(outputFile);
		ExcelTest xltest = new ExcelTest();
		xltest.openFile(outputFile);
		
		
	}

}
