import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;



public class IOXml {
	
	org.w3c.dom.Document doc = null ; 
	
	public void XMLreader(String filePath) throws SAXException, IOException, ParserConfigurationException {
		File file = new File(filePath); //creates a file in buffer 
		DocumentBuilderFactory.newInstance();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); //creates a new document builder factory instance
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); // creates a new document builder for the builder factory instance
		doc = docBuilder.parse(file); // creates a document from the above created builder instance and parse the input file
		
	}

}
