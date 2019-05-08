package sql.jdbc.jdbcutil;

import sql.jdbc.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static  void main(String args[]){
        String sql="select * from goods";
        List<Good> goods=JDBCUtils.executeQuery(sql);
        for(Good good:goods){
            System.out.println(good);
        }
    }
}
