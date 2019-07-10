该包下保存的是web基础学习  
##### 普通项目转换为maven项目的方法：  
项目->右键->add framework support->maven
##### 将spring项目更改为支持web的项目
file->project structure->module-> + -> web  
![supportweb](https://github.com/wongkee/images/blob/master/spring_note/webbasic/supportweb.jpg) 
##### 配置tomcat
![tomcat](https://github.com/wongkee/images/blob/master/spring_note/webbasic/tomcatconfig.jpg)
![tomacat](https://github.com/wongkee/images/blob/master/spring_note/webbasic/tomcatconfig2.jpg)  


##### Servlet
1、概念：  
处理URL请求的组件交Servlet
2、实现：  
三要素：  
1. 实现一个Servlet必须继承HttpServlet；  
2. 必须指明该Servlet要处理的是哪个请求地址；  
       a.  web,xml  
       b. 注解
3. 如何处理请求：代码入口---重写service方法    
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    req携带请求信息  
    resp携带响应信息  
    


HttpServlet找不到的解决方法：  
File->Project Structure -> Libraries->+   
将本地tomcat的lib目录下 servlet-api.jar导入，如果使用jsp 也需要导入 jsp-api.jar.  
