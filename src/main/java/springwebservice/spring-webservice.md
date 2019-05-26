一、Spring Web Service的特色：  
1、强大的映射功能，可将传入的XML请求根据要求分发给任何对象  
2、Spring对XML的支持  DOM  SAX StaX等  
3、灵活的XML编组（XML/对象转换）  
4、支持Spring 上下文等  
5、WS-Security 安全机制  
6、Spring Security 集成  
7、Apache许可证  
二、 运行环境  
java7以上  
Spring4.09以上  
项目结构：  
XML模块：用于Spring Web Service的各种XML支持类，这些类主要用于Spring-WS框架本身，而不是Web开发人员
Core模块：核心部分，Web Service服务器端的主要实现  
Support模块：对其他传输模块的支持，JMS，电子邮件等其他方式
安全模块：对WS-Security的封装。  
三、实现一个合同优先的 Web Service  
非合同优先的缺点：  
1、对象 XML转换时不匹配问题    
2、XSD 继承无法使用  
3、类型不匹配  java的Treemap转换为XML 在其他语言中无法使用，因为那是java独有的数据类型  
4、循环嵌套，java中类之间如果有相互调用，那么根据对象生成XML的时候就会一直循环下去，大大的浪费了资源  
 
 合同优先的好处：
 脆弱性：     
如果使用合同后置的方法 WSDL和XSD都是有java合同产生的（一般为java接口），每次java代码的更改都会导致合同的更改，客户端就得重新生成。  
此外并不是所有的SOAP栈都产生相同的web service 合同，这就意味着SOAP栈的改变可能会意味着你的合同发生了改变
所以使用合同优先可以尽可能的保证合同长久不变。
性能：  
使用java自动生成xml，我们无法确定传送的信息，对象与对象之间相关联，虚拟机中一般的对象都被转换为XML，导致响应很慢。
复用性：  
定义好的XSD可在多个地方复用，也可被其它的XSD引用  
版本控制：  
当必须更改合同的时候，重新new一个接口，并对其进行实现，然后发布为服务。原来的服务保持不变，以供客户迁移之前使用户。  

四、 完成合同优先的web service   
1、契约书写  
2、java代码实现  
有四种不同的方法定义XML契约：  
DTDs：dtd具有有限的名称空间支持，因此不适合Web服务
XML Schema (XSD)：将使用这种方式
RELAX NG：在跨平台没有得到广泛的支持  
Schematron：不考虑  
最好的创建XSD的方式是修改它的模板文件


tomcat配置参考webasic.md
需解决的问题
1、endpoint到底有何用
2、如何发布自己想要发布的东西，如指定的接口等


xsd基本语法

xml解析工具的使用