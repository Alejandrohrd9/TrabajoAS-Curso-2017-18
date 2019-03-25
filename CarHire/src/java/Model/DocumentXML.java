package Model;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author alejandrohd
 */
public class DocumentXML {
    
    public  static Document createDocumentXML(Document document){
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            
            Element es = document.createElement("employees");
            Element e = document.createElement("employee");
            Element n = document.createElement("name");
            Element u = document.createElement("username");
            Element r = document.createElement("role");
            
            Text nValue = document.createTextNode("Antonio José López Santos");
            Text uValue = document.createTextNode("comercialAJ");
            Text rValue = document.createTextNode("Comercial");
            
            
            document.setXmlVersion("1.0"); 
            document.getDocumentElement().appendChild(es);
            es.appendChild(e);
            
            e.appendChild(n);
            e.appendChild(u);
            e.appendChild(r);
            
            n.appendChild(nValue);
            u.appendChild(uValue);
            r.appendChild(rValue);
                    
        } catch (Exception e) {

        }
        return document;
    }
    
    
    public static Document getDocumentFromXMLString (String xml) throws SAXException, ParserConfigurationException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xml))); 
    }
    
}
