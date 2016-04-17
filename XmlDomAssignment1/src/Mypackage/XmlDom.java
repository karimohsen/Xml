/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mypackage;

import java.io.IOException;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author Karim
 */
public class XmlDom {
    public void thirdmethod(){
        try {
            DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = build.newDocumentBuilder();
            Document doc = docBuild.parse(getClass().getResource("intro.xml").toString());
            NodeList list = doc.getElementsByTagName("message");
            for(int i = 0 ; i < list.getLength() ;i++){
                list.item(i).getFirstChild().setNodeValue("hi");
            }
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer transformer = trans.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("D:\\file3.xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void secondmethod(){
    try {
            DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = build.newDocumentBuilder();
            Document doc = docBuild.parse(getClass().getResource("intro.xml").toString());
            NodeList list = doc.getElementsByTagName("message");
            for(int i = 0 ; i < list.getLength() ;i++){
                Node n = doc.createTextNode("hi");
                list.item(i).replaceChild(n,list.item(i).getFirstChild());
            }
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer transformer = trans.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("D:\\file2.xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void firstmethod(){
        try {
            DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = build.newDocumentBuilder();
            Document doc = docBuild.parse(getClass().getResource("intro.xml").toString());
            NodeList list = doc.getElementsByTagName("message");
            for(int i = 0 ; i < list.getLength() ;i++){
               list.item(i).setTextContent("hi");
            }
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer transformer = trans.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("D:\\file1.xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlDom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public XmlDom(){
        firstmethod();
        secondmethod();
        thirdmethod();
    }
    public static void main (String[] args){
        new XmlDom();
    }
}
