import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTxt {

	public void ReadTxt(String filePath) throws IOException   {
		
		File file=new  File(filePath);
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line=null;
		int lineNum=1;
		
		while(br.readLine() != null) {
			
			line = br.readLine();
					
			System.out.println(line);
			
			if (line.compareToIgnoreCase("second")==0) {
				System.out.println(" Match Found ");
				
				//System.out.println("at line "+br.lines().count());					
			}
			lineNum++;
		}
		
	}
	
}
