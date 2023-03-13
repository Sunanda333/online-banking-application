package com.blitzkrieg.service;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EmployeeService {
	private String employeeXmlPath;

	public EmployeeService(String employeeXmlPath) {
		this.employeeXmlPath = employeeXmlPath;
	}

	public boolean validateEmployee(String userName, String password) {
		/*
		 * Used to read through XML file Validate Employee Login
		 * 
		 */
		try {
			File fXmlFile = new File(employeeXmlPath);
			if (!fXmlFile.exists()) {
				throw new FileNotFoundException("XML not present");
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("employees");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String uname = eElement.getElementsByTagName("Name").item(0).getTextContent();
					String pass = eElement.getElementsByTagName("Password").item(0).getTextContent();
					if (uname.equals(userName)) {
						if (pass.equals(password)) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}