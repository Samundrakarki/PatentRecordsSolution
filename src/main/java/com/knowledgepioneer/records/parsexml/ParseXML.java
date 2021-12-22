package com.knowledgepioneer.records.parsexml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.knowledgepioneer.records.entity.Records;

/**
 * ParseXML is a concerete class that is used to parse the XML file.
 * 
 * */

@Component
public class ParseXML{
	

	/**
	 * This method is used to parse the xml file and set the records fields
	 * 
	 * @param file xml file to be parse
	 * @param record patent record object which needs to be assigned to their respective 
	 * 			values from xml
	 * 
	 * */
	public void parseXMLFiles(File file, Records record) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList application = doc.getElementsByTagName("application-reference");
			NodeList title = doc.getElementsByTagName("bibliographic-data");
			NodeList abstract_ = doc.getElementsByTagName("questel-patent-document");
			
			Node recordsInfo = application.item(0);
			Node titleData = title.item(0);
			Node abstractData = abstract_.item(0);
			
			
 			
			if(recordsInfo.getNodeType() == Node.ELEMENT_NODE 
					|| titleData.getNodeType() == Node.ELEMENT_NODE
					|| abstractData.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) recordsInfo;
				Element e1 = (Element) abstractData;
				Element e2 = (Element) titleData;
				
				String country = e.getElementsByTagName("country")
			                  .item(0)
			                  .getTextContent();
					
					String date = e.getElementsByTagName("date")
			                  .item(0)
			                  .getTextContent();
					String abstract__ = e1.getElementsByTagName("abstract")
			                  .item(0)
			                  .getTextContent();
					String invention_title = e2.getElementsByTagName("invention-title")
			                  .item(0)
			                  .getTextContent();
					
					record.setCountry(country);
					record.setYear(date);
					record.setAbsract(abstract__.trim());
					record.setTitle(invention_title.trim());

			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
