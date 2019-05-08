package sql.jdbc;


import java.sql.*;

//不进行任何封装，一步一步测试JDBC连接数据库的过程
public class JDBCDemo {
    public static void  main(String[] args){
     String URL="jdbc:mysql://10.27.143.11:3306/test?useUnicode=true&characterEncoding=utf8";
     String sql="select * from goods";
     Connection conn=null;
     PreparedStatement pstmt=null; //注意此处是java.sql中的类而不是jdbc中的
        ResultSet result=null;
        try {
            //1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、通过URL user password 建立连接
            conn= DriverManager.getConnection(URL,"root","1462141540");
            //3、输入sql语句
            pstmt=conn.prepareStatement(sql);
            //4、执行sql语句
            result=pstmt.executeQuery();
            while (result.next()){
                Good good=new Good();
                good.setGid(result.getInt("gid"));
                good.setGname(result.getString("gname"));
                good.setGprice(result.getFloat("gprice"));
                good.setGnum(result.getInt("gnum"));
                System.out.println(good.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
              if(result!=null)
                 result.close();
              if(pstmt!=null)
                pstmt.close();
              if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
