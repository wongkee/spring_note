package xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XMLWrite {
    public static  void main(String args[]) throws IOException {
        String xmlFile = Main.class.getClassLoader().getResource("employees.xml").getPath();
        Document document=SaxParser.getSAXParsedDocument(xmlFile);
        Element rootNode=document.getRootElement();
        Element employee=new Element("employee");
        employee.setAttribute("id","103");
        Element firtname=new Element("firstName");
        firtname.setText("zhang");
        Element lastname=new Element("lastName");
        lastname.setText("san");
        Element country=new Element("country");
        country.setText("china");

        Element department=new Element("department");
        department.setAttribute("id","3");
        Element name=new Element("name");
        name.setText("LLL");
        department.setContent(name);


        employee.addContent(firtname).addContent(lastname).addContent(country).addContent(department);
        rootNode.addContent(employee);
        FileOutputStream fileOutputStream=new FileOutputStream(xmlFile);
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        //xmlOutputter.output(document, System.out);
        xmlOutputter.output(document, fileOutputStream);
        fileOutputStream.close();
    }
}
