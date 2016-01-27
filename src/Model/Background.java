package Model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Background {

	private String DIRECTORY = "Assets/";
	private Document xmlDoc;
	private Map map;
	
	public Background(){
	
		xmlDoc =  loadXMLFile("test-map.tmx");
		initialiseMap(xmlDoc);

		System.out.println(map.getHeight());
		System.out.println(map.getWidth());
	}
	
	private void initialiseMap(Document xmlDoc){
		
		map = new Map();
		NodeList nodeList = xmlDoc.getElementsByTagName("map");
		
		if(nodeList.item(0).hasAttributes()){
			NamedNodeMap nMap = nodeList.item(0).getAttributes();
			for(int i=0; i<nMap.getLength(); i++){
				addMapAttribute(nMap.item(i));
				System.out.println(nMap.item(i).getNodeName());	
			}
		}
	}
	
	private void addMapAttribute(Node attribute){
		
		switch (attribute.getNodeName()) {
		
			case "width"	: map.setWidth(Integer.parseInt(attribute.getNodeValue()));
				break;
            case "height"	: map.setHeight(Integer.parseInt(attribute.getNodeValue()));
            	break;
            case "tilewidth": map.setTilewidth(Integer.parseInt(attribute.getNodeValue()));
            	break;
            case "tileheight":map.setTileheight(Integer.parseInt(attribute.getNodeValue()));
            	break;
		}
	}
	
	private void initialiseTilesets(Document xmlDoc){
		
		NodeList nodeList = xmlDoc.getElementsByTagName("tileset");
		
		for(int i=0; i<nodeList.getLength(); i++){
			Node nNode = nodeList.item(i);
       	 	System.out.println("\nCurrent Element :" + nNode.getNodeName());
       	 	
       	 	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
       	 		Element eElement = (Element) nNode;
       	 		System.out.println(eElement.getAttribute("width"));
           }
        }
		
	}
	private void initialiseLayers(Document xmlDoc){
		
	}
	
	private Document loadXMLFile(String fileName){
		
		Document doc = null;
		try{ 
			File inputFile = new File(DIRECTORY + fileName);
			System.out.println("Loading File: "+ fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			//nList = doc.getElementsByTagName("student");
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return doc;
	}
	
	private void loadXML(String fileName){

	    try{
	    	 
	        File inputFile = new File(DIRECTORY + fileName);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	         
	        doc.getDocumentElement().normalize();
	         
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         
	        NodeList nList = doc.getElementsByTagName("student");
	         
	        System.out.println("----------------------------");
	         
	        for(int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	        	 System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        	 
	        	 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        		 Element eElement = (Element) nNode;
	        		 System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
	        		 System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
	        		 System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
	        		 System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
	        		 System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
	            }
	         }
	     }catch (Exception e) {
	         e.printStackTrace();
	     }
	}

	private void printArray(ArrayList<String> array){
		for(int i=0; i<array.size(); i++){
			System.out.println(array.get(i));
		}
	}
}
