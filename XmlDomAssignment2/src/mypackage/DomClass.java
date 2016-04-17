/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Karim
 */
public class DomClass {
    public DomClass(){
        try {
            DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = build.newDocumentBuilder();
            Document doc = docBuild.newDocument();
            Element father = doc.createElement("father");
            father.setAttribute("name", null);
            doc.appendChild(father);
            Element child = doc.createElement("child");
            child.setAttribute("order", null);
            Element n = doc.createElement("name");
            Node nn = doc.createTextNode("text");
            child.appendChild(n);
            n.appendChild(nn);
            father.appendChild(child);
            Element job = doc.createElement("job");
            job.setAttribute("title", null);
             nn = doc.createTextNode("text");
            job.appendChild(nn);
            father.appendChild(job);
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer transformer = trans.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("D:\\file4.xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DomClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DomClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DomClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public static void main(String[] args){
        new DomClass();
    }
}
