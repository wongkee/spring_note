package xml;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import static xml.SaxParser.getSAXParsedDocument;

public class XPathRead {
    public  static  void  main(String args[]){
        /*
        *To read any set of element’s value using xpath, You need to compile XPathExpression and use it’s evaluate() method.
        * */
        String xmlFile = Main.class.getClassLoader().getResource("employees.xml").getPath();
        Document document = getSAXParsedDocument(xmlFile);
        XPathFactory xpfac = XPathFactory.instance();
//Read employee ids  读取属性
        XPathExpression<Attribute> xPathA = xpfac.compile("//employees/employee/@id", Filters.attribute());

        for (Attribute att : xPathA.evaluate(document))
        {
            System.out.println("Employee Ids :: " + att.getValue());
        }
//测试读取name属性
        /*
        * Employee name :: a
           Employee name :: b
        * */
        XPathExpression<Attribute> xPathB = xpfac.compile("//employees/employee/@name", Filters.attribute());
        for (Attribute att : xPathB.evaluate(document))
        {
            System.out.println("Employee name :: " + att.getValue());
        }
//Read employee first names  读取子元素
        XPathExpression<Element> xPathN = xpfac.compile("//employees/employee/firstName", Filters.element());

        for (Element element : xPathN.evaluate(document))
        {
            System.out.println("Employee First Name :: " + element.getValue());
        }

        //测试读取Last name
        XPathExpression<Element> xPathL = xpfac.compile("//employees/employee/lastName", Filters.element());

        for (Element element : xPathL.evaluate(document))
        {
            System.out.println("Employee Last Name :: " + element.getValue());
        }
    }

}
