package xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void  main(String args[]) throws IOException {

//打开文档
       String xmlFile = Main.class.getClassLoader().getResource("employees.xml").getPath();
        //String xmlFile="E:/eclipce_workspace/spring_note/target/classes/employees.xml";
        Document document = SaxParser.getSAXParsedDocument(xmlFile);
       //获取根元素
        Element rootNode = document.getRootElement();
        System.out.println("Root Element :: " + rootNode.getName());
        

        /*
        *
        *
        * forEach
        * java8的新特性 将列表中的每一个元素都调用该行为
        * 该行为该以什么样的方法定义？
        *1、可以是lambda表达式
        *    rootNode.getChildren("employee").forEach((e)->{
                     System.out.println(e.getAttributeValue("id"));
             });

           2、也可以使用方法引用语法
           rootNode.getChildren("employee").forEach( Main::readEmployeeNode );
        *  @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         * @since 1.8
         * default void forEach(Consumer<? super T> action) {
              Objects.requireNonNull(action);
               for (T t : this) {
                  action.accept(t);
              }
             }
        * */
        //读取属性值
       rootNode.getChildren("employee").forEach( Main::readEmployeeNode );
    /*   List<Element> list= rootNode.getChildren("employee");
       for (Element e:list){
         System.out.println(e.getAttributeValue("id"));
       }
*/

    }

    private static void readEmployeeNode(Element employeeNode)
    {
        //Employee Id  获取属性值  <employee id="101">
        System.out.println("Id : " + employeeNode.getAttributeValue("id"));
        //读取元素值
        //First Name
        System.out.println("FirstName : " + employeeNode.getChildText("firstName"));
        //First Name
        System.out.println("FirstName : " + employeeNode.getChildText("firstName"));
        //Last Name
        System.out.println("LastName : " + employeeNode.getChildText("lastName"));

       //Country   与getChildText效果一样
        System.out.println("country : " + employeeNode.getChild("country").getText());
        /**Read Department Content 与获取父元素的时候方法一样  */
        employeeNode.getChildren("department").forEach( Main::readDepartmentNode );
    }
    private static void readDepartmentNode(Element deptNode)
    {
        //Department Id
        System.out.println("Department Id : " + deptNode.getAttributeValue("id"));

        //Department Name
        System.out.println("Department Name : " + deptNode.getChildText("name"));
    }
}
