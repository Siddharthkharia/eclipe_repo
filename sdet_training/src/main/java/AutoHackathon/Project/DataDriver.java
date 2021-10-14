package AutoHackathon.Project;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriver {
	
	//Variables
		String rootPath;
		String executionPath;
		String datasheetPath;
		String unixlogPath;
		String curExecutionFolder;
		String htmlReportsPath;
		String snapShotsPath;
		String dataSheetsPath;
		String dataSheet;
		String User;	
		String driverType;
		String enviromentsPath;
		String username = System.getProperty("user.name")+"_";
		String oceapiresponsePath;
		String oceapixmlPath;
		String wtReportingPath;

		HashMap <String, String> orgDictionary = new HashMap<String, String>();
		HashMapNew Dictionary = new HashMapNew();
		HashMap <String, String> Environment = new HashMap<String, String>();
		public static ArrayList<Object> arlst = new ArrayList<Object>();
		public static ArrayList<Object> catoList = new ArrayList<Object>();

		//dataSheet 
		Sheet Sheet = null;
	
		
	public HashMapNew fGetData(String calendarFile, String testName){
		
		fGetDataForTest(calendarFile, testName);
		return Dictionary;
	}
	public boolean fGetDataForTest(String calendarFile, String testName)
	{
		
		
		//DataSheet
		final String mainSheet = "MAIN"; 
		final String testNameColumn = "ACTION";

		//Clear Dictionary
		Dictionary.clear();
		orgDictionary.clear();

		try{

			//Get column index of test name column
			int iColTestName = fGetColumnIndex(calendarFile, mainSheet, testNameColumn);

			//Iterate through each rows from first sheet
			int iRowCnt = Sheet.getLastRowNum();

			//Loop
			int iRow;
			for(iRow=0;iRow<iRowCnt;iRow++)
			{
				//Get row with test name and exist
				if(Sheet.getRow(iRow).getCell(iColTestName).getStringCellValue().equalsIgnoreCase(testName)) 
					break;
			}

			//Check if test found
			if(iRow == iRowCnt){
				System.out.println("Test with name: " + testName + " not found in datasheet: " +  dataSheet);
				return false;
			}
		
			if(iRow < iRowCnt){ // it will execute only if the test case exists in the excel
				//Retrieve Skip value
				Dictionary.put("SKIP", Sheet.getRow(iRow-1).getCell(fGetColumnIndex(calendarFile, mainSheet, "SKIP")).getStringCellValue());
				if (Dictionary.get("SKIP").isEmpty())
				{
					//Set Header & DataRow
					Row headerRow = Sheet.getRow(iRow-1);
					Row dataRow = Sheet.getRow(iRow);

					//Get Column count for test-1 row
					int iParamCnt = headerRow.getLastCellNum();		 

					String key="";
					String value="";

					//Loop through params
					int iCol;
					for(iCol=0;iCol<iParamCnt;iCol++){

						//Fetch the value for the Header Row
						if (headerRow.getCell(iCol, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) == null)
						{
							key = "";
						}else{
							key = headerRow.getCell(iCol).getStringCellValue();
						}

						//Fetch the value for the Header Row
						if (dataRow.getCell(iCol, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) == null)
						{
							value = "";
						}else{
							value = dataRow.getCell(iCol).getStringCellValue();
						}

						//Check key value
						Dictionary.put(key,value);
						orgDictionary.put(key,value);

					} 	
				}
			}
			//Retrieve Skip value
			// Dictionary.put("SKIP", sheet.getRow(iRow-1).getCell(fGetColumnIndex(dataSheet, mainSheet, "SKIP_" + driverType)).getStringCellValue());
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e + " occured while fetching data from datasheet " + dataSheet + " for test " + testName);
			return false;
		}	
		
	}	
	
	
	public int fGetColumnIndex (String strXLSX, String strSheetName, String strColumnName)
	{
		try
		{
			//Create the FileInputStream object			
			FileInputStream file = new FileInputStream(new File(strXLSX));		     
			//Get the workbook instance for XLS file 
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first sheet from the workbook
			Sheet = workbook.getSheet(strSheetName);

			//Iterate through each rows from first sheet
			Row row = Sheet.getRow(0);

			//Get the Column count
			int iColCount = row.getLastCellNum();
			int iCell = 0;
			int iIndex = -1;
			String strTemp = "";

			//Loop through all the columns
			for (iCell = 0; iCell < iColCount; iCell ++)
			{
				//Get the index for Version and Enviornment
				strTemp = Sheet.getRow(0).getCell(iCell).getStringCellValue().trim().toUpperCase();

				//if the strColumnName contains Header then check for HEADER or HEADER_IND
				if (strColumnName.equals("HEADER_IND") || strColumnName.equals("HEADER"))
				{
					if (strTemp.equals("HEADER") || strTemp.equals("HEADER_IND"))
					{
						iIndex = iCell;
						//Exit the Loop
						break;
					}

				}else{ 
					if (strTemp.equals(strColumnName.trim().toUpperCase()))
					{
						iIndex = iCell;
						//Exit the Loop
						break;
					}
				}
			}
			//Close the file
			file.close();

			//Validate if index is returned properly or not
			if (iIndex != -1)
			{
				return iIndex;

			}else{
				System.out.println("Failed to find the Column Id for Column " + strColumnName);
				return -1;
			}
		}catch (Exception e){
			System.out.println("Got exception while finding the Index column. Exception is " + e);
			return -1;
		}
	}
	
	public static class HashMapNew extends HashMap<String,String>{
		static final long serialVersionUID = 1L;

		@Override
		public String get(Object key){
			String value = super.get(key);
			if (value==null){return "";}
			return value;
		}
	}
	
}
