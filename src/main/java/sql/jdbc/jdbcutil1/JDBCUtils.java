package sql.jdbc.jdbcutil1;

import sql.jdbc.Good;

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
            conn= DriverManager.getConnection(DataSource.URL, DataSource.USER, DataSource.PASSWORD);
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
    public static  int executeUpdate(String sql,Object ...params){
        int result=0;
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            conn=getConnection();
            preparedStatement=conn.prepareStatement(sql);
           for(int i=0;i<params.length;i++){
               preparedStatement.setObject(i+1,params[i]);
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
    public static <T>List<T> executeQuery(String sql,RowMap<T> rowMap,Object ...params){
        List<T> result=new ArrayList<T>();
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            conn=getConnection();
            preparedStatement=conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
           resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //使用哪类对象接收，工具类其实是不应该知道的
                T t=rowMap.rowMapping(resultSet);
                result.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,conn);
        }
        return  result;
    }

}
