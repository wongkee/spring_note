package sql.jdbc.jdbcutil;

import sql.jdbc.Good;

import java.awt.print.PrinterAbortException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//JDBC的工具类，提供获取/关闭数据库链接，增删改查等通用操作
public class JDBCUtils {
  // 获取数据库连接
    public static Connection getConnection(){
        Connection conn=null;
        try {
            //1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、通过URL user password 建立连接
            conn= DriverManager.getConnection(DataSource.URL,DataSource.USER,DataSource.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接
    public static  void closeAll(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        try {
            //关闭连接需要以打开连接顺序相反的顺序关闭
            if(resultSet!=null)
                resultSet.close();
            if(preparedStatement!=null)
                preparedStatement.close();
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //增删改
 //   public static int executeUpdate(String sql){
    public static  int executeUpdate(String sql,List<Object> params){
        int result=0;
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            conn=getConnection();
            preparedStatement=conn.prepareStatement(sql);
            //每次数据库操作这里都要修改数据，这不符合工具类的要求，所以要将这些数据作为参数传递进来，但是参数的个数、数据类型都是不确定的，这里改如何解决呢？
            /*
            * 1、参数的个数不确定，可以采用动态数组 ArrayList.
            * 2、数据类型不确定，可以向上转型，统统采用Object接收
            * */
           /*
           //注意此处的下标是从1开始
           preparedStatement.setString(1,"book");
            preparedStatement.setFloat(2,100);
            preparedStatement.setInt(3,30);*/
           for(int i=0;i<params.size();i++){
               preparedStatement.setObject(i+1,params.get(i));
           }
            result=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,conn);
        }
        return 0;
    }
    //查询操作
    public static List<Good> executeQuery(String sql,List<Object> params){
        List<Good> goods=new ArrayList<Good>();
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            conn=getConnection();
            preparedStatement=conn.prepareStatement(sql);
           /* preparedStatement.setString(1,"price");*/
            for(int i=0;i<params.size();i++){
                preparedStatement.setObject(i+1,params.get(i));
            }
           resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Good good=new Good();
                good.setGid(resultSet.getInt("gid"));
                good.setGname(resultSet.getString("gname"));
                good.setGprice(resultSet.getFloat("gprice"));
                good.setGnum(resultSet.getInt("gnum"));
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,conn);
        }
        return  goods;
    }

}
