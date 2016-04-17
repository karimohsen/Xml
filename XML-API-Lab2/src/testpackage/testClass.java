/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testpackage;

import demo.MyMsg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Karim
 */
public class testClass {
    public testClass(){
        try {
            JAXBContext con = JAXBContext.newInstance("demo");
            Unmarshaller unmarsh  = con.createUnmarshaller();
            File f =new File("D:\\ITI\\Api For Xml\\xml\\xml.xml");
            MyMsg msg = (MyMsg)unmarsh.unmarshal(f);
            System.out.println("Msg "+msg.getHeader());
            List<MyMsg.Msg> ms = msg.getMsg();
            for(int i = 0 ; i < ms.size() ; i++){
                ms.get(i).setBody("test");
                ms.get(i).setFrom("tetform");
                ms.get(i).setDate("date");
                
            }
            
            Marshaller marsh = con.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marsh.marshal(msg, new FileOutputStream("D:\\output.xml"));
            
        } catch (JAXBException ex) {
            Logger.getLogger(testClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new testClass();
    }
}
