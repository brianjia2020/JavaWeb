package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1(){
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/books.xml");
            System.out.println(document);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /*
     * read books.xml to generate Book class
     */
    @Test
    public void test2(){
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/books.xml");
            Element rootElement = document.getRootElement();
            //System.out.println(rootElement);
            List<Element> books = rootElement.elements("book");
            for(Element book: books){
                //System.out.println(book.asXML());
                String priceText = book.elementText("price");
                String authorText = book.elementText("author");
                String snText = book.attributeValue("sn");
                String nameText = book.elementText("name");
                System.out.println(new Book(snText,nameText,authorText, BigDecimal.valueOf(Double.parseDouble(priceText))));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
