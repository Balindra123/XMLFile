package test1.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMParserDemo {

	public static void main(String[] args) {
		try {
			File file=new File("/Users/balindrarayamajhi/Desktop/mum/WAP/xmlthings/students.xml");
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.parse(file);
			System.out.println("Root Elemnet "+document.getDocumentElement().getNodeName());
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
