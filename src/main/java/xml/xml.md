maven 下resource文件的路径读取问题  
如employees.xml文件位于 resource文件夹下
编译之后该文件位于 target\classes\ 下
 String xmlFile = Main.class.getClassLoader().getResource("employees.xml").getPath() 获取
http://www.wqblog.xyz/2018/08/09/maven-eclipce-java/

2解析xml文件是报错
This parser does not support specification "null" version "null"
缺少jar包 xerces.jar 或者jar包版本不匹配
pom.xml文件中添加
<!-- https://mvnrepository.com/artifact/xerces/xercesImpl -->
<dependency>
    <groupId>xerces</groupId>
    <artifactId>xercesImpl</artifactId>
    <version>2.9.1</version>
</dependency>

版本加以2.7以后

pom.xml文件中：
```xml
  <dependency>
            <groupId>org.jdom</groupId>
            <artifactId>jdom</artifactId>
            <version>2.0.2</version>
        </dependency>

        <dependency>
            <groupId>jaxen</groupId>
            <artifactId>jaxen</artifactId>
            <version>1.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/xerces/xercesImpl -->
        <dependency>
            <groupId>xerces</groupId>
            <artifactId>xercesImpl</artifactId>
            <version>2.9.1</version>
        </dependency>
```

使用步骤：
1、获取文件所在路径
2、打开一个文档（document）
3、使用类方法或者Xpath读取数据
建议根据情况灵活使用
参考链接： https://howtodoinjava.com/xml/jdom2-read-parse-xml-examples/

如何写入信息到XML文件
打开文件所在路径
打开一个文件document
获取需要添加元素的父元素
创建新的元素并经该元素添加至父元素
获取文件输出流
document格式化并输出到输出流