package webbasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//,loadOnStartup = 1    服务启动就实例化
@WebServlet(value = "/main",loadOnStartup = 1)
public class DemoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //loadOnStartup = 1    服务启动就会调用该方法，否则只有访问到该网页时
        System.out.println("init方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    super.doPost(req, resp);
        System.out.println(req.getParameter("name"));
        System.out.println("post");
    }

 /*   @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println("servie");
       System.out.println(req.getContentType());
        System.out.println(req.getContextPath());//spring_note,跟配置tomcat的时候设置的contextpath一致

      //获取响应的输出流，并且把响应的信息写入到输出流
        PrintWriter writer=resp.getWriter();
        writer.println("Hello Servlet!");
    }*/
}
