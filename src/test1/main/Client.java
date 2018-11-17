package test1.main;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.Element;
import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.w3c.dom.Document;

import test1.model.Student;

public class Client {


	public static void main(String[] args) {
		Student s1= new Student(101,"John","john@example.com","RedWood Shores");


		try {
			//	DOM API's		
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.newDocument();
			
			//generating tags
			org.w3c.dom.Element rootElm= document.createElement("students");
			org.w3c.dom.Element studentElm=document.createElement("student");
			org.w3c.dom.Element rollElm=document.createElement("roll");
			org.w3c.dom.Element nameElm=document.createElement("name");
			org.w3c.dom.Element emailElm=document.createElement("email");
			org.w3c.dom.Element addressElm=document.createElement("address");
			
			//generating tags data
			
			Text txtroll=document.createTextNode(String.valueOf(s1.roll));
			Text txtname=document.createTextNode(s1.name);
			Text txtemail=document.createTextNode(s1.email);
			Text txtaddress=document.createTextNode(s1.address);
			
			//setting data within tags
			rollElm.appendChild(txtroll);
			nameElm.appendChild(txtname);
			emailElm.appendChild(txtemail);
			addressElm.appendChild(txtaddress);
			
			studentElm.appendChild(rollElm);
			studentElm.appendChild(nameElm);
			studentElm.appendChild(emailElm);
			studentElm.appendChild(addressElm);
			
			rootElm.appendChild(studentElm);
			 document.appendChild(rootElm);
			
			File file=new File("/Users/balindrarayamajhi/Desktop/mum/WAP/xmlthings/StudentsGerenarated.xml");
			FileOutputStream fos =new FileOutputStream(file);
			StreamResult result=new StreamResult(fos);
			
			//StreamResult result =new StreamResult(file);
			 DOMSource source=new DOMSource(document);
			 
			 //transfer DOMSource into Stream
			 
			 Transformer transformer=TransformerFactory.newInstance().newTransformer();
			 transformer.transform(source, result);
			 
			 
			 System.out.println(file.getName()+" is generated");
			 
			 
			 
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
