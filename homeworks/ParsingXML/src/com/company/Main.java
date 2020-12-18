package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.naming.Name;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

//https://www.youtube.com/watch?v=w3WibDOie1Y&ab_channel=CodingSimplified

/*
* get the document builder
* get document
* normalize the .xml structure
* get all the element by tag name
* */

public class Main {

    public static void main(String[] args) {

        //get the document builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //get document

        DocumentBuilder builder;

        {
            try {
                builder = factory.newDocumentBuilder();

                try {
                    Document document = builder.parse(new File("src/com/company/values.xml"));

                    document.getDocumentElement().normalize();

                    // normalize the .xml structure

                    NodeList valuesList = document.getElementsByTagName("Valutes");

                    //get all the element by tag name

                    for(int i = 0; i < valuesList.getLength(); i++){
                        Node valutes = valuesList.item(i);
                        if(valutes.getNodeType() == Node.ELEMENT_NODE){
                            Element valutElement = (Element) valutes;
                            System.out.println("Valutes Name: " + valutElement.getTagName());

                            NodeList valuteDetails = valutes.getChildNodes();
                            for (int j = 0; j <valuteDetails.getLength(); j++) {
                                Node details = valuteDetails.item(j);
                                if(details.getNodeType() == Node.ELEMENT_NODE){
                                    Element detilesElement = (Element) details;
                                    //add By Me
                                    //if(valuteDetails.item(j).getNodeType() == "Гонконгских долларо") {
                                    //if(detilesElement.getTagName() == "Гонконгских долларо"){
                                        System.out.println("   " + detilesElement.getTagName() + "  " + detilesElement.getTextContent()); //getAttribute(name:"value");
                                   // }
                                    }
                            }
                        }
//                        System.out.println("______________Valute 'Гонконгских долларо' is :");
//                        for (int j = 0; j <valuteDetails.getLength(); j++) {
//                            Node details = valuteDetails.item(j);
//                            if(details.getNodeType() == Node.ELEMENT_NODE){
//                                Element detilesElement = (Element) details;
//                                //add By Me
//                                //if()
//                                System.out.println("   " + detilesElement.getTagName() + "  " + detilesElement.getTextContent()); //getAttribute(name:"value");
//                            }
//                        }
                    }
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }
}
